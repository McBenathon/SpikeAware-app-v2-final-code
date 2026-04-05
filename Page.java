import java.awt.*;


public class Page {
    String title;

    public Page(String title){
        this.title = title;
    }

    public void displayPage(){
        ReadFile read = new ReadFile(title + ".txt");
        System.out.println(title);
        read.readFile();
    }
}
