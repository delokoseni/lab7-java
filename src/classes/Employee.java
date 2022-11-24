package classes;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public abstract class Employee {
    /** Счеткич количества сотрудников**/
    protected static int counter = 0;
    /** Индивидуальный номер **/
    protected int  id;
    /** Стаж **/
    protected Experience exp;
    /** Отработанные за месяц часы **/
    protected Hours hour;
    /** Должность **/
    protected Jobtitle jt;
    /** Конструктор класса со всеми параметрами **/
    public Employee(Experience exp, Hours hour, Jobtitle jt) {
        counter++;
        this.id = counter;
        this.exp = exp;
        this.hour = hour;
        this.jt = jt;
    }

    /** Конструктор класса с одним параметром **/
    public Employee(int allfields){
        counter++;
        id = counter;
        if(allfields >= 0) {
            exp = new Experience(allfields);
            hour = new Hours(allfields);
            jt = new Jobtitle(allfields);
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            exp = new Experience();
            hour = new Hours();
            jt = new Jobtitle();
        }
    }

    /** Конструктор класса без параметров **/
    public Employee(){
        counter++;
        id = counter;
        exp = new Experience();
        hour = new Hours();
        jt = new Jobtitle();
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("ID: " + id);
        exp.output();
        hour.output();
        jt.output();
    }

    /** Метод ввода **/
    public void input(){
        exp.input();
        hour.input();
        jt.input();
    }

    /** Метод подсчета зарплаты **/
    public int getsalary(Salary sal){
        int salary = 0;
        salary += hour.hoursmoney(jt, sal);
        salary = sal.allmoney(salary, exp);
        return salary;
    }

    /** Метод определения положена ли премия **/
    public String getpremium(int houramount){
        if (hour.allhours() < houramount)
            return "Премия не положена";
        else
            return "Премия положена";
    }
    /**  Метод вывода счетчика количества сотрудников **/
    public static void printcounter(){
        System.out.println("Количество сотрудников: " + counter);
    }
    public static void minuscounter(){
        counter--;
        System.out.println("Количество сотрудников уменьшено на 1.");
    }
    /** Метод уменьшения количества сотрудников **/
    public static void minuscounter(int number){
        int x = counter;
        counter = counter - number;
        System.out.println("Количество сотрудников уменьшено c " + x + " до " + counter);
    }

    /** Метод обращения к методу внутреннего класса **/
    public void editjtitle(String jtitle, String add){
        jt.editjtitle(jtitle, add);
    }

    /** Метод записи в файл **/
    public abstract void tofile(File file);

    /** Метод записи из файла **/
    public void getfromfile(File file, Scanner sc) {
        try {
            checkfilename cf = new checkfilename();
            if (!cf.checkfileextension(file.getName()))
                throw new Exception("\"Использовано недопустимое расширение файла. Допустимое расширение: \\\".txt\\\".\"");
            counter = Integer.parseInt(sc.nextLine());
            id = Integer.parseInt(sc.nextLine());
            exp.getfromfile(file, sc);
            hour.getfromfile(file, sc);
            jt.getfromfile(file, sc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}