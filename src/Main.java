import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Experience exp = new Experience(8);
        Hours hour = new Hours(140);
        Jobtitle jt = new Jobtitle(3);
        int managerid = 18;
        Subordinates subs = new Subordinates(3);
        Subemployee sub = new Subemployee(1);
        Subemployee sub1 = new Subemployee(3);

        Vector subList = new Vector(subs.getamount());
        Managemployee test = new Managemployee(5);
        subList.add(test);
        subList.add(sub);
        subList.add(sub1);
        Iterator itr = subList.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.println(element + " ");
        }
        Subemployee AA = new Subemployee(50);
        Managemployee BB = new Managemployee( exp, hour, jt, managerid, subs, subList);
        BB.output();
        BB.sort();
        BB.output();
        int n = BB.find(test);
        if(n == -1)
            System.out.println("Элемент не найден.");
        else
            System.out.println("Индекс элемента: " + BB.find(test));
        Subemployee s = new Subemployee();
        int k = BB.find(s);
        if(k == -1)
            System.out.println("Элемент не найден.");
        else
            System.out.println("Индекс элемента: " + BB.find(s));
    }
}