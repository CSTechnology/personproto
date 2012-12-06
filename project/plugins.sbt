// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
//resolvers += "repository" at "https://oss.sonatype.org/content/groups/scala-tools/"
//resolvers += "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
//resolvers += "releases"  at "https://oss.sonatype.org/content/groups/scala-tools"
//resolvers += "oss.sonatype repository"  at "https://oss.sonatype.org/content/repositories/releases/"
//resolvers += "scala-tools for Casbah build on heroku release" at "http://scala-tools.org/repo-releases/"
//resolvers += "scala-tools for Casbah build on heroku snapshot" at "http://scala-tools.org/repo-snapshots/"
//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.0.4")