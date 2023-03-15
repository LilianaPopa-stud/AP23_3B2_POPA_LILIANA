package compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);


        List<Student> listOfStudents = new LinkedList<>(Arrays.asList(students));
        listOfStudents.add(new Student("A1"));

        // print the students sorted by name
        // Sorting: Natural order given by implementing Comparable
        Collections.sort(listOfStudents);
        System.out.println("Students sorted by name"+ listOfStudents);

        var projects = IntStream.rangeClosed(0, 3).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new);
        //create tree set of projects
        Set<Project> setOfProjects = new TreeSet<>(Arrays.asList(projects));
        setOfProjects.add(new Project("A1"));
        System.out.println("Projects sorted by name"+ setOfProjects);
    }
}
