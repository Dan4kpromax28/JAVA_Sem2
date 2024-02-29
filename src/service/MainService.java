package service;

import model.*;

public class MainService {
    public static void main(String[] args) {
        Professor pr1 = new Professor();
        Professor pr2 = new Professor("Deniss", "Kolupajevs", Degree.mg);
        System.out.println(pr1);
        System.out.println(pr2);

        Course co1 = new Course();
        Course co2 = new Course("Ekonomika", 4, pr2);
        System.out.println(co1);
        System.out.println(co2);

        Student st1 = new Student();
        Student st2 = new Student("Vladislavs", "Maksimčuks");
        System.out.println(st1);
        System.out.println(st2);

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(5, co2, st2);
        System.out.println(gr1);
        System.out.println(gr2);

    }
}
