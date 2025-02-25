

dependencies {
    // This module is a web module, so we include Spring Boot's Web starter
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":common"))
    // Other module-specific dependencies can be added here
}

// You can also add module-specific configurations if needed.
// For example, if you want to override a default configuration, add a custom task, etc.