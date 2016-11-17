/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import SonatypeKeys._

// Import default settings. This changes `publishTo` settings to use the Sonatype repository and add several commands for publishing.
sonatypeSettings

name := "presto-scala-client"

scalaVersion := "2.11.8"

organization := "com.github.nezihyigitbasi"

version := "0.3"

description := "A Scala client for the Presto SQL engine"

homepage := Some(url("https://github.com/nezihyigitbasi/presto-scala-client"))

resolvers ++= Seq(Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots"),
    Resolver.bintrayRepo("scalaz", "releases"),
    Resolver.bintrayRepo("megamsys", "scala"))


libraryDependencies ++= Seq(
  "io.megam" %% "newman" % "1.3.12",
  "com.facebook.presto" % "presto-client" % "0.157",
  "com.typesafe.scala-logging" % "scala-logging-slf4j_2.11" % "2.1.2",
  "org.slf4j" % "slf4j-api" % "1.7.1",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.1",  // for any java classes looking for this
  "ch.qos.logback" % "logback-classic" % "1.0.3",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

publishMavenStyle := true

pomIncludeRepository := { _ => false }

pomExtra :=
        <licenses>
          <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:nezihyigitbasi/presto-scala-client.git</url>
          <connection>scm:git:git@github.com:nezihyigitbasi/presto-scala-client.git</connection>
        </scm>
        <developers>
          <developer>
            <name>Nezih Yigitbasi</name>
            <url>http://github.com/nezihyigitbasi</url>
          </developer>
        </developers>

publishArtifact in Test := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
