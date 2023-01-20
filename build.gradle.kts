import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.6"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id ("org.flywaydb.flyway") version "7.5.2"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.movies"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-aop")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	runtimeOnly("mysql:mysql-connector-java")
	// アプリケーション起動時に自動でマイグレーション
	// implementation("org.flywaydb:flyway-core:6.5.7")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.ninja-squad:DbSetup:2.1.0")

	implementation("org.apache.commons:commons-lang3:3.0")

	implementation ("io.springfox:springfox-boot-starter:3.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// 手動マイグレーション用タスク
flyway {
	url = "jdbc:mysql://localhost:3306/stego"
	user = "stego"
	password = "password"
}
