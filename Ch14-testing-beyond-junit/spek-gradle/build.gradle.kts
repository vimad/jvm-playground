plugins {
  application
  java
  kotlin("jvm") version "1.6.10"
}

application {
  mainClass.set("com.wellgrounded.Main")
}

tasks.jar {
  manifest {
    attributes("Main-Class" to application.mainClass)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")

  testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.15")
  testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.15")
}

tasks.named<Test>("test") {
  useJUnitPlatform() {
    includeEngines("spek2")
  }
}
