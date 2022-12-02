package classes;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

public class Managemployee extends Subemployee{
    private Subordinates subs;
    private Vector subList;
    public Managemployee(){
        super();
        subs = new Subordinates();

        subList = new Vector(10);
        for(int i = 0; i < 10; i++){
            subList.add(subs);
        }
    }

    public Managemployee(int allfields) {
        super(allfields);
        subs = new Subordinates(allfields);
        subList = new Vector(subs.getamount());
        if(allfields >= 1)
            for(int i = 0; i < allfields; i++)
                subList.add(allfields);
        else{
            System.out.println("Указано недопустимое значение allfields для subList.");
            for(int i = 0; i < subs.getamount(); i++)
                subList.add(0);
        }
    }

    public Managemployee(Experience exp, Hours hour, Jobtitle jt, int managerid,
                         Subordinates subs, Vector subList){
        super(exp, hour, jt, managerid);
        this.subs = subs;
        this.subList = subList;
    }

    public void output() {
        super.output();
        subs.output();
        System.out.println("Массив ID подчиненных:");
        for(int i = 0; i < subList.size(); i++){
            System.out.println(subList.get(i));
        }
    }

    /**метод ввода**/
    /**public void input(){
        super.input();
        subs.input();
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите количество подчиненных: ");
        int n = inp.nextInt();
        for(int i = 0; i < n;i++){
            System.out.println("Введите ID подчиненного: ");
            n = inp.nextInt();
            //subList.add(n);
        }
    }
**/
    /** Метод подсчета зарплаты **/
   /** public int getsalary(Salary sal){
        int salary = super.getsalary(sal);
        salary += sal.allmoney(salary, subs);
        return salary;
    }

    public String toString(){
        return super.toString() + "\n" +
                subs.toString();
    }
    **/
}
