import java.io.FileNotFoundException;
import java.util.Scanner;

public class Home {

    public Home(){}

    // the home function is the main menu which runs when the program starts and when the user returns to the home page
    public void home() throws FileNotFoundException {
        Menu mainMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Search", "6. Side Menu", "7. Resource Database");
        MenuWindow menu = new MenuWindow();
        Menu sideMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Resource Database", "6. Add Resource", "7. Admin Login");
        MenuWindow side = new SideMenu(0);
        do {
            // display the menu
            mainMenu.displayMenu();
            // user input
            int choice = mainMenu.menuChoice();
            if (choice == 0) {
                System.out.println("Invalid option chosen, please try again.\n\n");
            }
            else {
                System.out.println("You have chosen option: " + choice);
                // user input selects an option
                menu.getMenuButton(choice);
                while (true) {
                    // return buttons
                    System.out.println("return to home (1) or use Side Menu (2): ");
                    Scanner scan = new Scanner(System.in);
                    int input;
                    // input validation
                    while (!scan.hasNextInt()) {
                        System.out.println("Invalid input. Please enter 1 or 2");
                        scan.next(); // Discard invalid input
                        System.out.println("Return to home (1) or use Side Menu (2): ");

                    }
                    input = scan.nextInt();
                    // choice after input validation
                    switch (input) {
                        case 1:
                            home();
                        case 2:
                            do {
                                // side menu called
                                sideMenu.displayMenu();
                                int sideChoice = sideMenu.menuChoice();
                                if (sideChoice != 0){
                                    side.getMenuButton(sideChoice);
                                    break;
                                }
                                System.out.println("Invalid option chosen, please try again.\n\n");
                            }while(true);

                            continue;
                        default:
                            System.out.println("Invalid Option");
                    }
                }

            }

        }while(true);

    }
}
