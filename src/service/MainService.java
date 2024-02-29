package service;

import model.*;

import java.util.ArrayList;

public class MainService {
    private static ArrayList<Professor> profLists = new ArrayList<Professor>();
    private static ArrayList<Course> courseLists = new ArrayList<Course>();
    private static ArrayList<Student> studentLists = new ArrayList<Student>();
    private static ArrayList<Grade> gradeLists = new ArrayList<Grade>();

    public static void main(String[] args) {
        Professor pr1 = new Professor();
        Professor pr2 = new Professor("Deniss", "Kolupajevs", Degree.mg);
        System.out.println(pr1);
        System.out.println(pr2);

        profLists.add(pr1);
        profLists.add(pr2);

        Course co1 = new Course();
        Course co2 = new Course("Ekonomika", 4, pr2);
        System.out.println(co1);
        System.out.println(co2);

        courseLists.add(co1);
        courseLists.add(co2);

        Student st1 = new Student();
        Student st2 = new Student("Vladislavs", "Maksimčuks");
        System.out.println(st1);
        System.out.println(st2);

        studentLists.add(st1);
        studentLists.add(st2);

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(5, co2, st2);
        System.out.println(gr1);
        System.out.println(gr2);

        gradeLists.add(gr1);
        gradeLists.add(gr2);

        for (Professor prof : profLists){
            System.out.println(prof);
        }

        for (Course cour : courseLists){
            System.out.println(cour);
        }

        for (Student stud : studentLists){
            System.out.println(stud);
        }

        for (Grade grad : gradeLists){
            System.out.println(grad);
        }



        try {
            for (Student tempSt : studentLists) {
                System.out.println(calculateAVG(tempSt));
                System.out.println(calculateAVGbyCreditPoint(tempSt));
            }
        }catch (Exception e) {
            System.out.println(e);;
        }


        //TODO

    }

    public static float calculateAVG(Student student) throws Exception {
        if (student != null){
            float sum = 0;
            int howMany = 0;
            for (Grade tempGr : gradeLists){
                if (tempGr.getStudent().equals(student)){
                    sum = sum + tempGr.getValue();
                    howMany++;
                }

            }
            return sum/howMany;
        }else {
            throw new Exception("Problem with input student");
        }

    }

    public static float calculateAVGbyCreditPoint(Student student) throws Exception {
        if (student == null){
            throw new Exception("Problem with input student");

        }
        float sum = 0;
        int howMany = 0;
        for (Grade tempGr : gradeLists){
            if (tempGr.getStudent().equals(student)){
                sum = sum + tempGr.getValue()*tempGr.getCourse().getCreditPoint();
                howMany = howMany + tempGr.getCourse().getCreditPoint();
            }

        }
        if (howMany == 0) throw new Exception("There are no course");

        return sum/howMany;
    }




    


}
