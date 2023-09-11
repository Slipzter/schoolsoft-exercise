package util;

import java.util.ArrayList;
import java.util.List;

public class StringHandler {

    public String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public boolean isStringPalindrome(String string) {
        string = string.replaceAll("\\s", "").toLowerCase();
        int leftIndex = 0;
        int rightIndex = string.length() - 1;
        while (leftIndex < rightIndex) {
            if (string.charAt(leftIndex) != string.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public List<Integer> stringToIntList(String string) {
        List<Integer> intList = new ArrayList<>();
        String[] strNumbers = string.split(",");
        for (String strNumber : strNumbers) {
            try {
                int number = Integer.parseInt(strNumber);
                intList.add(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return intList;
    }
}
