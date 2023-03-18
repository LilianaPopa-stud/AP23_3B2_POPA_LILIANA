package bonus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that represents an algorithm for finding articulation points in a graph
 * @author Popa Liliana
 */
public class Algorithm {
    Network network;
    Map<Node,List<Node>> graph = new HashMap<>();
    int time = 0;
    Map<Node,Integer> discoveryTime;
    Map<Node,Integer> low;
    Map<Node,Node> parent;
    Map<Node,Boolean> isArticulationPoint;
    Map<Node,Boolean> visited;

    public Algorithm(Network network) {
        this.network = network;
    }

    /**
     * a method that computes the adjacency list of each node
     */

    public void computeAdjacencyList(){
        for (Node node1 : network.getNodes()) {
            List<Node> list = new ArrayList<>();
            for (Node node2 : network.getNodes())
                if ((node1 instanceof Person && (((Person) node1).getRelationships().containsKey(node2)))
                        || (node1 instanceof Company && node2 instanceof Person && (((Person) node2).getRelationships().containsKey(node1)))
                        || (node1 instanceof Person && node2 instanceof Person && (((Person) node2).getRelationships().containsKey(node1))))
                    list.add(node2);
               graph.put(node1,list);
           }
    }

    /**
     * a method that computes the articulation points of a graph
     * @return a list of articulation points
     */
    public List<Node> computeArticulationPoints(){
        computeAdjacencyList();
        discoveryTime = new HashMap<>();
        low = new HashMap<>();
        parent = new HashMap<>();
        isArticulationPoint = new HashMap<>();
        visited = new HashMap<>();
        for (Node node : graph.keySet()) {
            visited.put(node,false);
            isArticulationPoint.put(node,false);
        }
        for (Node node : graph.keySet()) {
            if (!visited.get(node))
                dfs(node);
        }
        List<Node> result = new ArrayList<>();
        for (Node node: graph.keySet()){
            if (isArticulationPoint.get(node))
                result.add(node);
        }
        return result;
    }

    /**
     * Depth First Search
     * @param u a node
     */
    public void dfs(Node u){
        visited.put(u,true);
        discoveryTime.put(u,time++);
        low.put(u,time++);
        int children = 0;
        for (Node v : graph.get(u)) {
            if (!visited.get(v)){
                children++;
                parent.put(v,u);
                dfs(v);
                low.put(u,Math.min(low.get(u),low.get(v)));
                if (parent.get(u) == null && children > 1)
                    isArticulationPoint.put(u,true);
                if (parent.get(u) != null && low.get(v) >= discoveryTime.get(u))
                    isArticulationPoint.put(u,true);
            }
            else if (!v.equals(parent.get(u)))
                low.put(u,Math.min(low.get(u),discoveryTime.get(v)));
        }


    }

}
