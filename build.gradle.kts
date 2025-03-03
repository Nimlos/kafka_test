plugins {
    // Declare non-core plugins without applying them to the root project.
    id("org.springframework.boot") version "3.4.3" apply false
    id("io.spring.dependency-management") version "1.1.3" apply false
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"
    
    repositories {
        mavenCentral()
    }
}

subprojects {
    // Apply necessary plugins to subprojects.
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java") // Apply Java plugin to enable dependency configurations

    dependencies {
        // Use 'add' to ensure the dependency is added even if extension methods aren't available yet.
        add("implementation", "org.springframework.boot:spring-boot-starter")
        add("compileOnly", "org.projectlombok:lombok:1.18.28")
        add("annotationProcessor", "org.projectlombok:lombok:1.18.28")
        add("testImplementation", "org.springframework.boot:spring-boot-starter-test")
        add("implementation", "org.springframework.kafka:spring-kafka:3.3.3")
        add("implementation", "org.apache.ignite:ignite-spring:2.17.0")
        add("implementation", "org.reflections:reflections:0.10.2")
        add("implementation", "com.google.protobuf:protobuf-java:4.29.3")
        add("implementation", "com.google.protobuf:protobuf-java-util:4.29.3")

    }

    tasks.withType<Test> {
        // Ensure tests use JUnit Platform (JUnit 5)
        useJUnitPlatform()
    }
}
