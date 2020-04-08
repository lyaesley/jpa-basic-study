//package hellojpa
//
//import javax.persistence.EntityManager
//import javax.persistence.EntityManagerFactory
//import javax.persistence.EntityTransaction
//import javax.persistence.Persistence
//
//fun main() {
//    // 아래는 JPA 정석 로직이다!
//    /**
//     * note:
//     * EntityManagerFactory 는 서버 띄울때 딱 1번만 띄운다. JPA 매니저라고 생각하면 된다.
//     * EntityManagerFactory 는 하나만 생성해서 애플리케이션 전체에서 공유
//     * EntityManager 쓰레드간에 공유하면 안된다.(사용하고 버려야한다) (DB 커넥션 당 묶이기 때문이다) (스프링에서는 알아서 해준다)
//     * 트랜잭션 단위, DB 커넥션을 맺고 query 를 날리고 종료하는 일관적인 단위를 할때마다 em 을 만든다.
//     * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
//     */
//
//    // note: 파라미터 hello 는 persistence.xml 에 <persistence-unit name="hello"> 에 설정한 정보를 매핑한다.
//    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("hello")
//
//    // note: EMF 에서 EntityManager 를 꺼낸다. EntityManager 자체가 jpa 라고 생각해도 된다.
//    val em: EntityManager = emf.createEntityManager()
//    val tx: EntityTransaction = em.transaction
//    tx.begin()
//
//    try {
//        val member = Member1()
//        val member2 = Member1()
//        em.persist(member)
//        em.persist(member2)
//        tx.commit()
//    } catch (e: Exception) {
//        tx.rollback()
//    } finally {
//        em.close()
//    }
//
//    emf.close() // emf 닫기
//
//}