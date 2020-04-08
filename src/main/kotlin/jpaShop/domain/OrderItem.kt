package jpaShop.domain

import javax.persistence.*

@Entity
@SequenceGenerator(
    name = "ORDERITEM_SEQ_GENERATOR",
    sequenceName =  "ORDERITEM_SEQ",   //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 10
)
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERITEM_SEQ_GENERATOR")
    @Column(name = "order_item_id")
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order? = null,

    @ManyToOne
    @JoinColumn(name = "item_id")
    var item: Item? = null,

    var orderPrice: Int = 0,

    var count: Int = 0
)
