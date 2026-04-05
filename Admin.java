import java.util.Scanner;

public class Admin {

    private String[] usernames = {"admin", "admin2"};
    private String[] passwords = {"password", "password2"};

    public Admin(){}

    public int login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = input.next();
        System.out.println("Enter Password: ");
        String password = input.next();

        boolean found = false;
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                System.out.println("Access Granted! Welcome!");
                found = true;
            }
            else{
                System.out.println("Wrong username or password.\n");
                found = false;
            }
        }
        if (!found){
            return 0;
        }
        else{
            return 1;
        }
    }


    public void adminMenu(){
        System.out.println("1. User Analytics.\n2. Added Resource Queue.\n" +
                "3. Return to Home.\n4. Side Menu\n Enter choice: ");

    }



}



