import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class contactsManager
{

    public static void main(String[] args)
    {
        start();
    }
            public static void start()
            {
                Scanner s = new Scanner(System.in).useDelimiter("\n");

                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.   ");
                System.out.println("3. Search a contact by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                System.out.println("Enter an option (1, 2, 3, 4 or 5):");
                int userInput = s.nextInt();

                if (userInput == 1)
                {
                    try {
                        viewContacts();
                    }
                    catch (Exception e)
                    {
                        System.out.println("haha");
                        e.printStackTrace();
                    }
                }
        }

        public static void viewContacts() throws IOException
        {
            String azizPath = "/Users/azizalyahya/IdeaProjects/contactsManager/data";
            String shawnPath = "/Users/makevio/IdeaProjects/contactsManager/data";

            Path contactsPath = Paths.get(azizPath, "contacts.txt");

            List<String> contactsList = Files.readAllLines(contactsPath);
            for (String contact : contactsList)
            {
                System.out.println(contact);
            }

        }


}
