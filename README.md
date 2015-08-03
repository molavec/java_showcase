#Java Show Case
#####by Miguel Olave ([www.molavec.com](http://www.molavec.com))

#Motivation
  Here is a showcases to re-use example codes that show how to solve different problems or shows how to use some typical libs. I hope to accelerate the learning curve, use typical design-patterns or avoid wasted time to recover ways to do things from old useful code, all in a formal way to do it that could be useful to share knowledges in working teams.

 In a simple phrase: "It's not about reuse the code, it's about reuse the learning".

###Pure Java
  In this showcase I use pure Java libs, avoiding use frameworks or big pieces of codes. Keep it simply to solve simply!  

###Why I am not use JUnit?
  The main aim of unit test is check reusable code and libs. In this concept I am not trying to generate reusable code. Instead, I want to get a start point of how to use code reusable code. To avoid many instructions to get run code I use the power of Gradle to simplify how to run successfully code.


#How to use

### Require
+ Java 8
+ gradle 2.4 (For an easy install use [GVM Tool](http://gvmtool.net).

### Console
Download all showcase!!

    $ git clone https://github.com/molavec/java_showcase.git

Execute!!

    $ cd  [Path]
    $ gradle build
    $ gradle -q [task]

Example:

    $ cd commandLine
    $ gradle build
    $ gradle -q cmdline01

Chekout **build.gradle** to know about which class is used by the task.

#Showcases (projects) implemented
---
####**Java Basic**
#####[Path: basics]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| poo01    	| Object Oriented Programming Simple example how to use Classes. 	|
| poo02    	| Object Oriented Programming Simple example how to use Heritage.           |
| poo03    	| Simple Example about **static** variables.           |
---

####**Command Line**
#####[Path: commandLine]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| cmdline01    	| Simple example how to use command line arguments. 	|
| cmdline02    	| Multiple Arguments and Options Management           |
| cmdline03    	| an example of how to use Options Management with [Apache Commons CLI](http://commons.apache.org/proper/commons-cli/index.html)          |
---

####**Communication Protocols**
#####[Path: communicationProtocols]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| serial01    	| Simple serial communication example using [org.scream3r.serial](https://code.google.com/p/java-simple-serial-connector/) 	|
---

####**Design Patterns**
#####[Path: designPattern]

(more info: [tutorialspoint.com](http://www.tutorialspoint.com/design_pattern/design_pattern_quick_guide.htm))

| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| dp01 | Factory Pattern	|
| dp02 | Abstract Factory Pattern	|
| dp03 | Singleton Pattern	|
| dp04 | Builder Pattern	|
| dp05 | Prototype Pattern	|
| dp06 | Adapter Pattern	|
| dp07 | Data Access Object Pattern	|
---

####**Encription**
#####[Path: encryption]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| encrypt01 | A simple MD5 example using java.security.\* package.	|
---

####**Encription**
#####[Path: events]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| event01 | A simple timer example using **ScheduledExecutorService** and **ScheduledFuture** from javapractices.com	|
| event02 | A simple timer example using **Timer** and **TimerTask** from javapractices.com |
---


####**Logger**
#####[Path: logger]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| logger01 | A simple example using SFL4J y LOG4J.	|
---

####**Persistence**
#####[Path: persistence]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| persistence01    	| Simple Text file Reader.	|
| persistence02    	| Example of how to serialize an Object.	|
| persistence03    	| Modify an OpenOffice **.ods** file with [JOpenDocument](http://www.jopendocument.org).	|
| persistence04    	| Simple example how to read a properties file.	|
| persistence05   		| Simple example how ro write in a properties file.	|
| persistence06   		| Simple example how ro write in a json file using [gson library](https://github.com/google/gson).	|
| persistence07   		| Simple example how ro read in a json file using [gson library](https://github.com/google/gson).	|
| persistence08   		| Simple example how use JPA.	|
---

####**Random**
#####[Path: random]
| [task] 	      |                 Description                        	|
|--------------	|:-------------------------------------------------:	|
| random01    	| Genera números aleatorios utilizando el paquete [org.apache.commons.math3.random](http://commons.apache.org/proper/commons-math/)	|
---

##Troubleshooting
+ [Could not find method jcenter() for arguments \[\] on repository container](http://stackoverflow.com/questions/27470443/could-not-find-method-jcenter-for-arguments-on-repository-container)

Install the last gradle version. check if you current version it over 1.7 with **'gradle -version'**


##Do you want to contribute??
Contact me at [@molavec](https://twitter.com/molavec)


##TODO
+ In enryption make an example with apache.shiro
+ automatize javadoc
