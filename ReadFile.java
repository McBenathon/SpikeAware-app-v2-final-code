import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// function used to open and read a txt file. used in the page class.
public class ReadFile {
    private String fileName;

    public ReadFile(String fileName){
        this.fileName = fileName;
    }

    public void readFile() {
        File myObj = new File(fileName);

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}