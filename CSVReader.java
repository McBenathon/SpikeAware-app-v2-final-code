import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVReader {

    private String fileName;

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

        public void resourceDatabaseReader(){
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

        public void resourceDatabaseSearch(){
            Scanner input = new Scanner(System.in);
            System.out.println("enter a keyword to search for. eg. spiking: ");
            String search = input.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] row = line.split(",");
                    if (row.length >= 3) {
                        String name = row[0];
                        String url = row[2];
                        String keywords = row[1];
                        if (keywords.contains(search)){
                            System.out.println("\n" + name + " " + url);
                        }

                    }
                }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendFile(String fileTitle, String content){
        Scanner input = new Scanner(System.in);
        System.out.println("enter keywords with spaces in between related to the submitted resource: ");
        String keywords = input.nextLine();

        try (FileWriter myWriter = new FileWriter(fileName, true)) {
            myWriter.write("\n" + fileTitle + "," + keywords + "," + content);
            System.out.println("The resource has been added to the database.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void appendFile(String addFileName, String fileTitle, String content){
        try (FileWriter myWriter = new FileWriter(addFileName, true)) {
            myWriter.write("\n" + fileTitle + "," + content);
            System.out.println("The resource has been submitted to the queue for validation.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

