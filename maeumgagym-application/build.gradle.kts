plugins {
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
    // impl project
    implementation(project(":maeumgagym-core"))
    implementation(project(":maeumgagym-common"))

    // MySQL
    implementation(Dependencies.MYSQL_CONNECTOR)

    // jpa
    implementation(Dependencies.SPRING_DATA_JPA)
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
