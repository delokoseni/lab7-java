import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        Subordinates sub1 = new Subordinates();
        String str = "Менеджер по продажам";
        Jobtitle jt3 = new Jobtitle(str, over, sub3);
        String jobt3 = "Менеджер по менеджерам";
        Jobtitle a3 = new Jobtitle(jobt3, over, sub3);



        Employee[] arr = new Employee[3];
        Employee[][] arr1 = new Employee[2][2];
        int i,j;



        try{
            File file = new File("text.txt");
            for(i = 0; i < 3; i++) {
                System.out.println("arr["+i+"]");
                arr[i] = new Employee();
                arr[i].tofile(file);
                arr[i].output();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }



        try {
            File file = new File("text.txt");
            Scanner sc = new Scanner(file);
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    System.out.println("arr1[" + i + "]" + "[" + j + "]");
                    arr1[i][j] = new Employee();
                    arr1[i][j].getfromfile(file, sc);
                    arr1[i][j].output();
                }
            }
            sc.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }
}