Hello, this is a automation project which support Android platform.

1. In order to run the script, make sure the environments below are available:
	- Device is connected to PC
	- Install JDK 
	- Install Maven (https://www.mkyong.com/maven/how-to-install-maven-in-windows/)
	- Install Appium (on windows):
		+ Install nodeJS https://nodejs.org/en/
		+ Use command lines below to install:
			* npm install appium -g
			* npm install wd
		
2. Run project:
	- Config device name and platform in Android.properties file before running test (File path: ./src/test/java/configurations/Android.properties)
		+ platformVersion: Android version (ex: 8.0)
		+ deviceName: Your device name (ex: Samsung Galaxy S9)  
	- Redirect to the root folder (ex: appium_test)
		+ Use following command line to run: mvn clean test
	
3. To see a report after running test:
	- The test report is in following folder: ./src/test/java/reports/ExtentReport.html
		+ Open ExtentReport.html to see the report.
