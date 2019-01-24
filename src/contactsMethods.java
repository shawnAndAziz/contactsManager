import Input.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class contactsMethods {
    public static void start() {
        Scanner s = new Scanner(System.in).useDelimiter("\n");

        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.   ");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        int userInput = s.nextInt();

        if (userInput == 1) {
            try {
                viewContacts();
            } catch (Exception e) {
                System.out.println("haha");
                e.printStackTrace();
            }

            System.out.println("Would you like to continue? yes or no");
            Input input = new Input();

            if (input.yesNo()) {
                start();
            }
        } else if (userInput == 2) {
            try {
                addContact();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Would you like to continue? yes or no");
            Input input = new Input();

            if (input.yesNo()) {
                start();
            }
        } else if (userInput == 3) {
            try {
                findContact();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Would you like to continue? yes or no");
            Input input = new Input();

            if (input.yesNo()) {
                start();
            }
        } else if (userInput == 4) {
            try {
                deleteContact();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to continue? yes or no");
            Input input = new Input();

            if (input.yesNo()) {
                start();
            }
        } else if (userInput == 5) {
            System.exit(0);
        }
    }


    public static void viewContacts() throws IOException
    {
        String azizPath = "/Users/azizalyahya/IdeaProjects/contactsManager/data";
        String shawnPath = "/Users/makevio/IdeaProjects/contactsManager/data";
        String contactsTextFile = "contacts.txt";

        Path contactsPath = Paths.get(azizPath, contactsTextFile);

        List<String> contactsList = Files.readAllLines(contactsPath);
        for (String contact : contactsList)
        {
            System.out.println(contact);
        }

    }

    public static void addContact() throws IOException {
        String azizPath = "/Users/azizalyahya/IdeaProjects/contactsManager/data";
        String shawnPath = "/Users/makevio/IdeaProjects/contactsManager/data";
        String contactsTextFile = "contacts.txt";
        Input input = new Input();


        Path contactsPath = Paths.get(azizPath, contactsTextFile);

        List<String> contactsList = Files.readAllLines(contactsPath);
        String contact = input.getString("Enter a new contact: ");
        String number = input.getString("Enter there phone number: ");

        Person person = new Person(contact, number);
        System.out.println(person);
        HashMap<String, String> contactsHashMap = new HashMap<>();
        contactsHashMap.put(contact, number);

        String contactAndNum = person.getName() + "     |     " + person.getNumber();

        contactsList.add(contactAndNum);

        Files.write(contactsPath, contactsList);

    }

    public static void findContact() throws IOException {
        Input input = new Input();
        String findContact = input.getString("What contact would you like to look up?");
        String azizPath = "/Users/azizalyahya/IdeaProjects/contactsManager/data";
        String contactsTextFile = "contacts.txt";
        String shawnPath = "/Users/makevio/IdeaProjects/contactsManager/data";

        Path contactsPath = Paths.get(azizPath, contactsTextFile);

        List<String> contactsList = Files.readAllLines(contactsPath);
        for (String contact : contactsList)
        {
            if (contact.contains(findContact.toLowerCase()))
            {
                System.out.println(contact);
            }
        }

    }

    public static void deleteContact() throws IOException {

        Input input = new Input();
        String contactIwantToDelete = input.getString("What contact would you like delete");
        String contactsTextFile = "contacts.txt";
        String azizPath = "/Users/azizalyahya/IdeaProjects/contactsManager/data";
        String shawnPath = "/Users/makevio/IdeaProjects/contactsManager/data";

        Path contactsPath = Paths.get(azizPath, contactsTextFile);

        List<String> contactsList = Files.readAllLines(contactsPath);
        List<String> tempList = new ArrayList<>();
        for (String contact : contactsList)
        {
            if (!contact.contains(contactIwantToDelete))
            {
                tempList.add(contact);
            }
            Files.write(contactsPath, tempList);

        }

        System.out.println(tempList);
    }
}
