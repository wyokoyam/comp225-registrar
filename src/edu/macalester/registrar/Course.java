package edu.macalester.registrar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Course {
    private String catalogNumber, title;
    private Set<Student> students = new HashSet<Student>();
    private int enrollmentLimit = 1;
    private Set<Student> waitList = new HashSet<Student>();


    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //todo unmodifiable? unable to drop?
    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    //todo unmodifiable? unable to pull from wait list?
    public Set<Student> getWaitList() { return Collections.unmodifiableSet(students);}

    void enroll(Student student) {

        if(getStudents().size() < enrollmentLimit){
            students.add(student);
        }
        else {
            waitList.add(student);
            //todo throw exception? notify student?
        }
    }

    public int getEnrollmentLimit() {return enrollmentLimit;}
}
