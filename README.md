To create automation tests in this assessment I used Selenium Web Driver and Java Programming Language.
To create the test framework TestNG has been used.
According to the given test assessment there are two test cases to be prepared from "https://www.pos.com.my/" website.

I have created a class called 'BuyInsuranceTest' in test/java package. Inside the test there are two test cases with @Test annotation.
The first test case is 'verifyBuyInsurance' - The main target of this test case is to navigate to the url "https://www.pos.com.my/" -> Scroll down to the section “What can Pos Malaysia do for you, today?” -> click on “Buy Insurance” button -> navigate to a new tab with url 'insurance.pos.com.my' and click either of 'I drive a car' button or 'I ride a motorcycle' button -> upon clicking the page will show a a new  section “Ok, let’s get to know you” with five different fields. 

Below Screenshot will show the first test case written for the above scenario
![image](https://github.com/Rashini-QA55/POS_Assessment_RashiniHettige/assets/174021043/85ffe30f-7ca0-4334-96ad-0bcfc83d641e)

The second test case is 'creatingConsignmentNote' - This test will verify the flow of navigating to  "https://www.pos.com.my/" ->hover over on send menu item in the menu bar -> click parcel sub menu item -> getting the new page 'pos.com.my/send/send-parcel' and scroll down to the 'cash' segment and click on “Create shipment now” button -> upon clicking user will be redirected to 'https://send.pos.com.my/home/e-connote?lg=en' page which includes e-Consignment forms. 

Below screenshot will show the second test case written to verify the mentioned scenario.

![image](https://github.com/Rashini-QA55/POS_Assessment_RashiniHettige/assets/174021043/5159f17a-8cea-400a-8d11-3cbdf35584b6)

After creating the two tests to increase the usability of the code, I have created a separate class in main/java package named as 'POS_TestPage_Elements.java' which contains all the web elements (element locators that used to capture the fields) of the two tests. This page factory class will act as a repository of locators. Then I have initialize the elements accordingly inside two test methods.

below screenshot will display the element class.
![image](https://github.com/Rashini-QA55/POS_Assessment_RashiniHettige/assets/174021043/e9ee01ef-6521-411c-bff1-38eaf4040a79)

As the next step I have created a separate page class to maintain all the actions related to the application page.It works as a one-to-one mapping. Because we can include all the actions/ methods in this page class and from here it is possible to call those actions/methods from the application page.

Here is an attachment of the POS_testPages that I have created under the com.pos.pages package in main/java.

![image](https://github.com/Rashini-QA55/POS_Assessment_RashiniHettige/assets/174021043/b73e2ce2-a318-4529-a106-ce63f73f3095)

To make this framework more user-friendly, I have created a base class called AbstractBaseTest.java. It will contain all the prerequisites that we use when creating a framework. As an example in the beginning of the implementation we need to set driver properties, initialize the web driver etc. Also, in testNG class we use annotations. in this assessement, I have used the BeforeMethod and AfterMethod annotations to specify the prerequisites of the test. By keeping these methods in a separate class we can avoid the repetition of them inside each class. After creating the AbstractBaseTest.java class I have used it inside 'BuyInsuranceTest' class as 'BuyInsuranceTest extends AbstractBaseTest'. Means the major class that created with the tests will extend the methods in Abstract class.

Apart from these, I have used assertions to verify the actual and expected results where ever possible.
Also, when displaying the e-Consignment forms I have used WebElement list to get a collection of elements.

After implementing this framework, I created a xml file (driver file) by including the two test methods. This will excute each test and log the results as test pass/fail with additional information.The file is 'pos.xml' which is available under the test-output folder.









