Bonus:
=====
- [X] Implement an efficient agorithm to determine if there are nodes in this networks which, if they are removed, disconnect the network.
- [ ] Identify the blocks of the network, that is subgraphs that are maximally 2-connected.
- [ ] Create JUnit tests for your algorithms.

Clasa Algorithm contine o metoda care construieste lista de adiacenta a fiecarui nod din Network. Metoda returneaza un HashMap care contine ca cheie nodul si ca valoare lista de adiacenta a nodului respectiv.

Metoda computeArticulationPoints() gaseste punctele de articulatie dintr-un graf si le returneaza sub forma unei liste de noduri.
Algoritmul initializeaza mai intai map-urile 'discoveryTime', 'low', 'parent' si 'isArticulationPoint' cu valorile implicite. Apoi, parcuge fiecare nod din graf si apeleaza metoda 'dfs' pentru fiecare nod nevizitat. 
Metoda 'dfs' parcurge graful in adancime, marcand nodurile vizitate si actualizand valorile map-urilor 'discoveryTime', 'low', 'parent' si 'isArticulationPoint'.

Acesta este exemplul de graf pe care l-am folosit pentru testare:

![Graful](https://i.ibb.co/RjXSGym/Screenshot-2023-03-19-at-01-37-41.png)

Iar acesta este output-ul:

![Output-ul](https://i.ibb.co/9gy4jvT/Screenshot-2023-03-19-at-01-02-27.png)