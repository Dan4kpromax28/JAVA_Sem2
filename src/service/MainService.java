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
        Course co3 = new Course("Matematika", 2 ,pr2);

        System.out.println(co1);
        System.out.println(co2);
        System.out.println(co3);

        courseLists.add(co1);
        courseLists.add(co2);
        courseLists.add(co3);

        Student st1 = new Student();
        Student st2 = new Student("Vladislavs", "Maksimčuks");
        Student st3 = new Student("Andzejs", "Riekstins");
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);


        studentLists.add(st1);
        studentLists.add(st2);
        studentLists.add(st3);

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(5, co2, st2);
        Grade gr3 = new Grade(6, co2, st3);
        Grade gr4 = new Grade(7,co3,st2);
        Grade gr5 = new Grade(8,co3,st3);
        System.out.println(gr1);
        System.out.println(gr2);

        gradeLists.add(gr1);
        gradeLists.add(gr2);
        gradeLists.add(gr3);
        gradeLists.add(gr4);
        gradeLists.add(gr5);


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
            System.out.println(calculateAVGbyCreditPoint(st2));
            System.out.println(calculateAVG(st3));
        }catch (Exception e) {
            System.out.println(e);
        }


        try {
            System.out.println(calculateAVGCourse(co2));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(calculateNumberOfCourse(pr2));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            sortStudentsByAVG();
            for (Student TempSt : studentLists){
                System.out.println(TempSt);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(calculateAVG(studentLists.get(0)));
        } catch (Exception e) {
            System.out.println(e);
        }

//TODO CRUD funkcijas
        // TODO izprintet ari pie reizes vid.atzimes
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

    public static float calculateAVGCourse(Course course) throws Exception {
        if (course == null){
            throw new Exception("Problem with input course");
        }
        float sum = 0;
        int howMany = 0;
        for (Grade tempGr : gradeLists){
            if (tempGr.getCourse().equals(course)){
                sum = sum + tempGr.getValue();
                howMany++;
            }
        }
        if (howMany == 0) throw new Exception("there is no value of mark");
        return sum/howMany;
    }

    public static int calculateNumberOfCourse(Professor professor) throws Exception {
        if (professor == null){
            throw new Exception("there is no profesor");
        }
        int howMany = 0;
        for (Course tempC : courseLists){
            if (tempC.getProfessor().equals(professor)){
                howMany++;
            }
        }
        if (howMany == 0) throw new Exception("There is not any course that this proffesor study");
        return howMany;
    }



    public static ArrayList<Student> sortStudentsByAVG(){
        ArrayList<Student> result = new ArrayList<Student>();

        for (Student tempSt : studentLists){
            try {
                calculateAVG(tempSt);
                result.add(tempSt);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        for (int i = 0; i < result.size(); i++){
            for (int j = 0; j < result.size(); j++){
                try {
                    if(calculateAVG(result.get(i)) < calculateAVG(result.get(j))){
                        Student temp = result.get(i);
                        result.set(i,result.get(j));
                        result.set(j,temp);

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return result;
    }

    //CRUD - create - retrive - update - delite
    // create
    //TODO pielkt personas kodu
    public static void createStudent(String name, String surname) throws Exception {
        if(name == null || surname == null) throw new Exception("Problems with input argument");
        boolean isFound = false;
        for (Student tempSt : studentLists){
            if (tempSt.getName().equals(name) && tempSt.getSurname().equals(surname)){
                isFound = true;
                break; // throw new Exception(name + " " + surname + " is already used";
            }
        }
        if(!isFound) {
            Student st = new Student(name, surname);
            studentLists.add(st);
        }
    }


    //retrive by surname
    //TODO atgriezt pec personas koda
    public static Student retriveStudentBySurname(String surname) throws Exception {
        if (surname == null) throw new Exception("Problem with input argument");

        for(Student tempSt : studentLists){
            if (tempSt.getSurname().equals(surname)){
                return tempSt;
            }
        }

        throw new Exception(surname + " is not registred in system");

    }
    //TODO retrieveAllStudents - pec nepieciesamibas

    public static void updatedStudentByNameAndSurname(String name, String surname, String newSurname) throws Exception {
        if (name == null || surname == null || newSurname == null){
            throw new Exception("Problems with input arguments");
        }

        for (Student tempSt : studentLists){
            if (tempSt.getName().equals(name) && tempSt.getSurname().equals(surname)){
                if(!surname.equals(newSurname))
                    tempSt.setSurname(newSurname);
            }

        }
        throw new Exception(surname + " is not registred in system");
    }

    //delite by name and surname
    //TODO ievest personas kodu, pec kura dzest

    public static void removeByNameAndSurname(String name, String surname) throws Exception {
        if (name == null || surname == null){
            throw new Exception("Problem with input arguments");
        }
        for (Student tempSt : studentLists){
            if (tempSt.getName().equals(name) && tempSt.getSurname().equals(surname)){
                studentLists.remove(tempSt);
                return;
            }

        }
        throw new Exception("is not registred in system");
    }


}

