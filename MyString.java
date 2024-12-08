/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("heltlo", "hello"));
        System.out.println(randomStringOfLetters(100));
        System.out.println(remove("committee", "meet"));
        System.out.println(removeCharOnce("meet", 'e'));
        System.out.println(insertRandomly('s',"cat"));

    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0.
     *
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        boolean isSubString = true;

        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str1, str1.charAt(i)) > countChar(str2, str1.charAt(i))) {
                isSubString = false;
                break;
            }
        }
        return isSubString;
    }


    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     *
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String strWithSpaces = "";

        for (int i = 0; i < str.length() - 1; i++) {
            strWithSpaces += ' ';
            strWithSpaces += str.charAt(i);
        }
        if (str.length() > 0) {
            strWithSpaces += ' ';
            strWithSpaces += str.charAt(str.length() - 1);
        } else {
            strWithSpaces += ' ';
        }
        return strWithSpaces;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * <p>
     * Example: randomStringOfLetters(3) can return "zoo"
     *
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomString = "";

        for (int i = 0; i < n; i++) {
            int numberToAdd = (int) (Math.random() * 26 + 97);
            randomString += (char) numberToAdd;
        }
        return randomString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */

    public static String removeCharOnce(String str, char ch) {

        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        char[] arrNew = new char[str.length() - 1];
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                for (int b = 0; b < i; b++) {
                    arrNew[b] = arr[b];
                }
                for (int a = i; a < arrNew.length; a++, i++) {
                    arrNew[a] = arr[i + 1];
                }
                break;
            }
        }
        for (int i = 0; i < arrNew.length; i++) {
            newString += arrNew[i];
        }
        return newString;
    }


    public static String remove(String str1, String str2) {
        String New = "";
        String str2Temp =  str2;
        boolean contains = false;

        for (int i = 0; i < str1.length(); i++) {
            contains = false;
            for (int j = 0; j < str2Temp.length(); j++) {
                if (str1.charAt(i) == str2Temp.charAt(j)) {
                    contains = true;
                    str2Temp = removeCharOnce(str2Temp, str2Temp.charAt(j));
                    break;
                }
            }
            if (contains == false) {
                New += str1.charAt(i);
            }
        }
        return New;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".
     *
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));

        // Insert the character at the random index
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
