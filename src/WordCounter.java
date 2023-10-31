import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * A basic program that reads in a simple text file and searches for some words.
 * @author 220026989
 * @version - 1.0
 */
public class WordCounter {
    private static int noOfFiles = 1; //to keep a count of the number of files.
    /**
     * Takes in more than one file and its search terms at a time and creates a dynamic array.
     * The dynamic array is then send to another method instantly when a separator is met
     * for further operations.
     * @param args The input from the user
     */
    public static void main(String[] args) {
        ArrayList<String> listOfFileAndSearch = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("!")) {
                increaseFileno();
                counterMain(listOfFileAndSearch);
                listOfFileAndSearch.clear();
            } else {
                listOfFileAndSearch.add(args[i]);
            }
        }
        counterMain(listOfFileAndSearch); //we do not call counter method for file here, since no. of files is already declared as 1.
    }
    /**
     * Main method of the program. Takes in the ArrayList created for each file and its searchterms
     * and converts it into a String array for simple use. The array of Strings is then compared to
     * each word in the file (broken down with the help of useDelimiter) and the count is noted in
     * an array that was created parellelly with the String array
     * @param listOfFileAndSearch The dynamic arraylist that contains the first file and its set of searchterms.
     * @throws Exception when either the usage is not correct or file/searchterm is missing
     */
    public static void counterMain(ArrayList<String> listOfFileAndSearch) {
        String[] arrayOfFileAndSearch = new String[listOfFileAndSearch.size()];
        /**
         * Creating/converting the arraylist to an array of strings.
         * It should be noted that the first index of this array has the file directory and the rest has its respective search words and
         * is kept as such for the entire program.
         */
        for (int i = 0; i < listOfFileAndSearch.size(); i++) {
                arrayOfFileAndSearch[i] = (String) (listOfFileAndSearch.get(i));
            }
            /**
             * An integer array that stores the count of each word that are addressed through the same index parellelly.
             * It should be kept in mind that the first element of the counter array is null(not initialized) as the first
             * index of the arrayOfFilesAndSearch is the search term.So, it is left blank intentionally for simplicity.
             */
        int[] counter = new int[arrayOfFileAndSearch.length];
        try {
            File theFile = new File(arrayOfFileAndSearch[0]); //the first index of the array has the file directory.
            Scanner reader = new Scanner(theFile);
            reader.useDelimiter("[^A-Za-z0-9_]");
            while (reader.hasNext()) {
                String eachWord = reader.next();
                if (eachWord.length() != 0) {
                    for (int i = 1; i < arrayOfFileAndSearch.length; i++) { //the index starts from first because the searchterms start from index 1.
                        if (eachWord.equals(arrayOfFileAndSearch[i])) {
                            counter[i]++;
                        }
                    }
                }
            }
            reader.close();
            if (counter.length <= 2) {
                Output.singleWordSearch(arrayOfFileAndSearch, counter, noOfFiles);
                } else {
                Output.moreWords(arrayOfFileAndSearch, counter, noOfFiles);
            }
        } catch (Exception e) {
            if (arrayOfFileAndSearch.length == 0) {
                System.out.println("Usage: java WordCounter <filename> <searchTerm>");
            } else if (arrayOfFileAndSearch.length == 1) {
                if ((arrayOfFileAndSearch[0].indexOf(".")) > 0) {
                    System.out.println("searchTerm missing");
                } else {
                System.out.println("File not found: " + arrayOfFileAndSearch[0]);
                }
            } else {
            System.out.println("File not found: " + arrayOfFileAndSearch[0]);
            }
        }
    }
    /**
     * Adds the whole counter array.
     * @param counter The array that contains the counted value for its parellel words in args
     * @return The sum of the whole array
     */
    public static int sumOfCounters(int[] counter) {
        int sum = 0;
        for (int i : counter) {
            sum += i;
        }
        return (sum);
    }
    /**
    *A basic class to increment the file number.
    */
    public static void increaseFileno() {
        noOfFiles += 1;
    }
}

