// Handles user registration and login
public class Login {

    // Store user details
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor to set user's name
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Check if username has "_" and is max 5 characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check if password meets all requirements
    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    // Check if number starts with +27 and has 9 digits after
    public boolean checkCellPhoneNumber(String number) {
        return number.matches("^\\+27\\d{9}$");
    }

    // Register user if all inputs are correct
    public String registerUser(String username, String password, String cellPhoneNumber) {

        // Validate username
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        // Validate password
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        // Validate cell number
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // Save details
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;

        // Success message
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    // Check login details
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username != null && this.password != null &&
               this.username.equals(inputUsername) &&
               this.password.equals(inputPassword);
    }

    // Return login result message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}