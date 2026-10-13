import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

 public class MenuWindow {
     Analytics analytics = new Analytics();

    public MenuWindow(){
    }

    public void getMenuButton(int num) throws FileNotFoundException {

        if (num > 4) {
            laterButtons(num);
        } else {
            // the main 4 options. same for main menu and side menu
            switch (num) {
                case 1:
                    // page
                    Page spikingPage = new Page("Spiking");
                    analytics.buttonPressed("SpikingButtonPresses.txt", "SpikingTimeStamps.txt");
                    spikingPage.displayPage();
                    break;
                case 2:
                    // page
                    Page reportingPage = new Page("Reporting");
                    analytics.buttonPressed("ReportingButtonPresses.txt", "ReportingTimeStamps.txt");
                    reportingPage.displayPage();
                    break;
                case 3:
                    // page
                    Page supportPage = new Page("Support");
                    analytics.buttonPressed("SupportButtonPresses.txt", "SupportTimeStamps.txt");
                    supportPage.displayPage();
                    break;
                case 4:
                    // toolkit contents
                    Page toolkitPage = new Page();
                    do {
                        displayContents();
                        System.out.println("enter choice 1-10: ");
                        Scanner scan = new Scanner(System.in);
                        int input;
                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid input. Please enter 1-10.");
                            scan.next(); // Discard invalid input
                            System.out.println("Enter Choice: ");

                        }
                        input = scan.nextInt();
                        if (input >= 1 && input <= 10) {
                            // calls function in the page class for opening a pdf
                            toolkitPage.choosePDF(input);
                            break;
                        }
                        System.out.println("Invalid option, please try again.\n");

                    }while(true);

            }
        }
    }

    public void displayContents(){
        // contents of the toolkit
        System.out.println("CONTENTS\n1. Introduction\n2. What is spiking?\n3. Spiking is a crime\n4. How would I know if I have been spiked?\n" +
                "5. How spiking can make you feel\n" +
                "6. What to do if you think you’ve been spiked?\n" +
                "7. Reporting Spiking\n" +
                "8. Where can I find support?\n" +
                "9. Myth Busting\n" +
                "10. References\n");
    }

    // the choices which are different to the side menu
    public void laterButtons(int num) throws FileNotFoundException {
        CSVReader resourceDataRead = new CSVReader("ResourceDatabase.csv");
        switch (num){
            case 5:
                // search bar
                System.out.println("Search");
                resourceDataRead.resourceDatabaseSearch();
                break;
            case 6:
                // side menu
                Menu sideMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Resource Database", "6. Add Resource", "7. Admin Login");
                MenuWindow side = new SideMenu(0);
                sideMenu.displayMenu();
                int sideChoice = sideMenu.menuChoice();
                side.getMenuButton(sideChoice);
                break;
            case 7:
                // the resource database
                System.out.println("Resource Database");
                analytics.buttonPressed("ResourceDatabaseButtonPresses.txt", "ResourceDatabaseTimeStamps.txt");
                resourceDataRead.resourceDatabaseReader();
                break;
        }

    }



}


