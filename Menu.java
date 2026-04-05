import java.util.Scanner;

public class Menu {
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;

    public Menu(){}

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

    public void displayMenu(){
        System.out.println("Menu:\n" + attribute1 + "\n" + attribute2 + "\n" + attribute3 + "\n"
                + attribute4 + "\n" + attribute5 + "\n" + attribute6 + "\n" + attribute7 + "\n");
    }

    public int menuChoice(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter choice 1-7: ");
        int choice = input.nextInt();
        if (choice < 1 || choice > 7){
            return 0;
        }
        return choice;
    }

    public int returnButtons(){
        System.out.println("return to home (1) or use sideMenu (2): ");
        Scanner input = new Scanner(System.in);
        int inp = input.nextInt();
        return inp;
    }

}
