# Word Counter

## Overview

This Word Counter program, implemented in Java, serves as a practical exercise for CS5001 Object-Oriented Modelling, Design, and Programming. The application reads a text file, searches for specified words, and reports the word counts. The README explains the program structure, usage, additional features, and showcases sample outputs.

## Project Structure

The project consists of two Java files:
- `WordCounter.java`: Contains the main method and the primary functionality.
- `Output.java`: Manages output printing.

## Features

- **Command-Line Usage:**
  - Run for a single file and search term:
    ```
    java WordCounter file_directory searchterm
    ```

  - Run for multiple files and their respective search terms:
    ```
    java WordCounter file_directory1 search_terms_for_1 ! file_directory2 search_terms_for_2
    ```

- **Error Handling:**
  - Displays a usage message and file not found error when arguments are missing or the specified file doesn't exist.

- **Additional Features:**
  - Error message when the user enters a search word without a file directory.
  - Results are printed in the order of the files.
  
## Running the Program

1. **Setup Environment**: Ensure Java is installed.

2. **Clone Repository**:
   ```
   git clone https://github.com/yourusername/Word-Counter.git
   cd Word-Counter
   ```

3. **Run the Program**:
   ```
   javac WordCounter.java
   java WordCounter file_directory searchterm
   ```

4. **Check Results**: Find the output predictions in the generated `Y_test.csv` file.

## Sample Outputs

1. Run for a single file and search term:
   ```
   java WordCounter pride-and-prejudice.txt is
   ```
   Output:
   ```
   The word 'is' appears 831 times.
   ```

2. Run for multiple files and their respective search terms:
   ```
   java WordCounter pride-and-prejudice.txt is ! a-tale-of-two-cities.txt is
   ```
   Output:
   ```
   Case : 'pride-and-prejudice.txt' :
   The word 'is' appears 831 times.
   Case : 'a-tale-of-two-cities.txt' :
   The word 'is' appears 768 times.
   ```

3. Run for multiple files and multiple search terms:
   ```
   java WordCounter pride-and-prejudice.txt is are ! a-tale-of-two-cities.txt is are
   ```
   Output:
   ```
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
   ```

## Report Overview

The project includes a detailed report in the file `CS5001-p1-wordcounter/Report.pdf`. The report covers essential steps, models used, their performance, and critical insights.

For a deeper understanding of the project methodology, detailed steps, and in-depth results, please refer to the comprehensive report in the included `Report.pdf` file.
