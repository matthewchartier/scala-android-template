scalaVersion := "2.11.7"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.android.support" %  "cardview-v7" % "21.0.0",
  "com.android.support" % "appcompat-v7" % "21.0.0",
  "joda-time" % "joda-time" % "2.4"
)

platformTarget in Android := "android-21"

minSdkVersion in Android := "21"

targetSdkVersion in Android := "21"

useProguardInDebug in Android := false

run <<= run in Android

cleanFiles <+= baseDirectory { base => base / "target" }

cleanFiles <+= baseDirectory { base => base / "project/target" }

proguardOptions in Android ++= Seq(
  "-ignorewarnings",
  "-keep class scala.Dynamic"
)

dexMulti in Android := true

javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions in Compile ++= Seq("-target:jvm-1.7")

