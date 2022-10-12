package Application;

import Data.Student;
import Data.StudentBase;
import io.DataReader;

public class UniversitySystemControl {

    private static final int EXIT = 0;
    private static final int ADD_STUDENT = 1;
    private static final int DEL_STUDENT = 2;
    private static final int RENAME_STUDENT=3;
    private static final int PRINT_STUDENT_LIST = 4;

    private DataReader dataReader = new DataReader();
    private StudentBase studentBase = new StudentBase();

    public void controlLoop() {
    int option;
        do {
            printOption();
            option = dataReader.getIn();
            switch (option) {
                case ADD_STUDENT:
                    addStudent();
                    break;
                case DEL_STUDENT:
                    deleteStudent();
                    break;
                case RENAME_STUDENT:
                    renameStudent();
                    break;
                case PRINT_STUDENT_LIST:
                    studentBase.printAllInfo();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
            }
        } while (option != EXIT) ;
    }

    private void printOption(){
        System.out.println("Wybierz opcje:");
        System.out.println(EXIT + "- wyjście z programu");
        System.out.println(ADD_STUDENT + "- dodaj studenta");
        System.out.println(DEL_STUDENT + "- usuń studenta");
        System.out.println(RENAME_STUDENT + "- zmień dane studenta");
        System.out.println(PRINT_STUDENT_LIST + "- wyświetl listę studentów");
    }

    private void addStudent(){
        if (studentBase.isStudenBaseFull()) {
            Student student = dataReader.readAndCreateStudent();
            studentBase.areYouSureAddNewStudent(student.getName(), student.getLastName());
            String string = dataReader.getInString();
            switch (string) {
                case "t":
                    studentBase.AddStudent(student);
                    break;
                case "n":
                    System.out.println("Anulowano dodawanie");
                    System.out.println();
            }
        }else
            System.out.println("Nie można dodać nowego studenta.");
            System.out.println("Maksymalna liczba studentów na liście (" + Student.getNumber_id() + ") została osiągnięta.");
    }

    private void renameStudent() {
        System.out.println("Podaj numer indeksu studenta:");
        int indeks = dataReader.getIn();
        studentBase.areYouSureRenameStudent(indeks);
        String string = dataReader.getInString();
        switch (string) {
            case "t":
                studentBase.renameStudent(indeks);
                break;
            case "n":
                System.out.println("Anulowano zmiany.");
                System.out.println();
        }
    }
    private void deleteStudent(){
        if (isStudentListNull()){
            System.out.println("Lista studentów jest pusta");
            System.out.println();
        }else {
            System.out.println("Podaj numer indeksu studenta: ");
            int number = dataReader.getIn();
            studentBase.areYouSureDelete(number);
            String string = dataReader.getInString();
            switch (string) {
                case "t":
                    studentBase.deleteStudent(number);
                    break;
                case "n":
                    System.out.println("Anulowano usuwanie");
                    System.out.println();
            }
        }
    }

    private void exit(){
        System.out.println("Do zobaczenia!");
        dataReader.close();
    }
    private boolean isStudentListNull(){
        return Student.getNumber_id()==0;
    }
}

