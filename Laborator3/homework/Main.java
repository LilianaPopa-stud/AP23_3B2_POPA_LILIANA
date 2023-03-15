package homework;

import java.util.*;

/**
 * this class is the main class
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {



        Main main = new Main();
        Network network=new Network();
        network = main.generateInstance();
        Collections.sort(network.getNodes(), Comparator.comparingInt(network::computeImportance));

        // exemplu de testare scurt
        Company google = new Company("Google");
        Company microsoft = new Company("Microsoft");
        Company apple = new Company("Apple");
        Company facebook = new Company("Facebook");
        Company amazon = new Company("Amazon");

        Designer designer1 = new Designer("Designer1", 25, 5, new Specialty[]{Specialty.UI, Specialty.GRAPHIC_DESIGN});
        Designer designer2 = new Designer("Designer2", 30, 10, new Specialty[]{Specialty.UI, Specialty.FRONTED});
        Designer designer3 = new Designer("Designer3", 35, 15, new Specialty[]{Specialty.WEB_DESIGN, Specialty.UI});
        Designer designer4 = new Designer("Designer4", 40, 20, new Specialty[]{Specialty.GRAPHIC_DESIGN, Specialty.FRONTED});

        Programmer programmer1 = new Programmer("Programmer1", 25, new String[]{"Java", "C++"},SoftwareDevelopmentMethodology.AGILE, true);
        Programmer programmer2 = new Programmer("Programmer2", 30, new String[]{"C++", "C#"},SoftwareDevelopmentMethodology.SCRUM, false);
        Programmer programmer3 = new Programmer("Programmer3", 35, new String[]{"C#", "Python"},SoftwareDevelopmentMethodology.KANBAN, true);
        Programmer programmer4 = new Programmer("Programmer4", 40, new String[]{"Python", "JavaScript"},SoftwareDevelopmentMethodology.WATERFALL, false);


        designer1.addRelationship(google, Relationship.WORKS_FOR);
        designer2.addRelationship(microsoft, Relationship.WORKS_FOR);
        designer3.addRelationship(apple, Relationship.WORKS_FOR);
        designer4.addRelationship(facebook, Relationship.WORKS_FOR);
        programmer1.addRelationship(google, Relationship.WORKS_FOR);
        programmer2.addRelationship(microsoft, Relationship.WORKS_FOR);
        programmer3.addRelationship(apple, Relationship.WORKS_FOR);
        programmer4.addRelationship(facebook, Relationship.WORKS_FOR);
        programmer2.addRelationship(designer1, Relationship.WORKS_WITH);
        programmer3.addRelationship(designer2, Relationship.WORKS_WITH);
        programmer2.addRelationship(designer3, Relationship.SUBORDINATE_OF);
        programmer2.addRelationship(designer4, Relationship.COLLEAGUE_OF);
        designer3.addRelationship(facebook, Relationship.WORKS_FOR);

        List<Node> nodes = new ArrayList<>(List.of(google, microsoft, apple, facebook, amazon, designer1, designer2, designer3, designer4, programmer1, programmer2, programmer3, programmer4));
        Network network2 = new Network(nodes);

        // sort the nodes by importance = number of connections they have with other nodes
        Collections.sort(network2.getNodes(), (n1, n2) -> network2.computeImportance(n2) - network2.computeImportance(n1));
        main.printNetwork(network2);


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

    /**
     * this method generates a network with random companies and employees and relationships between them
     * @return a network
     */
    public Network generateInstance() {

        int nrOfCompanies = 10;
        int nrOfEmployees = 10;
        List<Node> nodes = new java.util.ArrayList<>(List.of());

        // generate random companies
        for (int i = 0; i < nrOfCompanies; i++) {
            Company company = new Company("Company" + i, nrOfEmployees++);
            nodes.add(company);
        }
        Random random = new Random();
        Specialty[] specialties = Specialty.values();
        Specialty[] randomSpecialties = new Specialty[3];


        // generate random designers and add relationships
        for (int i = 0; i < nrOfEmployees/2; i++) {
            for (int j = 0; j < 3; j++)
                randomSpecialties[j] = specialties[random.nextInt(specialties.length)];
            int age = random.nextInt(40)+20;
            Designer designer = new Designer("Designer" + i, age, random.nextInt(10), randomSpecialties);
            nodes.add(designer);
            for (Node n: nodes)
                if (n instanceof Company)
                    designer.addRelationship(n, Relationship.WORKS_FOR);

        }

        // generate random programmers and add relationships
        SoftwareDevelopmentMethodology[] methodologies = SoftwareDevelopmentMethodology.values();
        String[] programmingLanguages = {"Java", "C++", "C#", "Python", "JavaScript", "PHP", "Ruby", "Go", "Swift", "Kotlin"};
        String[] randomProgrammingLanguages = new String[3];
        Boolean[] isAvailable = {true, false};

        for (int i = nrOfEmployees/2; i < nrOfEmployees; i++) {

            SoftwareDevelopmentMethodology methodology = methodologies[random.nextInt(methodologies.length)];
            int age = random.nextInt(40)+20;
            for(int j=0; j<3; j++)
                randomProgrammingLanguages[j] = programmingLanguages[random.nextInt(programmingLanguages.length)];
            Programmer programmer = new Programmer("Programmer" + i, age,randomProgrammingLanguages,methodology,isAvailable[random.nextInt(isAvailable.length)]);
            nodes.add(programmer);

            for (Node n: nodes)
                if (n instanceof Company)
                    programmer.addRelationship(n, Relationship.WORKS_FOR);
                else
                    if (n instanceof Designer)
                        programmer.addRelationship(n, Relationship.COLLEAGUE_OF);
        }

        return new Network(nodes);
    }

}
