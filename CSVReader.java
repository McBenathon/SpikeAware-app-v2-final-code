import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// the csv reader class handles all the database file usage such as the search function and reading from the database
public class CSVReader {

    private String fileName;
    // constructors
    public CSVReader(){}

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    // read from database
    public void resourceDatabaseReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length >= 3) {
                    String name = row[0];
                    String url = row[2];
                    System.out.println("\n" + name + " " + url);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // search method
    public void resourceDatabaseSearch() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a keyword or name to search for. eg. spiking: ");
        String search = input.nextLine();
        search = search.toLowerCase();
        int success = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                String[] row = line.split(",");
                if (row.length >= 3) {
                    String name = row[0];
                    String url = row[2];
                    String keywords = row[1];
                    if (keywords.contains(search)) {
                        System.out.println("\n" + name + " " + url);
                        success += 1;
                    } else if (name.contains(search)){
                        System.out.println("\n" + name + " " + url);
                        success += 1;
                    }
                }
            }
            if (success == 0){
                System.out.println("No such file in the database");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // adding to the database method
    public void appendFile(String fileTitle, String content) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter keywords with spaces in between related to the submitted resource: ");
        String keywords = input.nextLine();

        try (FileWriter myWriter = new FileWriter("ResourceDatabase.csv", true)) {
            myWriter.write("\n" + fileTitle + "," + keywords + "," + content);
            System.out.println("The resource has been added to the database.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // adding to the queue which admins review
    public void appendFile(String addFileName, String fileTitle, String content) {
        try (FileWriter myWriter = new FileWriter(addFileName, true)) {
            myWriter.write(fileTitle + "," + content + "\n");
            System.out.println("The resource has been submitted to the queue for validation.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    // the method which admins use to accept or reject a file in the queue
    public void outputList(String fileName) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<String> remainingLines = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for (String line : lines) {
            System.out.println(line);
            System.out.println("Accept?\n1. YES.\n2. NO.\n");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scan.next(); // Discard invalid input
                System.out.println("Enter choice 1 or 2: ");
            }
            int accept = scan.nextInt();


            if (accept == 1) {
                String[] row = line.split(",");

                if (row.length >= 2) {
                    String fileTitle = row[0];
                    String content = row[1];


                    appendFile(fileTitle, content);
                }
                // accepted and deleted
            }
            else if (accept == 2) {
                // rejected and deleted
            }
            else {
                System.out.println("Invalid input, keeping line for safety.");
                remainingLines.add(line);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : remainingLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nDatabase Updated.\n");
    }
}


