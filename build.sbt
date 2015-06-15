
name := "ScalaDBCompiler"

scalaVersion := "2.11.6"

libraryDependencies := Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.2.+",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.+",
  "org.scalatest"   %% "scalatest"         % "2.2.4" % "test"
)
