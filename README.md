#Java Show Case
#####by Miguel Olave (www.molavec.com)

#Motivation
  Here is a showcases to re-use example codes that show how to solve different problems or shows how to use some typical libs. I hope to accelerate the learning curve, use typical design-patterns or avoid wasted time to recover ways to do things from old useful code, all in a formal way to do it that could be useful to share knowledges in working teams. 

###Pure Java 
  In this showcase I use pure Java libs, avoiding use frameworks or big pieces of codes. Keep it simply to solve simply!  

###Why I am not use JUnit?
  The main aim of unit test is check reusable code and libs. In this concept I not trying to generate reusable code. Instead, I want to get a start point of how to use code reusable code. To avoid many instructions to get run code I use the power of Gradle to simplify how to run successfully code. 


#How to use

###Requirements
+ Java 8
+ gradle 2.4


Get it!!

    git clone https://github.com/molavec/java_showcase.git

Execute!!

    gradle [task]

Example:
    
    gradle args01

Chekout **build.gradle** to know about which class is used by the task. 

#Showcases implemented

###command line
+ cmdline01 - Simple example how to use command line arguments.
+ cmdline02 - Multiple Arguments and Options Management 
+ cmdline03 - an example of how to use Options Management with [Apache Commons CLI](http://commons.apache.org/proper/commons-cli/index.html)

###Files and Documents
+

###DataBases
+

###Serial Port
+


##Do you want to contribute??
Contact me at [@molavec](https://twitter.com/molavec)




#TODO
+ Use [multi-project-builds](https://docs.gradle.org/current/userguide/multi_project_builds.html) with gradle.
+ Improve documentation
+ automatize javadoc


