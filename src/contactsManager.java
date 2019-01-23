import java.util.Scanner;

public class contactsManager {


            Scanner s = new Scanner(System.in).useDelimiter("\n");
            public static void main(String[] args)
            {
                start();
            }

            public static void start() {
                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.   ");
                System.out.println("3. Search a contact by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        }
}
