import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin {
    // admin log in credentials
    private String[] usernames = {"admin", "admin2", "1"};
    private String[] passwords = {"password", "password2", "1"};

    public Admin(){}

    // log in function
    public int login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = input.next();
        System.out.println("Enter Password: ");
        String password = input.next();

        // checks if input matches any of the pairs of usernames and passwords
        boolean found = false;
        for (int i = 0; i < usernames.length;) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                System.out.println("Access Granted\n");
                found = true;
                break;
            }
            else{
                i++;

            }
            found = false;
        }
        if (!found){
            System.out.println("Wrong username or password.\n");
            return 0;
        }
        else{
            return 1;
        }
    }

    // menu for the admins
    public void adminMenu() {
        Analytics analytics = new Analytics();
        System.out.println("1. User Analytics.\n2. Added Resource Queue.\n" + "3. Home or Side Menu\nEnter choice: ");
        Scanner scan = new Scanner(System.in);
        int input;
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter 1 to 3.");
            scan.next(); // Discard invalid input
            System.out.println("Enter choice 1-3: ");
        }
        input = scan.nextInt();
        if (input < 1 || input > 3) {
            System.out.println("Invalid option, please try again.");
            adminMenu();
        }
        switch (input) {
            // displays the user analytics
            case 1:
                System.out.println("User Analytics:\n");
                analytics.viewAnalytics("SpikingButtonPresses.txt", "SpikingTimestamps.txt", "Spiking");
                analytics.viewAnalytics("ReportingButtonPresses.txt", "ReportingTimestamps.txt", "Reporting");
                analytics.viewAnalytics("IntroductionButtonPresses.txt", "IntroductionTimestamps.txt", "Introduction");
                analytics.viewAnalytics("WhatIsSpikingButtonPresses.txt", "WhatIsSpikingTimestamps.txt", "What Is Spiking");
                analytics.viewAnalytics("SpikingIsACrimeButtonPresses.txt", "SpikingIsACrimeTimestamps.txt", "Spiking Is A Crime");
                analytics.viewAnalytics("HowWouldIKnowIfIveBeenSpikedButtonPresses.txt", "HowWouldIKnowIfIveBeenSpikedTimestamps.txt", "How Would I Know If I Have Been Spiked");
                analytics.viewAnalytics("HowSpikingCanMakeYouFeelButtonPresses.txt", "HowSpikingCanMakeYouFeelTimestamps.txt", "How Spiking Can Make You Feel");
                analytics.viewAnalytics("WhatToDoIfYouThinkYouveBeenSpikedButtonPresses.txt", "WhatToDoIfYouThinkYouveBeenSpikedTimestamps.txt", "What To Do If You Think You've Been Spiked");
                analytics.viewAnalytics("ReportingSpikingButtonPresses.txt", "ReportingSpikingTimestamps.txt", "Reporting Spiking");
                analytics.viewAnalytics("WhereCanIFindSupportButtonPresses.txt", "WhereCanIFindSupportTimestamps.txt", "Where Can I Find Support");
                analytics.viewAnalytics("MythBustingButtonPresses.txt", "MythBustingTimestamps.txt", "Myth Busting");
                analytics.viewAnalytics("ReferencesButtonPresses.txt", "ReferencesTimestamps.txt", "References");
                analytics.viewAnalytics("AddResourceButtonPresses.txt", "AddResourceTimestamps.txt", "Add Resource");
                analytics.viewAnalytics("ResourceDatabaseButtonPresses.txt", "ResourceDatabaseTimestamps.txt", "Resource Database");
                adminMenu();
                break;
            case 2:
                // displays the queue for added resources and the admin can choose to accept or not
                CSVReader addedQueue = new CSVReader();
                addedQueue.outputList("AddResourceQueue.csv");
                adminMenu();
                break;
            case 3:
                // leaves the menu
                break;
        }

    }



}



