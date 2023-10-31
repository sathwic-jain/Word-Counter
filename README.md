# Word-Counter

This README file explains the basic functionalities and usages for
the "WordCounter.java" file, version 1.0.

The program contains two java files:
    WordCounter.java  //Contains the main method.
    Output.java  //takes care of the output(to be printed).

The program does all the basic functionalities as specified by the 
coursework. The program works in accordance with the principle of least surprise.

Additional features implemented :

---- COMPILE AND RUN ON THE COMMAND LINE ----

There are two usage cases for this program:

        1) java WordCounter file_directory searchterms

        2) java WordCounter file_directory1 search_terms_for_1 ! file_directory2 search_terms_for_2

The program can be run for a single file and its searchterms, and also for multiple files and
their searchterms. Use ! as a separator after a set of file_directories and it's respective 
searchterms. The results are printed in the order of the files.
 
An additional error term is thrown that is not specified in the coursework:
 
Case: When the user enters just a searchword first instead of a file directory, an error stating
the usage and incorrectness is thrown:

    > java WordCounter Jamie
	
      Usage: java WordCounter <filename> <searchTerm>
      File not found: Jamie

A sample output for the program :

1.
    >java WordCounter pride-and-prejudice.txt is
    
     The word 'is' appears 831 times.
2.
    >java WordCounter pride-and-prejudice.txt is and
 
     |-------|-------|
     | WORD  | COUNT |
     |-------|-------|
     | is    |   831 |
     | and   |  3434 |
     |-------|-------|
     | TOTAL |  4265 |
     |-------|-------|

3.
    >java WordCounter pride-and-prejudice.txt is ! a-tale-of-two-cities.txt is

    Case : 'pride-and-prejudice.txt' :
    The word 'is' appears 831 times.
    Case : 'a-tale-of-two-cities.txt' :
    The word 'is' appears 768 times.

4.
    >java WordCounter pride-and-prejudice.txt is ! a-tale-of-two-cities.txt is are


    The word 'is' appears 831 times.
    |-------|-------|
    | WORD  | COUNT |
    |-------|-------|
    | is    |   768 |
    | are   |   299 |
    |-------|-------|
    | TOTAL |  1067 |
    |-------|-------|

5.

    > java WordCounter pride-and-prejudice.txt is are ! a-tale-of-two-cities.txt is are

    Case : 'pride-and-prejudice.txt' :
    |-------|-------|
    | WORD  | COUNT |
    |-------|-------|
    | is    |   831 |
    | are   |   322 |
    |-------|-------|
    | TOTAL |  1153 |
    |-------|-------|
    Case : 'a-tale-of-two-cities.txt' :
    |-------|-------|
    | WORD  | COUNT |
    |-------|-------|
    | is    |   768 |
    | are   |   299 |
    |-------|-------|
    | TOTAL |  1067 |
    |-------|-------|

