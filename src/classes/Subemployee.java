package classes;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Subemployee extends Employee {
    /**ID управляющего**/
    private int managerid;

    public Subemployee(){
        super();
        managerid = 0;
    }

    public Subemployee(int allfields) {
        super(allfields);
        if(allfields >= 0)
            managerid = allfields;
        else
            managerid = 0;
    }

    public Subemployee(Experience exp, Hours hour, Jobtitle jt, int managerid){
        super(exp, hour, jt);
        if(managerid >=0)
            this.managerid = managerid;
        else{
            System.out.println("Указано недопустимое значение managerid.");
            this.managerid = 0;
        }
    }

    /**Определение абстрактного метода**/
    @Override
    public void tofile(File file) {
        try {
            checkfilename cf = new checkfilename();
            if (!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(counter + "\n");
            pw.write(id + "\n");
            pw.close();
            exp.tofile(file);
            hour.tofile(file);
            jt.tofile(file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}