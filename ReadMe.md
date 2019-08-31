# Selenium Testing on Shopping Portal
I took a small Selenium Workshop by [Sandeep Garud](https://www.linkedin.com/in/sandeepsgarud/) during my undergrad course and just loved it! He had given three additional assignments to learn and explore Selelnium more in-detail, which I obviously solved because duh, it's [Selenium](https://www.seleniumhq.org/)!

## File Details
Problem Statements File + Demo test case in HomeTest.java
The Assignments 1-3 are present in following directory: Selenium Testing on Shopping Portal\shoppingId\src\test\java\shoppingId\shoppingId
If one needs to run any of those assignemnts, it need to be renamed as HomeTest.java
The ./Capturer folder has each problem statement's solution's automated testing screen recorded video.

## Requirements to run the code
1. java version "1.8.0_102”. Also have Java(TM) SE Runtime Environment (build 1.8.0_102-b14) 
2. [Maven 3.6.0](https://maven.apache.org/download.cgi)
3. IntelliJ/Eclipse/STS (Spring Tool Suite) - for coding as per preference. I used Eclipse for building the project
4. Git 2.20.1 - https://git-scm.com/downloads
5. Chrome browser Version 75.x (One can update the chromedriver.exe in ./shoppingId folder to their respective Chrome version by downloading it from [here](https://chromedriver.chromium.org/downloads))
6. Selenium IDE extension for chrome: https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd
7. Once all of the above tools are installed, we have to install a demo application on which the Selenium Test Cases have been written:
	- Open terminal/command prompt and go the the workspace folder : (c:/workspace or any workspace work out of)
	- Use following command to clone the GitHub repository : git clone https://github.com/reljicd/spring-boot-shopping-cart.git
	- Use following command to change to the directory: cd spring-boot-shopping-cart-master
	- Use following command to run the application: mvn spring-boot:run
	- Open chrome and go to [localhost](http://localhost:8070/)
	- If all the tools are installed correctly, you should see the demo application with list of products. For more information on demo project, feel free to explore the [repo](https://github.com/reljicd/spring-boot-shopping-cart)

Make sure that you have appropriate java and maven versions installed by using “java -version” and “maven -v” commands on command prompt/terminal. There is lot of help available online on how to install these for particular platform.

### Contributor: [Yash Saboo](https://github.com/yashsaboo)

## Problem Statements
(You can download the following list from ProblemStatements.pdf file present in this directory)

1. Automate a test which verifies a registration of new user and login with newly registered user.  (Tip :test should registered a unique user every time and verify its login)
2. Automate a test which verifies that a logged in user can shop an item and checkout. After checkout verify the stock count is reduced by 1.
3. Automate a test which verifies that user can not buy an out of stock item. Select one item which can be made out of stock by repeating a buying scenario and then verify whether you can buy it after logging in.