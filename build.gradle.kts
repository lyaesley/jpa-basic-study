plugins {
    val kotlinVersion = "1.3.71"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

group = "org.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

// kotlin에서 클래스는 기본 final이기 때문에 JPA에서 지연로딩시 entity를 상속받아 처리하는 proxy를 이용할 수 없다.
// 즉, 지연로딩을 할 수 없다. 이를 해결해주는 컴파일러 플러그인이다. 모든 entity를 open시켜준다.
/*allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}*/

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    /**
     * note: hibernate-entitymanager 을 지정하면 다른 라이브러리들을 자동으로 포함시킴 (아래 라이브러리가 포함되어야 한다)
     * org.hibernate.core / org.hibernate.common / javax.persistence (JPA 인터페이스) / ..
     */
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
    implementation("org.hibernate:hibernate-entitymanager:5.4.12.Final")
    // H2 데이터베이스 로컬에 설치한 H2 버전과 맞추는게 좋다
    implementation("com.h2database:h2:1.4.200")

}

/*buildscript {
    dependencies {
        // JPA entity들은 기본적으로 기본생성자가 필요하다. 하지만 주 생성자가 존재하면 기본생성자가 없다.
        // @Entity가 붙은 클래스들에 한해서 자동으로 인자없는 생성자를 추가해준다.
        classpath ("org.jetbrains.kotlin:kotlin-noarg")
    }
}*/

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}