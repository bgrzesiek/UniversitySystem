package Data;

public class Student {
    private static int Number_id=0; //informacja o liczbie studentów
    private static int Index_Count=1; //unikatowy numer indeksu
    private String Name;
    private String LastName;
    private int Index;


    public Student(String name, String lastName, int index) {
        Name = name;
        LastName = lastName;
        Index = index;
    }

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public String getLastName() {return LastName;}

    public void setLasName(String lastName) {LastName = lastName;}

    public int getIndex() {return Index;}

    public void setIndex(int index) {this.Index = index;}

    public static int getNumber_id() {return Number_id;}

    public static void setNumber_id(int number_id) {Student.Number_id = number_id;}

    public static int getIndex_Count() {return Index_Count;}

    public static void setIndex_Count(int index_Count) {Index_Count = index_Count;}
}
