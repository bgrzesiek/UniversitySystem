package Data;


public class StudentBase {
private static final int MAX_STUDENT = 100;

    Student[] students = new Student[MAX_STUDENT];

    public void AddStudent(Student student) {
            if (Student.getNumber_id()<MAX_STUDENT){
                students[Student.getNumber_id()] = student;
                System.out.println("Pomyślnie dodano do bazy nowego studenta " + students[Student.getNumber_id()].getName() + " " + students[Student.getNumber_id()].getLastName());
                System.out.println();
                Student.setNumber_id(Student.getNumber_id()+1);
                Student.setIndex_Count(Student.getIndex_Count()+1);
            }else {
                System.out.println("Maksymalna liczba studentów została osiągnięta");
            }
    }

    public void areYouSureDelete(int number) {
            if (students[number - 1] == null) {
                System.out.println("Brak takiego studenta na liście.");
            } else if (students[number - 1] != null) {
                System.out.println("Czy na pewno usunąć studenta " + students[number - 1].getName() + " "
                        + students[number - 1].getLastName() + " " + "z listy? t/n");
            }
    }
    public void deleteStudent(int number) {
            System.out.println("Usunięto " + " " + students[number - 1].getName() + " " + students[number - 1].getLastName() + " z listy studentów.");
            students[number - 1] = null;
            int i = number - 1;
            //zlikwidowanie komorki null po usunieciu danego studenta poprzez przesuniecie wpisow w wyzszych komorkach "w dol"
                do {
                    students[i] = students[i + 1];
                    i++;
                } while (students[i] != null);
            Student.setNumber_id(Student.getNumber_id()-1);  //zminejszenie liczby studentow
    }

    public void printAllInfo () {
            if (Student.getNumber_id()==0){
                System.out.println("Lista studentów jest pusta.");
                System.out.println();
            }else if (Student.getNumber_id() !=0) {
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
}


