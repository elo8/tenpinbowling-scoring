The problem:
==============

Code exercise: Ten Pin Bowling scoring. 

Write a java application that takes a string of space separated numbers from 0 to 10 and calculates what that would be as a score in ten pin bowling (hints on how to score in bowling are here: http://www.bowling2u.com/trivia/game/scoring.asp).  
 
If a final score cannot be determined from the input then method should return the "current" score (i.e. assumes any remaining bowls scored 0).  
Include unit tests and post code to a publicly accessible code repository.
 
Example inputs and outputs
"1 2 3 4" -> 10
"9 1 9 1" -> 29
"1 1 1 1 10 1 1" -> 18
"10 10 10 10 10 10 10 10 10 10 10 10" -> 300
 

Solution
========

The approach taken to solve this problem is to run a series of steps as below:
1. Parsing of the string inputs into an array of integers up to the maximum number of slots as per ten pin bowling rules. i.e. Ten Frames and 2 bonus bowls.
   Each frame consists of up to 2 bowls, so the maximum slot is 22.
   e.g. an input of "10 10 10 10 10 10 10 10 10 10 10 10" is parsed to the following:
   [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, null, null, null, null, null, null, null, null, null, null]
   
2. Transform the above into something closer to real world representations, i.e. using Java Objects.
   So the output of this step is to have the game of bowling with the all the frames objects and bonus bowls if any.
   See Game.java and Frame.java. The properties of the objects should be self explanatory.
   After this transformation one can easily inspect the details of each frame (whether it is a strike, spare or normal play) and whether it has extra bonus bowls or not.

3. Finally calculate the total score based on the above. 

Running it
==========

The easiest is to use an IDE such as Intellij or Eclipse and go to the App.java which is runnable, set the program arguments with the space separated string of numbers and
the total score will be printed at the end of the line.

TODOs
=====

This solution assumes the inputs fed to the application has been sanitized and validated.
Future versions will include validations of inputs.
