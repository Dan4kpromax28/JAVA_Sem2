package model;


public class Professor {
    //1.variables
    private long pId;
    private String name;
    private String surname;
    private Degree degree;

    private static long counter = 0; // ja to maino kkur tas mainas visur


    //2.get and set

    public long getpId() {
        return pId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setpId() {
        this.pId = counter;
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
//for latvian [p]{1}[p]+ or [A-ZĀĒŪĻŠŪ...]{1}[a-zāžēūī..]+
    public void setSurname(String surname) {
        if (surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            this.surname = surname;
        }
        else {
            this.surname = "None";
        }
    }

    public void setDegree(Degree degree) {

        if(degree != null){
            this.degree = degree;
        }
        else {
            this.degree = Degree.other;
        }

    }
    //3.constructor
    public Professor() {
        setpId();
        this.name = "";
        this.surname = "";
        this.degree = null;
    }

    public Professor(String name, String surname, Degree degree){
        setpId();
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }
    //4.toString function

    @Override
    public String toString() {
        return "Professor{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree=" + degree +
                '}';
    }

    //5.other function

}
