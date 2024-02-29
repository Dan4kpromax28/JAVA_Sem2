package model;

public class Student {
    private long stID;

    private String name;

    private String surname;

    private static long counter = 10000;

    // get and set functions

    public long getStID() {
        return stID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setStID() {
        this.stID = counter;
        counter++;
    }

    public void setName(String name) {
        if (name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            this.name = name;
        }
        else {
            this.name = "None";
        }
    }

    public void setSurname(String surname) {
        if (surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            this.surname = surname;
        }
        else {
            this.surname = "None";
        }
    }

    public Student(){
        setStID();
        this.name = "Aleksandrs";
        this.surname = "Rjabovs";
    }

    public Student(String name, String surname){
        setStID();
        setName(name);
        setSurname(surname);
    }
    // toString function


    @Override
    public String toString() {
        return "Student{" +
                "stID=" + stID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
