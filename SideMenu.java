import com.sun.tools.javac.Main;

import java.util.Scanner;

public class SideMenu extends MenuWindow {

    public SideMenu(int num) {
        if (num>4){
            laterButtons(num);
        }
        else{
            super.getMenuButton(num);
        }
    }


    public void laterButtons(int num){
        CSVReader resourceDataRead = new CSVReader("ResourceDatabase.csv");
        Scanner input = new Scanner(System.in);
        switch (num){
            case 5:
                System.out.println("Resource Database");
                resourceDataRead.resourceDatabaseReader();
                break;
            case 6:
                System.out.println("Add Resource");
                System.out.println("\nenter the Title of the resource you wish to add: ");
                String fileTitle = input.nextLine();
                System.out.println("enter the URL of the resource you wish to add: ");
                String content = input.nextLine();
                resourceDataRead.appendFile("AddResourceQueue.csv", fileTitle, content);
                break;
            case 7:
                System.out.println("Admin Login");
                System.out.println("1. Login.\n2. Back to Home.\n3. Use Side Menu\n");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        Admin admin = new Admin();
                        while (true) {
                            int allowed = admin.login();
                            if (allowed == 0) {
                                System.out.println("1. try again.\n2. Back to Home\n3. Use Side Menu\n");
                                int inp = input.nextInt();
                                switch (inp){
                                    case 1:
                                        break;
                                    case 2:

                                }
                            }
                            if (allowed == 1) {
                                admin.adminMenu();
                                break;
                            }
                        }

                }

        }

    }

}
