import classes.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int years = 10;
        int armyyears = 1;
        int materyears = 0;
        Experience exp3 = new Experience(years, armyyears, materyears);
        int norm = 120;
        int over = 10;
        int week = 10;
        Hours h3 = new Hours(norm, over, week);
        int a = 6;
        float b = 1.2f;
        Subordinates sub3 = new Subordinates(a, b);
        String str = "Менеджер по продажам";
        Jobtitle jt3 = new Jobtitle(str, over, sub3);
        Employee emp3 = new Employee(exp3, h3, jt3);
        Employee[] arr = new Employee[3];
        String jobt3 = "Менеджер по менеджерам";
        Jobtitle a3 = new Jobtitle(jobt3, over, sub3);
        arr[0] = new Employee(exp3, h3, a3);
        arr[1] = new Employee(exp3, h3, a3);
        arr[2] = new Employee(exp3, h3, a3);
        try{
            File file = new File("text.txt");
            if(!file.exists())
                file.createNewFile();
            emp3.tofile(file);
        }
        catch(IOException e){
            System.out.println("...");
        }
    }
}