package homework;

import java.util.List;

/**
 * This class represents a student.
 * author: Popa Liliana
 */
public class Student implements Comparable<Student>, Node {

    private String name;
    private Project assignedProject;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }


}
