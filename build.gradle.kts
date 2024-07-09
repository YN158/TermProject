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
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.mongodb:mongodb-driver-sync:4.4.2")
    implementation ("org.mongodb:mongodb-driver-sync:5.1.1")
    implementation ("ch.qos.logback:logback-classic:1.2.11")
}

tasks.test {
    useJUnitPlatform()
}