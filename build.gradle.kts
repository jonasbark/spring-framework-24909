import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
    kotlin("plugin.allopen") version "1.3.71"
    kotlin("plugin.noarg") version "1.3.71"
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) {
            bomProperty("kotlin.version", "1.3.71")
        }
    }
}


description = "passusers"
group = "pass.users.api"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}
dependencies {

    implementation(kotlin("stdlib-jdk8"))


    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.71")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.71")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.5")
    implementation("org.springframework.boot:spring-boot-starter-cache:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.2.6.RELEASE")

    testImplementation("com.ninja-squad:springmockk:2.0.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:3.14.7")
    testImplementation("com.squareup.okhttp3:okhttp:3.14.7")
    testImplementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")
    testImplementation("io.projectreactor:reactor-test:3.3.4.RELEASE")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.3.71 (*)")
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.71 (*)")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.3.71")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.71")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.6.RELEASE")

}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<KotlinCompile> {

    sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    targetCompatibility = JavaVersion.VERSION_1_8.toString()

    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=compatibility")
        jvmTarget = "1.8"
    }
}

configurations.all {
    exclude(module = "jakarta.validation-api")
    exclude(module = "hibernate-validator")
}
