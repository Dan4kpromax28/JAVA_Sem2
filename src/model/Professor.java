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
        if (name != null && name.matches("[A-Z]{1}[a-z]+")){
            this.name = name;
        }
        else {
            
        }

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    //3.constructor

    //4.toString function
    //5.other function

}
