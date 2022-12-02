import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Experience exp = new Experience(8);
        Hours hour = new Hours(140);
        Jobtitle jt = new Jobtitle(3);
        int managerid = 18;
        Subordinates subs = new Subordinates(2);
        Vector subList = new Vector(10);
        for(int i = 0; i < 10; i++){
            subList.add(subs);
        }
        Subemployee AA = new Subemployee(50);
        Managemployee BB = new Managemployee( exp, hour, jt, managerid, subs, subList);
    }
}