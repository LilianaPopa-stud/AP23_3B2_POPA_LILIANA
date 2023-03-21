package homework;

import java.util.*;

/**
 * This class represents a greedy algorithm.
 * author: Popa Liliana
 */
public class GreedyAlgorithm implements Algorithm {
    private Problem problem;

    /**
     * This method solves the problem using greedy algorithm.
     *
     * @return a map containing the student-project pairs.
     */
    @Override
    public Map<Student, Project> solve() {
        // sort students in ascending order by number of admissible projects
        List<Student> students = new ArrayList<>(problem.getPrefMap().keySet().stream().toList());
        students.sort((s1, s2) -> {
            int nr1 = problem.getPrefMap().get(s1).size();
            int nr2 = problem.getPrefMap().get(s2).size();
            return Integer.compare(nr1, nr2);
        });

        List<Project> projects = new ArrayList<>(problem.getProjects());
        for (Project project : projects) {
            int nrOfStudentsIntrested = 0;
            for (Student student : students) {
                if (problem.getPrefMap().get(student).contains(project)) {
                    nrOfStudentsIntrested++;
                }
                project.setNumberOfStudentsInterested(nrOfStudentsIntrested);
            }
        }
        // Sort the subset of admissible projects in ascending order of the number of interested students.
        for (Student student : students) {
            List<Project> admissibleProjects = problem.getPrefMap().get(student);
            admissibleProjects.sort((p1, p2) -> {
                int nr1 = p1.getNumberOfStudentsInterested();
                int nr2 = p2.getNumberOfStudentsInterested();
                return Integer.compare(nr1, nr2);
            });
            for (Project project : admissibleProjects) {
                if (Boolean.FALSE.equals(project.isAssigned())) {
                    project.setIsAssigned(true);
                    student.setAssignedProject(project);
                    break;
                }
            }
        }
        Map<Student, Project> result = new HashMap<>();
        for (Student student : students) {
            result.put(student, student.getAssignedProject());
        }
        for (Student student : result.keySet())
            if (result.get(student) != null)
                System.out.println("Student: " + student.getName() + ", Assigned project - \"" + result.get(student).getName() + "\"");
        return result;
    }

    public GreedyAlgorithm(Problem problem) {
        this.problem = problem;

    }


}

