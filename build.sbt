name := "hapl"

version := "0.1"

//scalaVersion := "2.10.0"
scalaVersion := "2.11.2" //b/c of LIFT

// The dependencies can be found on http://mvnrepository.com/
// complete with the line to place here.

libraryDependencies += "junit" % "junit" % "4.8" % "test"

libraryDependencies += "org.scala-lang" % "scala-library" % "2.10.0"

libraryDependencies += "commons-lang" % "commons-lang" % "20030203.000129"

libraryDependencies ++= Seq(    
    "org.specs2" %% "specs2" % "1.14" % "test"
    // with Scala 2.9.2 (specs2 1.12.3 is the latest version for scala 2.9.2)
    // "org.specs2" %% "specs2" % "1.12.3" % "test",
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.9"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.10.0"
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

// ensime info page https://github.com/aemoncannon/ensime
//addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "VERSION")
// libraryDependencies += "org.ensime" % "ensime-sbt-cmd" % VERSION
// "release" at "https://oss.sonatype.org/content/repositories/releases/org/ensime/ensime-sbt-cmd_2.9.2_0.11.3/0.1.0"

// Read here for optional dependencies: 
// http://etorreborre.github.com/specs2/guide/org.specs2.guide.Runners.html#Dependencies

//-! Got this ensime to work with the "ensime snapshot" resolver. It looks a bit hacky but it's correct. 
//addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.1")
//addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.2")

resolvers ++= Seq(	"snapshots"			at "http://oss.sonatype.org/content/repositories/snapshots",
			"staging" 			at "https://oss.sonatype.org/content/repositories/staging",
			"releases"			at "http://oss.sonatype.org/content/repositories/releases",
		       	"ensime snapshot"		at "https://oss.sonatype.org/content/repositories/releases/org/ensime/ensime-sbt-cmd_2.9.2_0.11.3/0.1.1",
		       	"Akka Snapshot Repository"	at "http://repo.akka.io/snapshots/",
			"Typesafe Repository"		at "http://repo.typesafe.com/typesafe/releases/"
		          )

scalacOptions ++= Seq("-deprecation", "-unchecked")

val buildSettings = Defaults.defaultSettings ++ Seq( javaOptions += "-Xmx1G")

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "compile",
    "net.liftmodules"   %% "lift-jquery-module_2.6" % "2.8",
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.specs2"        %% "specs2"             % "2.3.12"             % "compile,test",
    "com.h2database"    % "h2"                  % "1.3.167"
  )
}


