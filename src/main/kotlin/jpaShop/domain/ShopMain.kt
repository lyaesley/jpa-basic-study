package jpaShop.domain

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

fun main() {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("hello")

    // note: EMF 에서 EntityManager 를 꺼낸다. EntityManager 자체가 jpa 라고 생각해도 된다.
    val em: EntityManager = emf.createEntityManager()
    val tx: EntityTransaction = em.transaction
    tx.begin()

    try {

        val member = Member()
        member.name = "이준영"
        member.city = "서울"
        member.street = "한천로"
        member.zipcode = "12345"

        em.persist(member)

        val item = Item()
        item.name = "키보드"
        item.price = 100_000
        item.stockQuantity = 100

        em.persist(item)

        val order = Order()
        order.member = member
        order.status = OrderStatus.ORDER

        em.persist(order)

        val orderItem = OrderItem()
        orderItem.item = item
        orderItem.orderPrice = 100_000
        orderItem.count = 1

        order.addOrderItem(orderItem)

        em.persist(orderItem)

        for (node in order.orderItems){
            println("=================== order.id  = ${node.id}")
        }


        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        em.close()
    }

    emf.close() // emf 닫기
}