package Student_Management_System;

import java.io.Serializable;
import java.util.Scanner;
public class Student implements Serializable {
    private int rollNo;
    private String name;
    private int[] marks;
    Student(int rollNo,String name,int[] marks){
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public int[] getMarks(){
        return marks;
    }
    public void setMarks(Scanner src,InputService inp){
        System.out.printf("No of Sub ");
        int sub = inp.getValidInput(src);
        System.out.println();
        System.out.printf("Marks Of Each Subject : ");
        int[]newMarks = new int[sub];
        for (int i = 0;i<sub;i++){
            newMarks[i] = src.nextInt();
        }
        this.marks = newMarks;
        System.out.println("Marks Updated Succefully");
        src.nextLine();
    }
    public void setName(Scanner src,InputService inp){
        //System.out.println();
        System.out.printf("New Name To Update ");
        String newName = inp.getValidName(src);
        this.name = newName;
        System.out.println("Name Updated Succefully");
    }
    public int calculateTotal(){
        int total=0;
        for(int i = 0 ; i< marks.length;i++){
            total = total+marks[i];
        }
        return total;
    }
    public double calculatePercentage(){
        return (calculateTotal()/(marks.length * 100.0))*100;
    }
    public String calculateGrade(){
        double p = calculatePercentage();
        if(p>=90) return "O";
        else if (p>=80) return "A+";
        else if (p>=70) return "A";
        else if (p>=60) return "B+";
        else if (p>=50) return "B";
        else if (p>=40) return "C+";
        else return "F";
    }
}

