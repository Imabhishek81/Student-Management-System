package Student_Management_System;

import java.io.*;
import java.util.ArrayList;
public class Main {
    static final String FILE_NAME = "StudentManagent.txt";
    public static void main(String[] args) {
        StudentService service = new StudentService();
        ArrayList<Student> list = loadStudents();

        service.Service(service,list);

        saveStudents(list);
        System.out.println("Data saved successfully!");
    }
    //LOAD data from file
    public static ArrayList<Student>loadStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            System.out.println("File read error / corrupted file. Starting fresh.");
            return new ArrayList<>();
        }
    }
    //SAVE data into file
    public static void saveStudents(ArrayList<Student> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}

