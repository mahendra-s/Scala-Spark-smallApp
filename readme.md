
# Steps to use this sample app

1. Get code copy and build  
```
git clone git@github.com:mahendra-s/Scala-Spark-smallApp.git
git checkout develop
sbt clean compile package
```
3. development env run via sbt
```
sbt "runMain com.example.RunApp" 
or 
sbt "runMain com.example.SampleSparkApp4Kiran" 
```
2. run via spark-submit 
spark submit is only working with java main class
```
#windows
spark-submit  --class com.example.RunApp target\scala-2.12\smallapp_2.12-1.1.jar
#unix
spark-submit  --class com.example.RunApp target/scala-2.12/smallapp_2.12-1.1.jar 
```
