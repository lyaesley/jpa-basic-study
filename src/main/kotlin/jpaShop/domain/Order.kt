package jpaShop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
@SequenceGenerator(
    name = "ORDER_SEQ_GENERATOR",
    sequenceName =  "ORDER_SEQ",   //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 10
)
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "order_id")
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member? = null,

    @OneToMany(mappedBy = "order")
    var orderItems: MutableList<OrderItem> = mutableListOf(),

    var orderDate: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.ORDER
) {
    fun addOrderItem(orderItem: OrderItem) {
        orderItem.order = this
        orderItems.add(orderItem)
    }
}
