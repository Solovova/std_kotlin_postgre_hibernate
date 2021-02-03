plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.hibernate:hibernate-core:5.3.7.Final")
    implementation("org.postgresql:postgresql:42.2.18")
    implementation ("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
    implementation ("org.apache.logging.log4j:log4j-slf4j-impl:2.14.0")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.guava:guava:29.0-jre")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClass.set("std_kotlin_postgre_hibernate.AppKt")
}
