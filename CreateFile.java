import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

public class CreateFile {
    private String fileName;

    public CreateFile(String fileName){
        this.fileName = fileName;
    }

    public void createFile() {
        try {
            File myObj = new File(fileName); // Create File object
            if (myObj.createNewFile()) {                    // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
    }
}