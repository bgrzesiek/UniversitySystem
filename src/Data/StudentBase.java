package Data;

import Data.Student;
import io.DataReader;

import java.util.Scanner;

public class StudentBase {
private static final int MAX_STUDENT = 100;

    Student[] students = new Student[MAX_STUDENT];

    public void AddStudent(Student student) {
        if (Student.NUMBER_ID<MAX_STUDENT){
            students[Student.NUMBER_ID] = student;
            System.out.println("Pomyślnie dodano do bazy nowego studenta " + students[Student.NUMBER_ID].getName() + " " + students[Student.NUMBER_ID].getLastName());
            Student.NUMBER_ID++;
        }else {
            System.out.println("Maksymalna liczba studentów została osiągnięta");
        }
    }

    public void deleteStudent(int number) {
        System.out.println("Podaj numer studenta");
        System.out.println("Usunięto " + " " + students[number - 1].getName() + " " + students[number - 1].getLastName() + " z listy studentów.");
        students[number - 1] = null;
        int i = number-1;
        do {
            students[i] = students[i + 1];
            i++;
        } while (students[i] != null);
    }

    public void printAllInfo () {
                System.out.println("Lista studentów:");
                int i = 0;
                do {
                    System.out.println(i+1 + ". " +  "nr indeksu:" +  " " + students[i].getIndex() + " " + students[i].getName() + " " + students[i].getLastName());
                    i++;
                }
                while (students[i] != null);
                System.out.println("Koniec listy");
            }
}


