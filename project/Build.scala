import sbt._
import Keys._
import PlayProject._

object personprotoBuild extends Build {
	val name			= "personproto"
    val appName         = "personproto"
    val appVersion      = "1.0-SNAPSHOT"

	val appDependencies = Seq(
		  "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
	      "com.novus" %% "salat-core" % "0.0.8-SNAPSHOT",
		  //"com.novus" %% "salat" % "1.9.1",
		  //"com.novus" %% "salat" % "0.0.8",
	      "org.scalatest" %% "scalatest" % "2.0.M5",
	      "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5"
     )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
          resolvers ++= Seq("repo.novus snaps" at "http://repo.novus.com/snapshots/",
          "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
          "Sonatype OSS groups" at "https://oss.sonatype.org/content/groups/scala-tools/")
    )
}