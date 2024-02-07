# TheScoreDemoProject
 Demo Automation Project for theScore Mobile App

 This is a Maven project, so the easiest way to run it from a command line, regardless of operating system, is to make use of the mvn command.
 
 In order to set up and run the test cases from the command line on a macOS environment, do the following:

 STEP 1. Ensure Maven is installed on the machine. In order to check if is it installed, open the terminal and type in the command "mvn --version". If Maven is installed, skip to STEP 13.

 STEP 2. If Maven is not installed, then download the Binary zip archive file from: https://maven.apache.org/download.cgi

 STEP 3. Extract the downloaded maven zip folder

 STEP 4. Move the extracted apache-maven-versionNumber folder to a desired location (i.e. the current user directory on the testing machine)

 STEP 5. Set the System variables M2_HOME (this variable will point to the location where the maven folder was located in step 4), and append the path of the apache-maven-versionNumber folder to the PATH variable

 STEP 6. In order to set the System variables for all terminal sessions, create a .bash_profile file

 STEP 7. To do this, open a terminal, navigate to the current user folder (the same folder where the apache-maven-versionNumber was placed in step 4 above), and in the terminal, type the command "touch .bash_profile" and press enter

 STEP 8. The .bash_profile file is be default hidden, so in order to show it type the following command in the terminal "defaults write com.apple.finder AppleShowAllFiles TRUE"

 STEP 9. Now that the .bash_profile is no longer hidden, open it with a text editor

 STEP 10. In the open .bash_profile file, write the following in 2 separate lines: 
 
 export M2_HOME=pathToapache-maven-versionNumberFolder
 export PATH=$PATH:pathToapache-maven-versionNumberFolder/bin

 STEP 11. Save and close the .bash_profile file

 STEP 12. Open a new terminal and verify that Maven has be installed by again typing in the command "mvn --version"; this should return text pertaining to the version of Maven installed on the machine

 STEP 13. On the terminal, navigate to the location of the TheScoreDemoProject directory

 STEP 14. Once inside the TheScoreDemoProject, on the terminal, type in the command: mvn clean test -Dtestname=searchForPlayerTest

 The test should now succesfully run. You can open and view a report of the recorded steps by navigating to the reports folder inside the TheScoreDemoProject, and clicking on the latest report .html file generated (the file names will have the date and time according to the exectuion of the test)

 Note: To view the code for the executed testcase itself, navigate to:

TheScoreDemoProject/src/test/java/tests/TheScoreApplicationTests.java
