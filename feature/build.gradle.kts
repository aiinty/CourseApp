plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.aiinty.feature"
    compileSdk = 35
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:account"))
    implementation(project(":feature:favorites"))
    implementation(project(":feature:login"))
}