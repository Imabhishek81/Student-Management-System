package Student_Management_System;

import java.util.Scanner;
public class InputService {
    protected int getValidRollNo(Scanner src){
        while(true){
            System.out.printf("Enter Roll No : ");
            String inputRollNo = src.nextLine().trim();

            if(inputRollNo.isEmpty()){
                System.out.println("Roll No cannot be empty!");
                continue;
            }

            boolean isNumeric = true;
            for(int i = 0 ; i < inputRollNo.length() ; i++){
                if(!Character.isDigit(inputRollNo.charAt(i))){
                    isNumeric = false;
                    break;
                }
            }
            if(!isNumeric){
                System.out.println("Invalid Roll No! Enter digits only.");
                continue;
            }

            try{
                int rollNo = Integer.parseInt(inputRollNo);

                if(rollNo<=0){
                    System.out.println("Roll No must be positive.");
                    continue;
                }
                return rollNo;
            }
            catch (NumberFormatException n){
                System.out.println("Roll No too large! Please enter a valid number.");
            }
        }
    }
    protected String getValidName(Scanner src){
        while(true){
            System.out.printf("Enter Name : ");
            String inputName = src.nextLine().trim();

            if(inputName.isEmpty()){
                System.out.println("Name cannot be empty!");
                continue;
            }

            boolean isChar = true;
            for(int i = 0 ; i < inputName.length() ; i++){
                char ch = inputName.charAt(i);

                if(!(Character.isLetter(ch) || ch==' ' || ch=='.' || ch=='-')){
                    isChar = false;
                    break;
                }
            }
            if(!isChar){
                System.out.println("Invalid Name! Enter Char only.");
                continue;
            }
            return inputName;
        }
    }
    protected int stringToInt(Scanner src){
        while(true){
            String input = src.nextLine().trim();

            if(input.isEmpty()){
                System.out.println("Cannot be empty!");
                continue;
            }

            boolean isNumeric = true;
            for(int i = 0 ; i < input.length() ; i++){
                if(!Character.isDigit(input.charAt(i))){
                    isNumeric = false;
                    break;
                }
            }
            if(!isNumeric){
                System.out.println("Invalid Input ! Enter digits only.");
                continue;
            }

            int newInput = Integer.parseInt(input);
            if(newInput<=0) {
                System.out.println("must be positive.");
                continue;
            }
            return newInput;
        }
    }
    protected int[] getValidMarks(Scanner src,int sub){
        while(true){
            //System.out.printf("Enter Marks Of Each Subject : ");
            int[]marks = new int[sub];
            for (int i = 0;i<sub;i++){
                marks[i] = getValidSubjectMarks(src);
                if(marks[i] < 0){
                    stringToInt(src);
                }
            }
            return marks;
        }
    }
    protected int getValidSubjectMarks(Scanner src){
        while(true){
            System.out.printf("Enter Marks Of Each Subject : ");
            String inputOption = src.nextLine().trim();

            if(inputOption.isEmpty()){
                System.out.println("Cannot be empty!");
                continue;
            }

            boolean isNumeric = true;
            for(int i = 0 ; i < inputOption.length() ; i++){
                if(!Character.isDigit(inputOption.charAt(i))){
                    isNumeric = false;
                    break;
                }
            }
            if(!isNumeric){
                System.out.println("Invalid! Enter digits only.");
                continue;
            }

            int option = Integer.parseInt(inputOption);
            if(option<=0){
                System.out.println("Must be positive.");
                continue;
            }
            return option;
        }
    }
    protected int getValidInput(Scanner src){
        while(true){
            System.out.printf("Enter : ");
            String inputOption = src.nextLine().trim();

            if(inputOption.isEmpty()){
                System.out.println("Cannot be empty!");
                continue;
            }

            boolean isNumeric = true;
            for(int i = 0 ; i < inputOption.length() ; i++){
                if(!Character.isDigit(inputOption.charAt(i))){
                    isNumeric = false;
                    break;
                }
            }
            if(!isNumeric){
                System.out.println("Invalid! Enter digits only.");
                continue;
            }

            int option = Integer.parseInt(inputOption);
            if(option<=0){
                System.out.println("Must be positive.");
                continue;
            }
            return option;
        }
    }
    protected int getValidSubject(Scanner src){
        while(true){
            System.out.printf("Enter No of Subject : ");
            String inputSub = src.nextLine().trim();

            if(inputSub.isEmpty()){
                System.out.println("Subjects Cannot be empty!");
                continue;
            }

            boolean isNumeric = true;
            for(int i = 0 ; i < inputSub.length() ; i++){
                if(!Character.isDigit(inputSub.charAt(i))){
                    isNumeric = false;
                    break;
                }
            }
            if(!isNumeric){
                System.out.println("Invalid Subject Input ! Enter digits only.");
                continue;
            }

            int inputSub1 = Integer.parseInt(inputSub);
            if(inputSub1<=0) {
                System.out.println("Subject No must be positive.");
                continue;
            }
            return inputSub1;
        }
    }
}



