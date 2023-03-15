package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * he Network class containing a List of identifiable nodes. The class has a method to add a node to the list.
 * @author Popa Liliana
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }
    public Network() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * a method that adds a node to the list
     * @param node the node that will be added to the list
     */
    public void addNode(Node node){
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + "\n" + nodes  +
                '}';
    }


    /**
     * a method that computes the importance of a node as the number of connections it has with other nodes
     * @param node a person or a company
     * @return the importance of a node
     */
    public int computeImportance(Node node) {
        int importance = 0;
            for (Node n : nodes) {
                if (n instanceof Person) {
                    if (((Person) n).getRelationships().containsKey(node)) {
                        importance++;
                    }
                }
            }
        if (node instanceof Person)
            importance += ((Person) node).getNumberOfConnections();
        return importance;
    }

}
