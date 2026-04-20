import java.util.Scanner;

// Main class to run the program
public class Main {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner input = new Scanner(System.in);

        System.out.println("=== USER REGISTRATION ===\n");

        // Get user's name
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        // Create Login object
        Login user = new Login(firstName, lastName);

        String result;

        // Loop until registration is successful
        do {

            // Username requirement
            System.out.println("\nUsername requirement:");
            System.out.println("- Must contain an underscore");
            System.out.println("- Must be no more than five characters long");
            System.out.print("Enter username: ");
            String username = input.nextLine();

            // Password requirement
            System.out.println("\nPassword requirement:");
            System.out.println("- Must be at least eight characters long");
            System.out.println("- Must include a capital letter, a number, and a special character");
            System.out.print("Enter password: ");
            String password = input.nextLine();

            // Cell number requirement
            System.out.println("\nCell phone number requirement:");
            System.out.println("- Must start with +27");
            System.out.println("- Must be followed by nine digits");
            System.out.print("Enter cell phone number: ");
            String cell = input.nextLine();

            // Attempt registration
            result = user.registerUser(username, password, cell);
            System.out.println("\n" + result);

        } while (!result.contains("successfully"));

        System.out.println("\n=== LOGIN ===");

        boolean loggedIn = false;

        // Loop until login is successful
        while (!loggedIn) {

            // Get login details
            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            // Check login
            loggedIn = user.loginUser(loginUser, loginPass);

            // Show login result
            System.out.println(user.returnLoginStatus(loggedIn));
        }
    }
}