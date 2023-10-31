/**
 * Class used for printing the output after the WordCounter sends the result of counting.
 */
public class Output {
    /**
     * A method to print the output when only one searchterm is entered with the file.
     * Has an if statement to switch the print statement for words that appear only once or more than once.
     * @param arrayOfFileAndSearch The array that contains the searchterm (and also the file in the first index).
     * @param counter The integer array that contains the count of each word (the index is in parellel with the arrayOfFileAndSearch).
     * @param noOfFiles The count of number of files
     */
    public static void singleWordSearch(String[] arrayOfFileAndSearch, int[] counter, int noOfFiles) {
        if (noOfFiles > 1) {
            System.out.println("Case : '" + arrayOfFileAndSearch[0] + "' :");
        }
        if (counter[1] == 1) {
            System.out.println("The word '" +   arrayOfFileAndSearch[1] + "' appears " + counter[1] + " time.");
        } else {
            System.out.println("The word '" +   arrayOfFileAndSearch[1] + "' appears " + counter[1] + " times.");
        }
    }
    /**
     * A method to print output if more than one searchword is provided.
     * @param arrayOfFileAndSearch The array that contains the searchterm (and also the file in the first index).
     * @param counter The integer array that contains the count of each word (the index is in parellel with the arrayOfFileAndSearch).
     * @param noOfFiles The count of number of files.
     */
    public static void moreWords(String[] arrayOfFileAndSearch, int[] counter, int noOfFiles) {
        final String col2Head = "COUNT";
        final String col1Head = "WORD";
        final String total = "TOTAL";
        final String additionalCharsForCol1 = "|  |";
        final String additionalCharsForCol2 = "  |";
        final String requiredStringAtTheStartOfEachElementInTheGrid = "| ";
        int initialCol1Width = 0;
        int initialCol2Width = col2Head.length();
        int additionalSpaceForCol1 = additionalCharsForCol1.length();
        int additionalSpaceForCol2 = additionalCharsForCol2.length();
        int lengthOfTotal = total.length();
        int wordLength = col1Head.length();
        int countLength = col2Head.length();
        int lengthOfRequiredStringAtTheStartOfEachElementInTheGrid = requiredStringAtTheStartOfEachElementInTheGrid.length();
        //finding the max length required for column 1
        for (int i = 1; i < arrayOfFileAndSearch.length; i++) {
            if (arrayOfFileAndSearch[i].length() > initialCol1Width) {
                initialCol1Width = arrayOfFileAndSearch[i].length();
            }
        }
        if (initialCol1Width < lengthOfTotal) {
            initialCol1Width = lengthOfTotal;
        }
        initialCol2Width = findMaxLengthforCol2(initialCol2Width, counter);
        int col1Width = initialCol1Width + additionalSpaceForCol1;
        int col2Width = initialCol2Width + additionalSpaceForCol2;
        if (noOfFiles > 1) {
            System.out.println("Case : '" + arrayOfFileAndSearch[0] + "' :");
        }
        firstLine(col1Width, col2Width);
        secondLine(col1Width, col2Width, wordLength, countLength, lengthOfRequiredStringAtTheStartOfEachElementInTheGrid);
        firstLine(col1Width, col2Width);
        theContent(col1Width, col2Width, arrayOfFileAndSearch, counter, lengthOfRequiredStringAtTheStartOfEachElementInTheGrid);
        firstLine(col1Width, col2Width);
        totalPrint(col1Width, col2Width, lengthOfTotal, counter, lengthOfRequiredStringAtTheStartOfEachElementInTheGrid);
        firstLine(col1Width, col2Width);
    }
    /**
     * Prints the first line of the grid style as given in the coursework.
     * @param col1Width Width of the first column of the grid.
     * @param col2Width Width of the second column of the grid.
     */
    public static void firstLine(int col1Width, int col2Width) {
        for (int i = 1; i <= col1Width + col2Width; i++) {
            if (i == 1 || i == col1Width || i == col1Width + col2Width) {
                System.out.print("|");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
    /**
     * Prints the second line of the grid style.
     * @param col1Width Width of the first column.
     * @param col2Width Width of the second column.
     * @param  wordLength The length of the string word so as to skip the required spaces in the grid representation.
     * @param countLength Contains the length of COUNT(string) so as to skip  the required spaces.
     * @param lengthOfRequiredStringAtTheStartOfEachElementInTheGrid A specific value that is required to be left before printing
     * the content or headers in the grid in regards to the grid design.
     */
    public static void secondLine(int col1Width, int col2Width, int wordLength, int  countLength, int lengthOfRequiredStringAtTheStartOfEachElementInTheGrid) {
        for (int i = 1; i <= col1Width + col2Width; i++) {
            if (i == 1 || i == col1Width || i == col1Width + col2Width) {
                System.out.print("|");
            }
            else if (i == lengthOfRequiredStringAtTheStartOfEachElementInTheGrid + 1) {
                System.out.print("WORD");
                i += wordLength - 1;
            } else if (i == col1Width + 2) {
                System.out.print("COUNT");
                i += countLength - 1;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    /**
     * Prints the searchterms in the first column and its respective counts in the second.
     * @param col1Width Width of the first column.
     * @param col2Width Width of the second column.
     * @param arrayOfFileAndSearch An array which contains the searchterms that are to be printed from index 1.
     * @param counter An array that contains the counts of the respective words in arrayOfFileAndSearch.
     * @param lengthOfRequiredStringAtTheStartOfEachElementInTheGrid A specific value that is required to be left before printing
     * the content or headers in the grid in regards to the grid design.
     */
    public static void theContent(int col1Width, int col2Width, String[] arrayOfFileAndSearch, int[] counter, int lengthOfRequiredStringAtTheStartOfEachElementInTheGrid) {
        int numLength;
        for (int words = 1; words < arrayOfFileAndSearch.length; words++) {
            if (words != 1) {
                System.out.println();
            }
            for (int i = 1; i <= col1Width + col2Width; i++) {
                if (i == 1 || i == col1Width || i == col1Width + col2Width) {
                    System.out.print("|");
                }
                else if (i == lengthOfRequiredStringAtTheStartOfEachElementInTheGrid + 1) {
                    System.out.print(arrayOfFileAndSearch[words]);
                    i += (arrayOfFileAndSearch[words].length()) - 1;
                }
                else if (i == col1Width + 1) {
                    numLength = (int) (Math.log10(counter[words])) + 1; //forced type conversion.....
                    if (numLength < 0) {
                        numLength = 1;
                    }
                    for ( ; i <= col1Width + col2Width - (numLength + 2); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(counter[words]);
                    i += numLength - 1;
                } else {
                System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
    /**
     * A method to print the final Total line in the grid.
     * @param col1Width Width of the first column.
     * @param col2Width Width of the second column.
     * @param lengthOfTotal The length of the string Total.
     * @param counter The array that contains the count of every searchterm(from index 1).
     * @param lengthOfRequiredStringAtTheStartOfEachElementInTheGrid A specific value that is required to be left before printing
     * the content or headers in the grid in regards to the grid design.
     */
    public static void totalPrint(int col1Width, int col2Width, int lengthOfTotal, int[] counter, int lengthOfRequiredStringAtTheStartOfEachElementInTheGrid) {
        int numLength;
        for (int i = 1; i <= col1Width + col2Width; i++) {
            if (i == 1 || i == col1Width || i == col1Width + col2Width) {
                System.out.print("|");
            }
            else if (i == lengthOfRequiredStringAtTheStartOfEachElementInTheGrid + 1) {
                System.out.print("TOTAL");
                i += lengthOfTotal - 1;
            } else if (i == col1Width + 1) {
                numLength = (int) (Math.log10(WordCounter.sumOfCounters(counter))) + 1; //forced type conversion.....
                for ( ; i <= col1Width + col2Width - (numLength + 2); i++) {
                    System.out.print(" ");
                }
                System.out.print(WordCounter.sumOfCounters(counter));
                i += numLength - 1;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
    /**
     * A method to find the max length of each counted integer inorder to assign a size to the second column.
     * @param initialcol2Width The initial column width is the length of the COUNT string.
     * @param counter The array with the count of each searchterm.
     * @return the maximum initial width that is required for the second column.
     */
    public static int findMaxLengthforCol2(int initialcol2Width, int[] counter) {
        int lengthOfEachNum;
        for (int i = 0; i < counter.length; i++) {
                lengthOfEachNum = (int) (Math.log10(counter[i]) + 1);
            if (initialcol2Width < lengthOfEachNum + 1) { // 1 is added to the length of a number as to incorporate the final sum which can be a maximum of max numLength + 1.
                initialcol2Width = lengthOfEachNum;
            }
        }
        return initialcol2Width;
    }
}
