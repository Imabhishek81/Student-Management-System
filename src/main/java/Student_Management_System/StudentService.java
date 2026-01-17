package Student_Management_System;

import java.util.ArrayList;
import java.util.Scanner;
public class StudentService {
    Scanner src = new Scanner(System.in);
    InputService inp = new InputService();
    public void addStudent(ArrayList<Student> list){
        int rollNo = inp.getValidRollNo(src);
        String name = inp.getValidName(src);
        System.out.printf("No of Subject ");
        int sub = inp.getValidInput(src);
        int []returnedMarks = inp.getValidMarks(src,sub);
        int[]marks = new int[sub];
        System.arraycopy(returnedMarks,0,marks,0,sub);
        list.add(new Student(rollNo,name,marks));
        System.out.println("Student Added Succefully!!");
        //src.nextLine();
    }
    public void displayAllStudents(ArrayList<Student> list){
        if(!list.isEmpty()){
            System.out.println("\n========== STUDENT REPORTS ==========");
            System.out.printf("%-10s %-15s %-10s %-12s %-8s%n",
                    "RollNo", "Name", "Total", "Percentage", "Grade");
            System.out.println("----------------------------------------------------------");
            for(Student s : list){
                int total = s.calculateTotal();
                double percent = s.calculatePercentage();
                String grade = s.calculateGrade();
                System.out.printf("%-10d %-15s %-10d %-12.2f %-8s%n",
                        s.getRollNo(), s.getName(), total, percent, grade);
            }

            System.out.println("=====================================\n");
        }
        else{
            System.out.println("No student records found!");
            return;
        }
    }
    public void displayStudent(Student s1,ArrayList<Student> list){
        if(!list.isEmpty()){
            System.out.println("\n========== "+ s1.getName()+" REPORT ==========");
            System.out.printf("%-10s %-15s %-10s %-12s %-8s%n",
                    "RollNo", "Name", "Total", "Percentage", "Grade");
            System.out.println("----------------------------------------------------------");
            int total = s1.calculateTotal();
            double percent = s1.calculatePercentage();
            String grade = s1.calculateGrade();
            System.out.printf("%-10d %-15s %-10d %-12.2f %-8s%n",
                    s1.getRollNo(), s1.getName(), total, percent, grade);

            System.out.println("=====================================\n");
        }
        else{
            System.out.println("No student records found!");
            return;
        }
    }
    public Student searchStudentByRoll(ArrayList<Student> list){
        //System.out.printf("Enter Roll No to Search : ");
        int rollNo = inp.getValidRollNo(src);
        //System.out.println();
        for(Student s : list){
            if(rollNo == s.getRollNo()){
                System.out.println("Student found");
                return s;
            }
        }System.out.println("Student not found");
        return null;
    }
    public void updateStudent(ArrayList<Student> list){
        Student s = searchStudentByRoll(list);
        if(s==null){
            System.out.println("Student not found");
        }
        else{
            System.out.println("1.Update Name\n"+"2.Update Marks\n"+"3.Update Both");
            //System.out.println();
            System.out.printf("Select one option from the menue (1/2/3) \n");
            int choice = inp.getValidInput(src);
            switch (choice){
                case 1 :
                    s.setName(src,inp);
                    break;
                case 2 :
                    s.setMarks(src,inp);
                    break;
                case 3 :
                    s.setName(src,inp);
                    s.setMarks(src,inp);
                    break;
                default:
                    System.out.println("Please Enter Correct Option");
                    break;
            }
            System.out.println("Student updated successfully");
        }
    }
    public void deleteStudent(ArrayList<Student> list){
        Student s = searchStudentByRoll(list);
        if(s==null){
            System.out.println("Student not found");
        }
        else{
            list.remove(s);
            System.out.println("Student Deleted successfully");
        }
    }
    public void Service(StudentService service,ArrayList<Student> list){
        int choices;
        do{
            System.out.println("1.Add Student");
            System.out.println("2.Display Students");
            System.out.println("3.Search Student");
            System.out.println("4.Update Student");
            System.out.println("5.Delete Student");
            System.out.println("6.Exit");
            System.out.printf("Select one option among the menue ");
            choices = inp.getValidInput(src);
            switch (choices){
                case 1:
                    service.addStudent(list);
                    break;
                case 2:
                    service.displayAllStudents(list);
                    break;
                case 3:
                    Student s = service.searchStudentByRoll(list);
                    if(s!=null){
                        service.displayStudent(s,list);
                    }
                    break;
                case 4:
                    service.updateStudent(list);
                    break;
                case 5:
                    service.deleteStudent(list);
                    break;
                case 6:
                    System.out.println("Program exited");
                    break;
                default:
                    System.out.println("Please Choose the correct option");
                    break;
            }
        }while(choices != 6);
    }
}

