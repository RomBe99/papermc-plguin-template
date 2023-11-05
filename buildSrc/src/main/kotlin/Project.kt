import org.gradle.api.JavaVersion

object Project {
    const val GROUP = "com.rombe"
    const val VERSION = "1.0.0"

    object Kotlin {
        const val VERSION = "1.9.20"
    }

    object Java {
        val VERSION = JavaVersion.VERSION_17
        val TARGET_COMPATIBILITY = VERSION
        val SOURCE_COMPATIBILITY = TARGET_COMPATIBILITY
    }
}