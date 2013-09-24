Virtual Toolkit
==============

The Virtual Toolkit allows the quick run time selection of various Java GUI toolkits and allows for the transparent creation of distributed collaborative applications with coupled widgets.  Below is the abstract from our published paper on the project, which is available in its entirety here
http://dl.acm.org/citation.cfm?id=2145204.2145398&coll=DL&dl=GUIDE&CFID=168649108&CFTOKEN=46018754

_A multi-domain collaboration toolkit hides heterogeneity of user-interface toolkits and associated domains from both programmers and end users of collaborative, widgetsynchronizing, applications. We have  developed such a system for the stand-alone, Eclipse, and web domains; and the AWT, Swing, SWT, and GWT single-user toolkits associated with these domains. Several new concepts are supported to meet these requirements including a widget server allowing a distributed  widget client to manipulate widgets on an interactive device, flexible widget synchronization, flexible placement of widget  listeners, “piping”  centralized non-interactive replicas communicating with interactive user replicas, factory-based retargeting of the user-interface toolkit, and a new process architecture._

Contents of the Repository
-------------------------------
This repository contains two projects, Virtual Toolkit and Translate.  Virtual Toolkit contains the source for the toolkit.  Translate contains a demo application translates three phrases from English to Mandarin - "hello", "spicy", and "not spicy".  This application can be run as distributed or non-distributed using the drivers in bus.driver package.  In the case of running the distributed case, you must run the AServerStarter or ASpecifiedServerStarter before running any of the Swing, SWT, or AWT versions.

Required Libraries
-------------------------------
As of the time of writing, this project requires the following external libraries:
<pre>
	#GWT jars
	gwt-dev.jar
	gwt-servlet.jar
	gwt-user.jar
	
	#SWT jars for your operating system (Windows, Mac, or Linux)
	swt-debug.jar
	swt.jar
	
	#Gluegen
	gluegen-rt.jar

	#Java3D
	We have tested this using Java3D version 1.5.2
</pre>

Installation Instructions
-------------------------------

The project comes with both eclipse project files, and ant build files.  Simply linking or copying the aforementioned jar files into the VirtualToolkit/Virtual Tollkit/libs directory is sufficient for eclipse and ant to pick up the dependencies, and compile. For eclipse, simply import both of the projects, and as long as you properly link or copy the jars into the libs directory, it should build just fine.  Instructions for ant (after copying/linking the jars) are given below.

Building the Virtual Toolkit:
<pre>
<code>	$ cd "VirtualToolkit/Virtual Toolkit"
	$ ant -buildfile build.xml
</code></pre>
Building and running an example from Translate:
<pre>
<code>	$ cd "VirtualToolkit/Translate"
	$ ant -buildfile build.xml
	$ cd bin
	$ java -cp ".:../../Virtual Toolkit/libs/*:../../Virtual Toolkit/bin" bus.driver.SomeExample
</code></pre> 
where SomeExample is a demo app located in Translate/bin/bus/driver/.
	 

