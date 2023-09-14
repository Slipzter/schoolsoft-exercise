import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.NumberHandler;
import util.UserJsonHandler;

public class UserJsonHandlerTests {

    private UserJsonHandler userJsonHandler;

    @BeforeEach
    public void setUp() {
        userJsonHandler = new UserJsonHandler();
    }

    @Test
    public void getUsersShouldGetUsers() {
        String result = userJsonHandler.getUsers();
        Assertions.assertTrue(result.contains("\"firstname\": \"Clementine\""));
        Assertions.assertTrue(result.contains("\"username\": \"bosc\""));
    }

    @Test
    public void getUsersWithRevNameShouldGetUsers() {
        String result = userJsonHandler.getUsersWithRevName();
        Assertions.assertTrue(result.contains("\"lastname\": \"Dietrich\""));
        Assertions.assertTrue(result.contains("\"age\": 45"));
    }

    @Test
    public void getUsersWithRevNameShouldGetUsersWithReverseFirstname() {
        String result = userJsonHandler.getUsersWithRevName();
        Assertions.assertTrue(result.contains("\"firstname\": \"enitnemelC\""));
        Assertions.assertTrue(result.contains("\"firstname\": \"boB\""));
    }

    @Test
    public void getUsersWithRevNameShouldFlagForPalindrome() {
        String result = userJsonHandler.getUsersWithRevName();
        Assertions.assertTrue(result.contains("\"palindrome\": " + "\"true\","));
    }

    @Test
    public void getFirstNameShouldGetFirstName() {
        String line = "    \"firstname\": \"Bob\",";
        String result = userJsonHandler.getFirstName(line);
        Assertions.assertFalse(result.contains("Dietrich"));
        Assertions.assertEquals(" \"Bob\"", result);
    }
}
