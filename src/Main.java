import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salary sal = new Salary(10);
        Subemployee AA = new Subemployee(50);
        Managemployee BB = new Managemployee(50);
        System.out.println("Зарплата Subemployee: " + AA.getsalary(sal));
        System.out.println("Зарплата Managemployee: " + BB.getsalary(sal));
        System.out.println("\n" + AA.toString() + "\n");
        System.out.println("\n" + BB.toString() + "\n");
    }
}