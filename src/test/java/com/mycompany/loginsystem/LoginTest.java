import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for Login class
public class LoginTest {

    // Create a test user
    Login login = new Login("Jared", "Singh");

    // Check valid username
    @Test
    public void testUsernameCorrect() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    // Check invalid username
    @Test
    public void testUsernameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!"));
    }

    // Check valid password
    @Test
    public void testPasswordCorrect() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    // Check invalid password
    @Test
    public void testPasswordIncorrect() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // Check valid cell number
    @Test
    public void testCellCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    // Check invalid cell number
    @Test
    public void testCellIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // Check successful login
    @Test
    public void testLoginSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    // Check failed login
    @Test
    public void testLoginFail() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
    }

    // Check successful registration message
    @Test
    public void testRegisterSuccessMessage() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(
            "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.",
            result
        );
    }

    // Check username error message
    @Test
    public void testRegisterUsernameFailMessage() {
        String result = login.registerUser("kyle!!!!", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            result
        );
    }

    // Check password error message
    @Test
    public void testRegisterPasswordFailMessage() {
        String result = login.registerUser("kyl_1", "password", "+27838968976");

        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            result
        );
    }

    // Check cell number error message
    @Test
    public void testRegisterCellFailMessage() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");

        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            result
        );
    }
}