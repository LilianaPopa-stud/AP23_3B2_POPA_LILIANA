# Laborator 8

### Homework
- [x] Create an object-oriented model of the data managed by the Java application.
- [x] Implement all the DAO classes.
- [ ] Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
- [ ] Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)]

Laborator 9
### Compulsory
- [x] Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation). 
- [x] Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- [x] Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
- [x] Create a singleton responsible with the management of an EntityManagerFactory object.
- [x] Define repository clases for your entities (at least one). They must contain the following methods:
create - receives an entity and saves it into the database;
findById - returns an entity based on its primary key;
findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- [x] Test your application.
