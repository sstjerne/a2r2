#=====================
# A2R2 REST API
#=====================


##Required

Assumptions or please install the follow tools:

* JDK 1.8
* [Tomcat 8](https://tomcat.apache.org/index.html)
* [Mysql Server](https://dev.mysql.com/downloads/mysql/5.6.html)

##Run app from Eclipse IDE
1. Install Eclipse
2. Install Tomcat 7
3. Creating A New Tomcat Server
	To create a new Tomcat server in Eclipse, navigate to the "Server" tab, which is located in the lower half of Eclipse's development screen by default, and secondary click. Choose "New -> Server" from the context menu.
	You will be presented with a dialogue in which you can configure high-level server setting such as default ports, server name, and host name. You can also use this dialogue to set your web application deploy path. If you would like more in depth information about setting up Tomcat servers in Eclipse, please visit Tomcat Eclipse, our illustrated step-by-step guide to using Tomcat with Eclipse.
	Controlling your Existing Tomcat Installation with Eclipse
	if you wish to integrate your existing Tomcat installation into Eclipse, rather than creating a new instance, follow the same steps as above for configuring a new server, and select "Use Tomcat installation" from the "Server Locations" tab of the Server Configuration menu.
	Enabling Modern Context.XML Fragments
	All actively supported versions of Tomcat allow web application Context Descriptors to be configured via context.xml fragments located in the application's "META-INF" directory. This allows users to make changes to applications and redeploy them without restarting the entire application server, as they would if the entries were included in "$CATALINA_HOME/conf/server.xml".
	Eclipse supports this technique natively, but the option is enabled by default, in the interest of greater compatibility. If you wish to store application context information in a location other than "server.xml", check the "Publish module contexts to separate XML files" option in the "Server Options" tab of the Server Configuration menu.
4. Add system variable in Eclipse: Go to Run --> Run Configurations --> Tomcat Select Arguments tab and add to VM arguments -DenvTarget=dev. Dev is default.
5. Deploying and Running Your Application
	Testing your Eclipse-assisted application on your Tomcat server is very easy. Simply secondary-click your project's WebContents folder, and choose "Run On Server" from the "Run As" menu to deploy the application to the server of your choice.


##Run without Eclipse with Tomcat embbed
1. Go to a2r2-API-REST project;
2. Check Maven is able 
	`mvn --version`
3. Execute with Tomcat embbed 
	`export envTarget=test`
	`mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -DenvTarget=test -Dcargo.maven.containerId=tomcat8 -Dcargo.maven.containerUrl=http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.33/bin/apache-tomcat-8.0.33.zip`

##Run in Tomcat
1. Go to a2r2-API-REST project;
2. Check Maven is able 
	`mvn --version`
3. Execute with Tomcat embbed 

	`export envTarget=test`

	`mvn clean install -DenvTarget=local`


##Environments
There are three environment to run, and only one of them should be set by "envTarget" environment variable:
	dev: this link mysql in local machine; by default;
	local: this link hsql in memory;
	prod: this link mysql in remote machine;



### References:
[The OAuth 2.0 Authorization Framework](https://tools.ietf.org/html/rfc6749)

[Spring](http://projects.spring.io/spring-framework/)
