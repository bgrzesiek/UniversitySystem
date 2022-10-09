package io;

import Data.Student;

import java.util.Scanner;

public class DataReader {

    private Scanner sc = new Scanner(System.in);

    public void close()
    {sc.close();
    }

    public Student readAndCreateStudent(){
        System.out.println("Imię: ");
        String name = sc.nextLine();
        System.out.println("Nazwisko: ");
        String lastName = sc.nextLine();
        return new Student(name, lastName, Student.INDEX_COUNT);
    }

    public int getIn(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
    public String getInString(){
        String string = sc.nextLine();
        return string;
    }
}
