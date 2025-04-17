// build.gradle.kts
import com.github.davidmc24.gradle.plugin.avro.GenerateAvroJavaTask

// 무조건 최상단에 있어야 함. gradle 이 build script 를 parsing 할 때 가장 먼저 필요함
plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21"
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
    id("com.diffplug.spotless") version "6.25.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
    application
}

// java {}, kotlin {}: 보통 plugins 다음, dependencies 이전에 작성되면 자연스러움
// Java 소스는 Gradle의 Java 설정을 따라감: 21
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

// Kotlin 바이트코드 버전은 JVM Target 설정에 따라 결정: 21
kotlin {
    jvmToolchain(21)
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint("1.2.1") // ✅ Kotlin 2.0.21 지원 가능 버전
    }

    kotlinGradle {
        target("*.gradle.kts")
        ktlint("1.2.1")
    }
}

detekt {
    buildUponDefaultConfig = true // 기본 룰을 기반으로
    allRules = false // 실험적인 룰은 제외
    config.setFrom(files("config/detekt/detekt.yml")) // 또는 생략 가능
    baseline = project.layout.projectDirectory.file("detekt-baseline.xml").asFile
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.apache.avro:avro:1.12.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// Avro schema directory 설정
tasks.withType<GenerateAvroJavaTask>().configureEach {
    setSource("src/main/avro")
}

// 보통 plugin에 의해 정의된 디렉토리를 참조해야 하므로 plugin 이후에 정의해야 함
// 생성된 Avro Java 소스를 IDE 가 인식하도록 설정
sourceSets["main"].java.srcDir("build/generated-main-avro-java")

tasks.test {
    useJUnitPlatform()
}

// plugin 이 적용된 후에만 사용 가능 (plugins 블록 이후)
application {
    // 예시: Kotlin main 함수가 있는 경우
    // Kotlin 의 Compiler 가 .kt 파일 이름을 기준으로 Kt postfix 를 붙여 class 이름을 생성
    mainClass.set("com.mong.MainKt")
}
