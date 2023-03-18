package bonus;


import java.util.*;

/**
 * this class is the main class
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {



        Main main = new Main();

        // exemplu de testare scurt
        Company google = new Company("Google");
        Company apple = new Company("Apple");


        Person designer1 = new Designer("Designer1", 25, 5, new Specialty[]{Specialty.UI, Specialty.GRAPHIC_DESIGN});
        Person designer2 = new Designer("Designer2", 35, 15, new Specialty[]{Specialty.WEB_DESIGN, Specialty.UI});


        Person programmer1 = new Programmer("Programmer1", 25, new String[]{"Java", "C++"},SoftwareDevelopmentMethodology.AGILE, true);
        Person programmer2 = new Programmer("Programmer2", 35, new String[]{"C#", "Python"},SoftwareDevelopmentMethodology.KANBAN, true);


        designer1.addRelationship(google, Relationship.WORKS_FOR);
        designer2.addRelationship(apple, Relationship.WORKS_FOR);
        programmer1.addRelationship(google, Relationship.WORKS_FOR);
        programmer1.addRelationship(programmer2, Relationship.WORKS_FOR);
        programmer2.addRelationship(apple, Relationship.WORKS_FOR);
        designer2.addRelationship(programmer1, Relationship.WORKS_FOR);



        List<Node> nodes = new ArrayList<>(List.of(google,  apple, designer1, designer2, programmer1, programmer2));
        Network network2 = new Network(nodes);

        // sort the nodes by importance = number of connections they have with other nodes
        Collections.sort(network2.getNodes(), (n1, n2) -> network2.computeImportance(n2) - network2.computeImportance(n1));
        main.printNetwork(network2);
        Algorithm algorithm = new Algorithm(network2);
        algorithm.computeAdjacencyList();
        System.out.println("Articulation Points: ");
        for (Node n: algorithm.computeArticulationPoints()){
            System.out.println(n.getName());
        }
    }

    /**
     * this method prints a network
     * @param network the network that will be printed
     */
    public void printNetwork(Network network){
        System.out.println(network);
        for (Node n: network.getNodes()){
            System.out.println(n.getName()+": Importance = "+network.computeImportance(n));
        }
    }


}
