package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Jobtitle {
    /** Наименование должности **/
    private String jtitle;
    /** Стоимость часа работы **/
    private int hourlycost;

    /** Конструктор со всеми параметрами **/
    public Jobtitle(String jtitle, int hourlycost){
        this.jtitle = jtitle;
        if(hourlycost >= 0)
            this.hourlycost = hourlycost;
        else {
            System.out.println("Указано недопустимое значение hourlycost.");
            this.hourlycost = 0;
        }
    }

    /** Конструктор с одним параметром **/
    public Jobtitle(int allfields){
        if(allfields >= 0) {
            jtitle = Integer.toString(allfields);
            hourlycost = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            jtitle = "";
            hourlycost = 0;
        }
    }

    /** Конструктор без параметров **/
    public Jobtitle(){
        jtitle = "";
        hourlycost = 0;
    }

    /** Метод установки значений **/
    public void set(Jobtitle j){
        this.jtitle = j.jtitle;
        this.hourlycost = j.hourlycost;
    }

    /** Метод ввода класса **/
    public void input(){
        String jtitle;
        int hourlycost;
        Subordinates subs = new Subordinates();
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите должность: ");
        jtitle = inp.nextLine();
        System.out.println("Введите стоимость часа работы: ");
        hourlycost = inp.nextInt();
        subs.input();
        Jobtitle j = new Jobtitle(jtitle, hourlycost);
        this.set(j);
    }

    /** Метод вывода класса **/
    public void output(){
        System.out.println("Должность: " + jtitle);
        System.out.println("Стоимость часа работы: " + hourlycost);
    }

    /** Метод сравнения **/
    public float comparisonhc(int hcost){
        float percent;
        percent = (float)hourlycost / ((float)hcost / 100) - 100;
        return percent;
    }

    /** Метод вспомогательный при вычислении зарплаты **/
    public int jtmoney(int normal){
        int x = 0;
        x += normal * hourlycost;
        return x;
    }

    /** Метод для редактирования должности **/
    public void editjtitle(String jtitle, String add){
        StringBuilder sb = new StringBuilder();
        String[] words = this.jtitle.split(" ");
        this.jtitle = "";
        for(String word : words) {
            if(word.equals(jtitle)) {
                sb.append(add);
                sb.append(" ");
            }
            sb.append(word);
            sb.append(" ");
        }
        this.jtitle = sb.toString();
    }
    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(jtitle + "\n");
            pw.write(hourlycost + "\n");
            pw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /** Метод записи из файла **/
    public void getfromfile(File file, Scanner sc){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            jtitle = sc.nextLine();
            hourlycost = Integer.parseInt(sc.nextLine());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String toString(){
        return "jtitle = " + jtitle +
                ", hourlycost = " + hourlycost;
    }
}