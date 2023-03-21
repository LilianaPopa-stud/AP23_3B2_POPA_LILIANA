package homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        List<Student> listOfStudents = new LinkedList<>(Arrays.asList(students));


        // print the students sorted by name
        // Sorting: Natural order given by implementing Comparable
        Collections.sort(listOfStudents);
        System.out.println("Students sorted by name"+ listOfStudents);

        var projects = IntStream.rangeClosed(0, 3).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new);
        //create tree set of projects
        Set<Project> setOfProjects = new TreeSet<>(Arrays.asList(projects));
        setOfProjects.add(new Project("A1"));
        System.out.println("Projects sorted by name"+ setOfProjects);

        Problem problem = new Problem();
        problem.addPref(students[0], List.of(projects[0], projects[1], projects[2]));
        problem.addPref(students[1], List.of(projects[0], projects[1]));
        problem.addPref(students[2], List.of(projects[0]));
        Map<Student, List<Project>> map = problem.getPrefMap();

        double avgNumberOfPreferences = map.values().stream().mapToInt(List::size).average().orElse(0);

        List<Student> studentsWithFewerPreferences = map.entrySet().stream()
                .filter(entry -> entry.getValue().size() < avgNumberOfPreferences)
                .map(Map.Entry::getKey).toList();

        System.out.println("Students with fewer preferences than the average: " + studentsWithFewerPreferences);
        
        Main main = new Main();
        List<Student> randomStudents = main.generateRandomFakeStudents(10);
        List<Project> randomProjects = main.generateRandomFakeProjects(30);
        System.out.println("Random students: " + randomStudents);
        System.out.println("Random projects: " + randomProjects);

        // use the faker library to generate random students and projects and add them to the problem using streams
        Random random = new Random();
        Problem problem2 = new Problem();
        problem2.setStudents(randomStudents);
        problem2.setProjects(randomProjects);
        for (int i = 0; i < 10; i++) {

            List<Project> subListOfProjects = randomProjects.subList(0, random.nextInt(29) + 1);
            problem2.addPref(randomStudents.get(i), subListOfProjects);
        }
        System.out.println("Problem: ");
        for (Map.Entry<Student, List<Project>> entry : problem2.getPrefMap().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().size());
        }
        Algorithm greedyAlgorithm = new GreedyAlgorithm(problem2);
        greedyAlgorithm.solve();
        Algorithm edmondsKarpMaximumCardinalityMatching = new EdmondsKarpMaximumCardinalityMatching(problem2);
        edmondsKarpMaximumCardinalityMatching.solve();
        System.out.println(edmondsKarpMaximumCardinalityMatching.solve());

        Problem bigProblem = main.generateRandomProblem(2000, 2000);
        Algorithm edmondsKarpMaximumCardinalityMatchingBigProblem = new EdmondsKarpMaximumCardinalityMatching(bigProblem);
        System.out.println(edmondsKarpMaximumCardinalityMatchingBigProblem.solve());


    }

    public Problem generateRandomProblem(int numberOfStudents, int numberOfProjects) {
        Problem problem = new Problem();
        problem.setStudents(generateRandomFakeStudents(numberOfStudents));
        problem.setProjects(generateRandomFakeProjects(numberOfProjects));
        Random random = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
            List<Project> subListOfProjects = problem.getProjects().subList(0, random.nextInt(numberOfProjects - 1) + 1);
            problem.addPref(problem.getStudents().get(i), subListOfProjects);
        }
        return problem;
    }

    public List<Student> generateRandomFakeStudents(int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student(faker.name().fullName()));
        }
        return students;
    }

    public List<Project> generateRandomFakeProjects(int numberOfProjects) {
        List<Project> projects = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numberOfProjects; i++) {
            projects.add(new Project(faker.name().lastName()));
        }
        return projects;
    }
}
