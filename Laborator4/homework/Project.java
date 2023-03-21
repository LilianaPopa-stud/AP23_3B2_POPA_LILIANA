package homework;

public class Project implements Comparable<Project>, Node {
    private String name;
    private int numberOfStudentsInterested;
    private Boolean isAssigned = false;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    public Boolean isAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(Boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public int getNumberOfStudentsInterested() {
        return numberOfStudentsInterested;
    }

    public void setNumberOfStudentsInterested(int numberOfStudentsInterested) {
        this.numberOfStudentsInterested = numberOfStudentsInterested;
    }
}
