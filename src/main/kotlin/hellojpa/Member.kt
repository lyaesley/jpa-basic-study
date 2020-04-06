package hellojpa

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName =  "MEMBER_SEQ",   //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 50
)   // allocationSize (default:50) 성능 최적화에 사용됨 시퀀스 한번 호출에 증가하는 수
    // DB 에 설정되어 있는 증가값으로 일치 시켜야 한다
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    val id: Long = 0L,

    @Column(name="name")
    val userName: String = "",

    @Column
    val age: Int = 0,

//    @Enumerated(EnumType.ORDINAL)   : 순서를 저장(기본값)
//    @Enumerated(EnumType.STRING)    : 열거형 이름을 그대로 저장, 가급적 이것을 사용
    @Enumerated(EnumType.STRING)
    val roleType: RoleType = RoleType.USER,

    @Temporal(TemporalType.TIMESTAMP)
    val createDate: Date = Date(),

    val lastModifiedDate: LocalDateTime = LocalDateTime.now(),

//    자바 1.8 이상에서는 @Temporal(TemporalType.TIMESTAMP) 어노테이션 없이 LocalDate, LocalDateTime 타입을 사용하면 된다.
//    val testLocalDate: LocalDate = LocalDate.now(),

//    val testLocalDateTime: LocalDateTime = LocalDateTime.now(),

    @Lob
    val description: String = ""

)