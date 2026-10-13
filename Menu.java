import java.util.Scanner;

// menu class for displaying menus and getting user inputs
public class Menu {
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;

    public Menu(){}

    // constructor
    public Menu(String attribute1, String attribute2, String attribute3, String attribute4,
                String attribute5, String attribute6, String attribute7){
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.attribute6 = attribute6;
        this.attribute7 = attribute7;
    }

    // displays the attributes in the constructor
    public void displayMenu(){
        System.out.println("Menu:\n" + attribute1 + "\n" + attribute2 + "\n" + attribute3 + "\n"
                + attribute4 + "\n" + attribute5 + "\n" + attribute6 + "\n" + attribute7 + "\n");
    }

    // the main user input for menu choices
    public int menuChoice(){
        Scanner scan = new Scanner(System.in);
        int input;
        System.out.println("Enter choice 1-7: ");
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter 1 to 7.");
            scan.next(); // Discard invalid input
            System.out.println("Enter choice 1-7: ");
        }
        input = scan.nextInt();
        if (input < 1 || input > 7){
            return 0;
        }
        return input;


    }



}
