name := "scala-rich-console"

version := "0.1"

scalaVersion := "2.13.4"

// Publish Maven repo tutorial from https://medium.com/rahasak/publish-scala-library-project-to-maven-central-with-sonatype-d7edaa67d275
organization := "io.github.daniele-tentoni"

homepage := Some(url("https://github.com/daniele-tentoni/scala-rich-console"))

developers := List(Developer("Daniele Tentoni", "Daniele Tentoni", "daniele.tentoni.1996@gmail.com", url("https://github.com/daniele-tentoni")))

publishMavenStyle := true

// disable publish with scala version, otherwise artifact name will include scala version
crossPaths := false

publishTo := Some(
  if(isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeReleases
)

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "3.2.2" % Test
  )
}