package model;

public class Student extends Person {
    private long stID;


    private static long counter = 10000;

    // get and set functions

    public long getStID() {
        return stID;
    }



    public void setStID() {
        this.stID = counter;
        counter++;
    }



    public Student(){
        super();
        setStID();

    }

    public Student(String name, String surname){
        super(name, surname);
        setStID();

    }
    // toString function


    @Override
    public String toString() {
        return "Student{" +
                "stID=" + stID +
                "," + super.toString() + '\'' +
                '}';
    }
}
