package compulsory;

import java.util.List;

public class Student implements Comparable<Student>{

    private String name;
    List<Project> admissibleProjects;

    public Student() {
    }
    public Student(String name) {
        this.name = name;
    }
    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
