package Interview;

import java.io.*;

/**
 * Created by liucong on 2017/5/10.
 */
public class Student implements Serializable{
    private String name;
    private char sex;
    private int year;
    private double gpa;

    public Student() {

    }

    public Student(String name, char sex, int year, double gpa) {
        this.name = name;
        this.sex = sex;
        this.year = year;
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }

    public char getSex() {
        return this.sex;
    }

    public int getYear() {
        return this.year;
    }

    public double getGpa() {
        return this.gpa;
    }

    public static void main(String[] args) {
        Student st = new Student("Tom",'M',20,3.6);
        File file = new File("O:\\Java\\com\\jieke\\io\\student.txt");
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(st);
            os.flush();
            os.close();


            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            Student st1 = (Student)is.readObject();
            is.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
