package model;

public class Course {
    private long cID;
    private String title;
    private int creditPoint;
    private Professor professor;

    private static long counter = 100000;

    // get and set functions

    public long getcID() {
        return cID;
    }

    public String getTitle() {
        return title;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setcID() {
        this.cID = counter;
        counter++;
    }

    public void setTitle(String title) {
        if (title != null && title.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēīļšāžčņ]+")){
            this.title = title;
        }else
            this.title = "none";
    }

    public void setCreditPoint(int creditPoint) {
        if(creditPoint > 0 && creditPoint <=20) {
            this.creditPoint = creditPoint;
        }else
            this.creditPoint = 1;
    }

    public void setProfessor(Professor professor) {
        if (professor != null){
            this.professor = professor;
        }else {
            this.professor = new Professor();
        }

    }

    public Course(){
        setcID();
        this.title = "nav";
        this.creditPoint = 0;
        this.professor = new Professor();
    }

    public Course(String title, int creditPoint, Professor professor){
        setcID();
        setTitle(title);
        setCreditPoint(creditPoint);
        setProfessor(professor);

    }


    @Override
    public String toString() {
        return "Course{" +
                "cID=" + cID +
                ", title='" + title + '\'' +
                ", creditPoint=" + creditPoint +
                ", professor=" + professor +
                '}';
    }

}
