package jpaShop.domain

import javax.persistence.*

@Entity
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName =  "MEMBER_SEQ",   //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 10
)
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name = "member_id")
    val id: Long = 0L,

    var name: String = "",

    var city: String = "",

    var street: String = "",

    var zipcode: String = ""

    // mappedBy 가 설정되어 있으면 조회만 된다. //설계시에는 @ManyToOne 만 (단방향) 해줘도 된다.
//    @OneToMany(mappedBy = "member")
//    var orders: MutableList<Order> = mutableListOf()
)