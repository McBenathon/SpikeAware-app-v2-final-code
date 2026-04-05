import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

 public class MenuWindow {

    public MenuWindow(){
    }

    public void getMenuButton(int num) {
        String database = "5. Resource Database";
        String sideMenu = "6. Side Menu";
        String search = "7. Search";
        if (num > 4) {
            laterButtons(num);
        } else {
            switch (num) {
                case 1:
                    Page spikingPage = new Page("Spiking");
                    spikingPage.displayPage();
                    break;
                case 2:
                    Page reportingPage = new Page("Reporting");
                    reportingPage.displayPage();
                    break;
                case 3:
                    Page supportPage = new Page("Support");
                    supportPage.displayPage();
                    break;
                case 4:
                    displayContents();
                    Scanner userI = new Scanner(System.in);
                    System.out.println("enter choice 1-10: ");
                    int choice = userI.nextInt();
                    switch (choice) {
                        case 1:
                            openPDF("1.Introduction.pdf");
                            break;
                        case 2:
                            openPDF("2.what_is_spiking.pdf");
                            break;
                        case 3:
                            openPDF("3.spiking_is_a_crime.pdf");
                            break;
                        case 4:
                            openPDF("4.how_would_i_know_if_ive_been_spiked.pdf");
                            break;
                        case 5:
                            openPDF("5.how_spiking_can_make_you_feel.pdf");
                            break;
                        case 6:
                            openPDF("6.what_to_do_if_you_think_youve_been_spiked.pdf");
                            break;
                        case 7:
                            openPDF("7.reporting_spiking.pdf");
                            break;
                        case 8:
                            openPDF("8.where_can_i_find_support.pdf");
                            break;
                        case 9:
                            openPDF("9.myth_busting.pdf");
                            break;
                        case 10:
                            Page references = new Page("References");
                            references.displayPage();
                            break;
                        default:
                            System.out.println("invalid\n");
                            getMenuButton(4);
                    }

            }
        }
    }

    public void displayContents(){
        System.out.println("CONTENTS\n1. Introduction\n2. What is spiking?\n3. Spiking is a crime\n4. How would I know if I have been spiked?\n" +
                "5. How spiking can make you feel\n" +
                "6. What to do if you think you’ve been spiked?\n" +
                "7. Reporting Spiking\n" +
                "8. Where can I find support?\n" +
                "9. Myth Busting\n" +
                "10. References\n");
    }


    public void laterButtons(int num){
        CSVReader resourceDataRead = new CSVReader("ResourceDatabase.csv");
        switch (num){
            case 5:
                System.out.println("Search ");
                resourceDataRead.resourceDatabaseSearch();
                break;
            case 6:
                Menu sideMenu = new Menu("1. Spiking", "2. Reporting", "3. Support", "4. Toolkit Contents", "5. Resource Database", "6. Add Resource", "7. Admin Login");
                MenuWindow side = new SideMenu(0);
                sideMenu.displayMenu();
                int sideChoice = sideMenu.menuChoice();
                side.getMenuButton(sideChoice);
                break;
            case 7:
                System.out.println("Resource Database");
                resourceDataRead.resourceDatabaseReader();
                break;
        }

    }

    public void openPDF(String filePath){
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(filePath);

                if (myFile.exists()) {
                    Desktop.getDesktop().open(myFile);
                } else {
                    System.out.println("File not found: " + myFile.getAbsolutePath());
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


