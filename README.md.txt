=======================================
Mr. Chad Steffl, S02269293
CSC 241 Final Project
12/11/16
V 1.2
=======================================
Description
This program was built as a final project for CSC 241: Advanced Java.
It employs many broad topics learned throughout the course. Some topics include:

1) ENUM type classes
2) Object Oriented Programming principles
3) Generic methods
4) JavaFX GUI via SceneBuilder
5) Information hiding
6) MVC (Model-View-Controller) paradigm for GUI

Other topics of this course that are not present in the program include:
Database interaction (E.G. JavaDB), multithreading, Swing, interfaces, inheritance, recursion...


The purpose of the program is to allow a user to more easily create a chracter for the popular tabletop roleplaying game (RPG) Dungeons and Dragons (5th Edition) as well as save and reload character data for future use. 

The program was built using NetBeans IDE and JavaFX SceneBuilder 8.2. Portions of the UI were created "from scratch" namely the popup error message.

=======================================
FILE DESCRIPTIONS
The program is constructed on the MVC (Model-View-Controller) paradigm.
RECOMMENDED: Use JavaFX SceneBuilder to edit the GUI.

1) CharacterClass
ENUM class that Contains information regarding each D&D character class(Fighter, Wizard...) including critical statistics such as hit points(HP).

2) Races
ENUM class that contains information regarding each D&D race (Human, Elf...) including racial stat bonuses (E.G. elves are more dextrous than humans and gain a bonus to the DEXTERITY stat).

3) CharacterGenerator
The MAIN entry point into the program.

4) View
Contains the main GUI view for the character generator.

5) FinalXML
The XML file created by JavaFX SceneBuilder. In most cases this does not need to be modified directly by the user. 

6) Model
Contains model data to implement information hiding.

7) ErrorXML
The XML file created by JavaFX SceneBuilder for the error popup window. This should not need to be modified by the user directly.

8) OutputData
File for outputting "SAVE" file data to a .txt

9) InputData
File for reading data from a .txt file.

10) FinalXMLController
The controller file for the main GUI. I.E. controls action events, clicks, etc.

11) ErrorXMLController
The controller file for the error popup GUI. Controls action events, etc.

===============
How To Compile


The file CharacterGenerator.java contains the source file to compile into a .class file. Once compiled the program is runnable. All .java files are located in the SRC folder.

In the NetBeans IDE, "clean and build" the project, then "run project" under the RUN tab of the NetBeans GUI.

See OTHER notes regarding SAVE files. SAVE files will be improved in v1.3.

=========================== 



=======================================
OTHER

\\util\OutputData file must be updated
prior to first use to initialize the 
save/load directory.


Update line 31 to the location of util
folder.

I.E.
C:\users\public\documents\util\CharData.txt


Should be entered as 
new File("C:\\users\\public\\documents\\util\\CharData.txt");



CharData does NOT need to be created.
Once the program is run it will 
create the necessary file.

=========================