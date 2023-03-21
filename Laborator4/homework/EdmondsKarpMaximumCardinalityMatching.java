package homework;

import org.jgrapht.Graph;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdmondsKarpMaximumCardinalityMatching implements Algorithm {
    private Problem problem;

    public EdmondsKarpMaximumCardinalityMatching(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public Map<Student, Project> solve() {
        Graph<Node, DefaultEdge> graph = generateGraph();
        DenseEdmondsMaximumCardinalityMatching<Node, DefaultEdge> matching = new DenseEdmondsMaximumCardinalityMatching<>(graph);
        Map<Student, Project> pair = new HashMap<>();
        for (DefaultEdge edge : matching.getMatching().getEdges()) {
            pair.put((Student) graph.getEdgeSource(edge), (Project) graph.getEdgeTarget(edge));
        }
        return pair;

    }

    public Graph<Node, DefaultEdge> generateGraph() {
        Graph<Node, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        for (Student student : problem.getStudents()) {
            graph.addVertex(student);
        }
        for (Project project : problem.getProjects()) {
            graph.addVertex(project);
        }
        for (Map.Entry<Student, List<Project>> entry : problem.getPrefMap().entrySet()) {
            for (Project project : entry.getValue()) {
                graph.addEdge(entry.getKey(), project);
            }
        }
        return graph;
    }
}
