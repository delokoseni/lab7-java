package classes;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import classes.Employee;

public class Subemployee extends Employee {
    /**ID управляющего**/
    private int managerid;

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