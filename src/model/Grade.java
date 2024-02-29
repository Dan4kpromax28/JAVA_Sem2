package model;

public class Grade {
    private long gID;

    private int value;

    private Student student;

    private Course course;

    private static long counter =  200000;

    // get and set

    public long getgID() {
        return gID;
    }

    public int getValue() {
        return value;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setgID() {
        this.gID = counter;
        counter++;
    }

    public void setValue(int value) throws Exception {
        if (value >= 0 && value <= 10){
            this.value = value;
        }
        else {
            this.value = 0;
        }
    }

    public void setStudent(Student student) {
        if (student != null){
            this.student = student;
        }else {
            this.student = new Student();
        }

    }

    public void setCourse(Course course) {
        if (course != null){
            this.course = course;
        }else{
            this.course = new Course();
        }

    }


    @Override
    public String toString() {
        return "Grade{" +
                "gID=" + gID +
                ", value=" + value +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
