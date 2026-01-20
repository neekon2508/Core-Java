package Chap5_Inheritance.abstractClasses;

public class Student extends Person{
    private String major;
    /**
     * @param name
     * @param major
     */
    public Student(String name, String major) {
        super(name);
        this.major = major;
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
        return "a student majoring is "+major;
    }

}
