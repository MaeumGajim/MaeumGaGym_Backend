plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

group = "com.info"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":maeumgagym-application"))
    implementation(project(":maeumgagym-core"))
    implementation(project(":maeumgagym-presentation"))

    implementation(Dependencies.SPRING_WEB)
    implementation(Dependencies.SPRING_SECURITY)
    implementation(Dependencies.JWT)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}