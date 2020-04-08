package jpaShop.domain

import javax.persistence.*

@Entity
@SequenceGenerator(
    name = "ITEM_SEQ_GENERATOR",
    sequenceName =  "ITEM_SEQ",   //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 10
)
class Item (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    @Column(name = "item_id")
    val Id: Long = 0L,
    var name: String = "",
    var price: Int = 0,
    var stockQuantity: Int = 0
)
