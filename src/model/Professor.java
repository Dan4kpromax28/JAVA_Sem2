package model;


public class Professor extends Person{
    //1.variables
    private long pId;

    private Degree degree;

    private static long counter = 0; // ja to maino kkur tas mainas visur


    //2.get and set

    public long getpId() {
        return pId;
    }



    public Degree getDegree() {
        return degree;
    }

    public void setpId() {
        this.pId = counter;
        counter++;
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
        super();
        setpId();

        this.degree = Degree.other;
    }

    public Professor(String name, String surname, Degree degree){
        super(name,surname);
        setpId();
        setDegree(degree);
    }
    //4.toString function

    @Override
    public String toString() {
        return "Professor{" +
                "pId=" + pId +
                ", name='" + super.toString() +
                ", degree=" + degree +
                '}';
    }

    //5.other function

}
