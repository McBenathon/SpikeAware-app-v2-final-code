import java.awt.*;
import java.io.File;
import java.io.IOException;

// class which handles the content in the program
public class Page {
    String title;

    public Page(){};
    public Page(String title){
        this.title = title;
    }

    // displays content of a txt file specified
    public void displayPage(){
        ReadFile read = new ReadFile(title + ".txt");
        System.out.println(title);
        read.readFile();
    }

    // opens a specified PDF using the openPDF function
    public void choosePDF(int choice){
        Analytics analytics = new Analytics();


        switch (choice) {
            case 1:
                analytics.buttonPressed("IntroductionButtonPresses.txt", "IntroductionTimeStamps.txt");
                openPDF("1.Introduction.pdf");
                break;
            case 2:
                analytics.buttonPressed("WhatIsSpikingButtonPresses.txt", "WhatIsSpikingTimeStamps.txt");
                openPDF("2.what_is_spiking.pdf");
                break;
            case 3:
                analytics.buttonPressed("SpikingIsACrimeButtonPresses.txt", "SpikingIsACrimeTimeStamps.txt");
                openPDF("3.spiking_is_a_crime.pdf");
                break;
            case 4:
                analytics.buttonPressed("HowWouldIKnowIfIveBeenSpikedButtonPresses.txt", "HowWouldIKnowIfIveBeenSpikedTimeStamps.txt");
                openPDF("4.how_would_i_know_if_ive_been_spiked.pdf");
                break;
            case 5:
                analytics.buttonPressed("HowSpikingCanMakeYouFeelButtonPresses.txt", "HowSpikingCanMakeYouFeelTimeStamps.txt");
                openPDF("5.how_spiking_can_make_you_feel.pdf");
                break;
            case 6:
                analytics.buttonPressed("WhatToDoIfYouThinkYouveBeenSpikedButtonPresses.txt", "WhatToDoIfYouThinkYouveBeenSpikedTimeStamps.txt");
                openPDF("6.what_to_do_if_you_think_youve_been_spiked.pdf");
                break;
            case 7:
                analytics.buttonPressed("ReportingSpikingButtonPresses.txt", "ReportingSpikingTimeStamps.txt");
                openPDF("7.reporting_spiking.pdf");
                break;
            case 8:
                analytics.buttonPressed("WhereCanIFindSupportButtonPresses.txt", "WhereCanIFindSupportTimeStamps.txt");
                openPDF("8.where_can_i_find_support.pdf");
                break;
            case 9:
                analytics.buttonPressed("MythBustingButtonPresses.txt", "MythBustingTimeStamps.txt");
                openPDF("9.myth_busting.pdf");
                break;
            case 10:
                analytics.buttonPressed("ReferencesButtonPresses.txt", "ReferencesTimeStamps.txt");
                Page references = new Page("References");
                references.displayPage();
                break;
        }
    }

    // opens a PDF file
    public void openPDF(String filePath) {
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
