package hellojpa

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Member(
    @Id
    val id: Long = 0L,
    val name: String = ""
)