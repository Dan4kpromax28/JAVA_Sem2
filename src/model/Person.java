package model;

public class Person {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        if (name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            this.name = name;
        }
        else {
            this.name = "None";
        }

    }
    //for latvian [p]{1}[p]+ or [A-ZĀĒŪĻŠŪ...]{1}[a-zāžēūī..]+
    public void setSurname(String surname) {
        if (surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            this.surname = surname;
        }
        else {
            this.surname = "None";
        }
    }

    public Person(){
        setName("Janis");
        setSurname("Berzins");
    }

    public Person(String name, String surname){
        setName(name);
        setSurname(surname);
    }

    @Override
    public String toString() {
        return
                "{ name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
