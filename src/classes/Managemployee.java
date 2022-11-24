package classes;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Managemployee extends Subemployee{
    private Subordinates subs;
    public Managemployee(){
        super();
        subs = new Subordinates();
    }

    public Managemployee(int allfields) {
        super(allfields);
        subs = new Subordinates(allfields);
    }

    public Managemployee(Experience exp, Hours hour, Jobtitle jt, int managerid, Subordinates subs){
        super(exp, hour, jt, managerid);
        this.subs = subs;
    }

    public void output() {
        super.output();
        subs.output();
    }

    /**метод ввода**/
    public void input(){
        super.input();
        subs.input();
    }

    /** Метод подсчета зарплаты **/
    public int getsalary(Salary sal){
        int salary = super.getsalary(sal);
        salary += sal.allmoney(salary, subs);
        return salary;
    }
}
