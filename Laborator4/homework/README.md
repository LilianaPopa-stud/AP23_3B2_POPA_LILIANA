Homework (2p)

- [x] Create a class that describes the problem.
- [x] Using Java Stream API, write a query that display all the students that have a number of preferences lower than
  the average number of preferences.
- [x] Use a third-party library in order to generate random fake names for students and projects.
- [x] Create a Greedy algorithm in order to solve the problem.

La algoritmul Greedy am ales sa sortez in ordine crescatoare studentii si proiectele dupa numarul de
preferinte, apoi sa parcurg studentii in ordine, si sa-i aloc studentului
primul proiect din lista de preferinte care nu este deja asignat altui student. Am sortat proiectele crescator in functie de numarul de studenti interesati pentru ca astfel
sansele de a gasi un proiect pentru un student cu mai putine preferinte  sunt mai mari.

Bonus (2p)

- [x] Implement an algorithm that determines the maximum cardinality matching ... or you may use the following libraries
  in order to solve it:
  JGraphT Graph4J
- [x] Create a random problem generator (with thousands of objects) and test the performance of the implementation (try
  both libraries). Compare the results with the ones obtained by the greedy algorithm.
- [ ] Determine a minimum cardinality set formed of students and projects with the property that each admissible pair (
  student-project) contains at least an element of this set.
- [ ] Determine a maximum cardinality set of students and projects such that there is no admissible pair (
  student-project) formed with elements of this set. Resources

La Bonus am folosit doar JGraphT. In clasa EdmondsKarpMaximumCardinalityMatching am o metoda care genereaza un graph in baza unei probleme, iar in metoda solve()  
am utilizat DenseEdmondsMaximumCardinalityMatching din JGraphT pentru a determina matching-ul maxim.
In clasa Main am generat o problema random cu 2000 de studenti si 2000 de proiecte, apoi am testat
algoritmul pe aceasta problema. Am testat si algoritmul Greedy, si am comparat timpul de executie al celor doua algoritmi. Timpul pentru algoritmul Greedy este semnificativ mai mic.
![timp_executie](https://i.ibb.co/KXg9HBJ/Screenshot-2023-03-24-at-14-47-33.png)