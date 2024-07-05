plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.openjfx:javafx-controls:19")
    testImplementation("org.openjfx:javafx-fxml:19")
    implementation("javax.media:jmf:2.1.1e")
    testImplementation("com.sun.media:jmf:2.1.1e")
    implementation("uk.co.caprica:vlcj:4.8.3")
    implementation("org.mongodb:mongodb-driver-sync:5.1.1")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.ai:spring-ai-mongodb-atlas-store-spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    //I genuinely have 0 idea which one of these is needed
}

tasks.test {
    useJUnitPlatform()
}