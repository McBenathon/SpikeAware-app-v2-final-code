import java.io.FileNotFoundException;
import java.util.Scanner;

public class SideMenu extends MenuWindow {

    public SideMenu(int num) throws FileNotFoundException {

        if (num>4){
            laterButtons(num);
        }
        else{
            // inherited from MenuWindow class
            super.getMenuButton(num);
        }
    }

    // the options that are different from the main menu
    public void laterButtons(int num) throws FileNotFoundException {
        CSVReader resourceDataRead = new CSVReader("ResourceDatabase.csv");
        Scanner input = new Scanner(System.in);
        switch (num){
            case 5:
                // resource database
                System.out.println("Resource Database");
                analytics.buttonPressed("ResourceDatabaseButtonPresses.txt", "ResourceDatabaseTimeStamps.txt");
                resourceDataRead.resourceDatabaseReader();
                break;
            case 6:
                // the add resource button for users
                System.out.println("Add Resource");
                analytics.buttonPressed("AddResourceButtonPresses.txt", "AddResourceTimeStamps.txt");
                System.out.println("\nEnter the Title of the resource you wish to add: ");
                String fileTitle = input.nextLine();
                System.out.println("Enter the URL of the resource you wish to add: ");
                String content = input.nextLine();
                resourceDataRead.appendFile("AddResourceQueue.csv", fileTitle, content);
                break;
            case 7:
                // the admin login
                System.out.println("Admin Login");
                System.out.println("1. Login.\n2. Home or Side Menu\n");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        Admin admin = new Admin();
                        while (true) {
                            int allowed = admin.login();
                            if (allowed == 0) {
                                System.out.println("1. Try again.\n2. Home or Side Menu\n");
                                int userInp;

                                System.out.println("Enter choice 1 or 2: ");
                                // input validation
                                while (!input.hasNextInt()) {
                                    System.out.println("Invalid input. Please enter 1 or 2.");
                                    input.next(); // Discard invalid input
                                    System.out.println("Enter choice 1 or 2: ");

                                }
                                userInp = input.nextInt();
                                switch (userInp){
                                    case 1:
                                        break;
                                    case 2:
                                        // side menu initialised and called
                                        Menu sideMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Resource Database", "6. Add Resource", "7. Admin Login");
                                        MenuWindow side = new SideMenu(0);
                                        sideMenu.displayMenu();
                                        int sideChoice = sideMenu.menuChoice();
                                        side.getMenuButton(sideChoice);
                                        break;
                                    default:
                                        System.out.println("Invalid option, please try again: ");
                                        break;
                                }
                            }
                            // correct username and password
                            if (allowed == 1) {
                                admin.adminMenu();
                                break;
                            }
                        }

                }

        }

    }

}
