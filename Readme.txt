Instructions to run the project:
-------------------------------
1. Install Java and Maven.
2. Checkout the project from Github URL: https://github.com/AmrishGupta/Aquent-Order-Problem
3. In the command prompt please go to the OrderProblem  directory and run mvc clean install.
4. Go to the target folder to run  jar java -jar order.problem-0.0.1.jar {input file path} {output file path} 
   foreg. java -jar order.problem-0.0.1.jar C:\Aquent\inputorderfile.txt C:\Aquent\outputorderfile.txt

Assumptions:
-------------
1. There will be at-least one space/tab between order item and time of order.
2. The order item will not have any space in between.
3. The input file will have a header.

Design Decision:
----------------
1.The application is spring boot with singleton design pattern.
2.The business layer logic will remain the same even if we start reading/writing from/to the DB or uploading the file from web. 
  The DB may have raw data as a single string or in two columns business layer will support both formats.
3. The implementation of the repository will have to change for the database and then @Primary will be DB repository implementation class.
4. The changes will be needed in the main method as per the source and destination of file.
 
 Expectations:
 ---------------
1.Mavenized project	- Done
2.Source code		- Checked in to github URL: https://github.com/AmrishGupta/Aquent-Order-Problem
3.Include test cases - Done
4.Ability to run test cases from command line - Done