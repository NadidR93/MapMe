# MapMe

Requirements:  
Java 1.8  
Glassfish 4.1.1  
Eclipse with Java EE support  

Technologies involved in my application:  
MVC framework/technologies  
Java Server Face 2.0+ (JSF2.0+)  
Java EE  
Javascript  
XHTML/HTML  
JSP  
Google Maps API  
Facebook API  
REST Web Services (Facebook API)  



MapMe is a web application built on Java EE and JSF using MVC technology. The application lets you type an origin location, a destination location, and then it simply returns the distance. I calculated the distance using the haversine formula, and Google map's API. I made this so that I could play with the different kinds of technologies that are available and to broaden my skillset.  
  

There are multiple versions of this. This particular version of my application plays with concurrency, concurrent programming, synchronization, multithreading programming, and more. You can also incorporate facebook features onto this application, please lok at SimplePractice.java; also, here is a good video describing how to incorportae Facebook's Graph API onto this application: [Facebook features in the web site](https://www.youtube.com/watch?v=oxSKLgsSbsU).  

I hope you enjoy this as much as I have.  



Application demo:  

![alt tag](https://github.com/o3dwade/MapMe/blob/master/Demo1.png?raw=true)  
Directions:  
1.) Import project onto eclipse. Go to Java Build Path, add all the .jar files inside MapMe/WebContent/WEB-INF/lib  

2.) Start Glassfish server  

3.) Run MapWorld.jsp on server  

4.) Enjoy  
