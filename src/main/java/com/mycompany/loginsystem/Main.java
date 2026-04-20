import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== USER REGISTRATION ===\n");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        Login user = new Login(firstName, lastName);

        String result;

        do {
            System.out.println("\nUsername must contain an underscore and be no more than five characters long.");
            System.out.println("Password must be at least eight characters long and include a capital letter, a number, and a special character.");
            System.out.println("Cell phone number must start with +27 and be followed by nine digits.\n");

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            System.out.print("Enter cell phone number: ");
            String cell = input.nextLine();

            result = user.registerUser(username, password, cell);
            System.out.println(result);

        } while (!result.contains("successfully"));

        System.out.println("\n=== LOGIN ===");

        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            loggedIn = user.loginUser(loginUser, loginPass);

            System.out.println(user.returnLoginStatus(loggedIn));
        }
    }
}