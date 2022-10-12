package Data;


public class StudentBase {
    private static final int MAX_STUDENT = 100;

    Student[] students = new Student[MAX_STUDENT];

    public void AddStudent(Student student) {
        students[Student.getNumber_id()] = student;
        System.out.println("Pomyślnie dodano do bazy nowego studenta " + students[Student.getNumber_id()].getName() + " " + students[Student.getNumber_id()].getLastName());
        System.out.println();
        Student.setNumber_id(Student.getNumber_id() + 1);
        Student.setIndex_Count(Student.getIndex_Count() + 1);
    }

    public void areYouSureAddNewStudent(String name, String lastName) {
        System.out.println("Czy na pewno dodać nowego studenta: " + name + " " + lastName + " ? t/n");
    }

    public void areYouSureRenameStudent(int indeks) {
        System.out.println("Czy na pewno zmienić dane studenta " + getStudentInfo(indeks) + " ? t/n");
    }

    public void areYouSureDelete(int indeks) {
        if (isStudentTableNumberNull(indeks)) {
            System.out.println("Brak studenta o takim numerze indeksu");
        } else
            System.out.println("Czy na pewno usunąć studenta " + getStudentInfo(indeks) + " " + "z listy? t/n");
    }

    public void deleteStudent(int indeks) {
        System.out.println("Usunięto " + " " + getStudentInfo(indeks) + " z listy studentów.");
        int i = getStudentTableNumber(indeks);
        students[getStudentTableNumber(indeks)] = null;
        do {
            students[i] = students[i + 1];
            i++;
        } while (students[i] != null); //Zlikwidowanie komórki null po usunieciu danego studenta poprzez przesuniecie wpisow z wyższych komórek tablicy do niższych.
        Student.setNumber_id(Student.getNumber_id() - 1);  //zminejszenie liczby studentow
    }

    public void renameStudent(int indeks) {


    }

    public void printAllInfo() {
        if (Student.getNumber_id() == 0) {
            System.out.println("Lista studentów jest pusta.");
            System.out.println();
        } else {
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

    private String getStudentInfo(int indeks){
        return students[getStudentTableNumber(indeks)].getName() + " " + students[getStudentTableNumber(indeks)].getLastName();
    }

    private int getStudentTableNumber(int indeks) {
        int i = 0;
            while (students[i]!=null && students[i].getIndex() != indeks) {
                if (students[i].getIndex() != indeks)
                    i++;
                }
        return i;
    }

    private boolean isStudentTableNumberNull(int indeks){
        return students[getStudentTableNumber(indeks)] == null;
    }

    public boolean isStudenBaseFull(){
        return Student.getNumber_id()!=MAX_STUDENT;
    }
}


