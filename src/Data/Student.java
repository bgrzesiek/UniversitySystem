package Data;

public class Student {
    public static int NUMBER_ID=0; //informacja o liczbie studentów
    public static int INDEX_COUNT=1; //unikatowy numer indeksu studenta
    private String Name;
    private String LastName;
    private int Index;


    public Student(String name, String lastName, int index) {
        Name = name;
        LastName = lastName;
        Index = index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        this.Index = index;
    }
    public static int getNumberId() {
        return NUMBER_ID;
    }
}
