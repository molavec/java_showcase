#Java Show Case
#####by Miguel Olave (www.molavec.com)

#Motivation
  Here is a showcases to re-use example codes that show how to solve different problems or shows how to use some typical libs. I hope to accelerate the learning curve, use typical design-patterns or avoid wasted time to recover ways to do things from old useful code, all in a formal way to do it that could be useful to share knowledges in working teams. 

 In a simple phrase: "It's not about reuse the code, it's about reuse the learning".

###Pure Java 
  In this showcase I use pure Java libs, avoiding use frameworks or big pieces of codes. Keep it simply to solve simply!  

###Why I am not use JUnit?
  The main aim of unit test is check reusable code and libs. In this concept I am not trying to generate reusable code. Instead, I want to get a start point of how to use code reusable code. To avoid many instructions to get run code I use the power of Gradle to simplify how to run successfully code. 


#How to use

### Requirecmdlines
+ Java 8
+ gradle 2.4

### Console
Download all showcase!!

    $ git clone https://github.com/molavec/java_showcase.git

Execute!!

    $ cd  [projectNameDirectory]
    $ gradle build
    $ gradle -q [task]

Example:

    $ cd commandLine
    $ gradle build
    $ gradle -q cmdline01

Chekout **build.gradle** to know about which class is used by the task. 

#Showcases (projects) implemented

###Command Line
**projectNameDirectory:** commandLine
+ cmdline01 - Simple example how to use command line arguments.
+ cmdline02 - Multiple Arguments and Options Management 
+ cmdline03 - an example of how to use Options Management with [Apache Commons CLI](http://commons.apache.org/proper/commons-cli/index.html)

###Files and Documents
**projectNameDirectory:** file
+ file01 - Simple Text file Reader.
+ file02 - Example of how to serialize an Object.
+ file03 - Modify an OpenOffice **.ods** file with [JOpenDocument](http://www.jopendocument.org).

###Encription
**projectNameDirectory:** encryption
+ encrypt01 - A simple MD5 example using java.security.* package.

###Random
**projectNameDirectory:** random
+ random01 - Genera números aleatorios utilizando la clase Well19937c del paquete **org.apache.commons.math3.random** 

##Do you want to contribute??
Contact me at [@molavec](https://twitter.com/molavec)

#TODO
+ Improve documentation
+ automatize javadoc

#Change log
###2015/07/10
+ Use [multi-project-builds](https://docs.gradle.org/current/userguide/multi_project_builds.html) with gradle.


