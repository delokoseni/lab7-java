import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Subemployee subch = new Subemployee();
        subch.input();
        subch.output();
        Salary sal = new Salary(10);
        Subemployee AA = new Subemployee(10);
        Managemployee BB = new Managemployee(10);
        System.out.println("Зарплата Subemployee: " + AA.getsalary(sal));
        System.out.println("Зарплата Managemployee: " + BB.getsalary(sal));
    }
}