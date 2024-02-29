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
        this.cID = cID;
        counter++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreditPoint(int creditPoint) throws Exception {
        if(creditPoint >=0) {
            this.creditPoint = creditPoint;
        }else throw new Exception("Can not be smaller than 0");
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course(){
        setcID();
        this.title = "";
        this.creditPoint = 0;
        this.professor = null;
    }

    public Course(String title, int creditPoint, Professor professor){
        setcID();
        setTitle(title);
        try {
            setCreditPoint(creditPoint);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
