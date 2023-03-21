package homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private Map<Student, List<Project>> prefMap = new HashMap<>();
    private List<Student> students;
    private List<Project> projects;
    private int nrOfStudents;
    private int nrOfProjects;

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public int getNrOfStudents() {
        return students.size();
    }

    public int getNrOfProjects() {
        return projects.size();
    }

    public void setPrefMap(Map<Student, List<Project>> prefMap) {
        this.prefMap = prefMap;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addPref(Student student, List<Project> projects) {
        prefMap.put(student, projects);
    }

}
