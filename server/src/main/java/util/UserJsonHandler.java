package util;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class UserJsonHandler {

    private final ClassLoader classLoader = this.getClass().getClassLoader();
    private final StringHandler stringHandler = new StringHandler();

    public String getUsers() {
        try {
            final File file = new File("src/main/res/users.json");
            final StringBuilder stringBuilder = new StringBuilder();
            final BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getUsersWithRevName() {
        try {
            final File file = new File("src/main/res/users.json");
            final StringBuilder stringBuilder = new StringBuilder();
            final BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("\"firstname\"")) {
                    String firstName = getFirstName(line);
                    String reversedName = stringHandler.reverseString(firstName);
                    String flag = "";
                    if (stringHandler.isStringPalindrome(firstName)) {
                        flag = "\n    \"palindrome\": " + "\"true\",";
                    }
                    line = "    \"firstname\": " + reversedName + "," + flag;
                }
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getFirstName(String string) {
        int commaIndex = string.indexOf(",");
        int nameIndex = string.indexOf(" ", 5);
        return string.substring(nameIndex, commaIndex);
    }

}
