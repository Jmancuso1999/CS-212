# Project1-212
 
 ### **Sorting an Array of Dates/ Displaying in a GUI/Creating a Class**

Project #1 from CS 212 java Queens College with Professor Kenneth Lord. Object-Oriented Programming in Java. 

 Given an input file of dates represented as Strings, read the dates from the file and display them in a GUI. The dates will be in the form yyyymmdd (such as 20181001 for October 1, 2018). The GUI should have a GridLayout with one row and two columns. The left column should display the dates in the order read from the file, and the right column should display the dates in sorted order (using Selection Sort). 
 
Create a class called Date212 to represent a date. It will store the year, month and day as integers (not as a String), so you will need three private instance variables. A constructor should be provided that takes a String (representing the date as above). Use the substring method of class String to pull out the month, day and year, and parse them as integers. Include a private validity checking method that should make sure that the month and day values are legal. If it is not a valid date, print it to the console and do not put it in the array of dates. Create a toString method in class Date212 the will return the date in the form mm/dd/yyyy. Use this method to display the dates in the GUI. 
 
Use two arrays containing Date212 objects, one containing valid dates in the order read from the file, the other read in and then sorted using Selection Sort. 
