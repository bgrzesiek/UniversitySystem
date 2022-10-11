package Data;


public class StudentBase {
    private static final int MAX_STUDENT = 100;

    Student[] students = new Student[MAX_STUDENT];

    public void AddStudent(Student student) {
        if (Student.getNumber_id() < MAX_STUDENT) {
            students[Student.getNumber_id()] = student;
            System.out.println("Pomyślnie dodano do bazy nowego studenta " + students[Student.getNumber_id()].getName() + " " + students[Student.getNumber_id()].getLastName());
            System.out.println();
            Student.setNumber_id(Student.getNumber_id() + 1);
            Student.setIndex_Count(Student.getIndex_Count() + 1);
        } else {
            System.out.println("Maksymalna liczba studentów została osiągnięta");
        }

    }

    public void areYouSureAddNewStudent(String name, String lastName) {
        System.out.println("Czy na pewno dodać nowego studenta: " + name + " " + lastName + " ? t/n");
    }

    public void areYouSureRenameStudent(int indeks) {
        System.out.println("Czy na pewno zmienić dane studenta " + students[getStudentTableNumber(indeks)].getName() + " "
                            + students[getStudentTableNumber(indeks)].getLastName() + " ?");
    }

    public void areYouSureDelete(int indeks) {
        if (students[getStudentTableNumber(indeks)] == null) {
            System.out.println("Brak studenta o takim numerze indeksu");
        } else if (students[getStudentTableNumber(indeks)] != null) {
            System.out.println("Czy na pewno usunąć studenta " + students[getStudentTableNumber(indeks)].getName() + " "
                    + students[getStudentTableNumber(indeks)].getLastName() + " " + "z listy? t/n");
        }
    }

    public void deleteStudent(int number) {
        System.out.println("Usunięto " + " " + students[getStudentTableNumber(number)].getName() + " "
                            + students[getStudentTableNumber(number)].getLastName() + " z listy studentów.");
        int i = getStudentTableNumber(number);
        students[getStudentTableNumber(number)] = null;
        do {
            students[i] = students[i + 1];
            i++;
        } while (students[i] != null); //Zlikwidowanie komórki null po usunieciu danego studenta poprzez przesuniecie wpisow z wyższych komórek tablicy do niższych.
        Student.setNumber_id(Student.getNumber_id() - 1);  //zminejszenie liczby studentow
    }

    public void renameStudent(int number) {

    }

    public void printAllInfo() {
        if (Student.getNumber_id() == 0) {
            System.out.println("Lista studentów jest pusta.");
            System.out.println();
        } else if (Student.getNumber_id() != 0) {
            System.out.println("Aktualnie studiuje " + Student.getNumber_id() + " " + "studentow.");
            System.out.println("Lista:");
            int i = 0;
            do {
                System.out.println(i + 1 + ". " + "nr indeksu:" + " " + students[i].getIndex() + " " + students[i].getName() + " " + students[i].getLastName());
                i++;
            }
            while (students[i] != null);
            System.out.println("Koniec listy");
            System.out.println();
        }
    }

    private int getStudentTableNumber(int indeks) {
        int i=0;
            while (students[i].getIndex() != indeks) {
                if (students[i].getName()!=null) {
                    if (students[i].getIndex() != indeks) {
                    }
                }else
                    System.out.println("Nie ma w bazie studenta z takim numerem indeksu");
                i++;
            }
        return i;
    }

}


