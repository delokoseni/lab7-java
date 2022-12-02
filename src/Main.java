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
        Subordinates subs = new Subordinates(3);
        Subemployee sub = new Subemployee(1);
        Vector subList = new Vector(subs.getamount());
        for(int i = 0; i < 2; i++){
            subList.add(sub);
        }
        Managemployee test = new Managemployee(5);
        subList.add(test);
        Subemployee AA = new Subemployee(50);
        Managemployee BB = new Managemployee( exp, hour, jt, managerid, subs, subList);
        BB.output();
    }
}