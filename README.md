![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB Java | Intermediate JPA

## Introduction

We have just learned how to use JPQL and native SQL statements with Spring JPA to query a database as well as how to model object inheritance and  component objects with JPA so let's practice a bit more.

<br>

## Requirements

1. Fork this repo.
2. Clone this repo.
3. Add your instructor and the class graders as collaborators to your repository. If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
4. In the repository, create a Java project and add the code for the following prompts.

## Submission

Once you finish the assignment, submit a URL link to your repository or your pull request in the field below.

<br>

## Instructions

1. Model the relationships of a Task Management software using Spring JPA. Assume that you have the following requirements for data storage:

  - Tasks have a `title`, `dueDate` and a boolean `status`.
  - There are 2 types of tasks: `BillableTask` and `InternalTask`.
  - `BillableTask` have an additional `hourlyRate` attribute.

2. Model the relationships of a PR company using Spring JPA. Assume that you have the following requirements for data storage:

  - The database consists of `Contacts`. Each Contact has a `name`, `title` and `company`.
  - Names are their own object and have a `firstName`, `lastName`, `middleName` and `salutation`.
  - Names should be embedded within the `Contact` entity and not be stored in a separate table.

3. List 3 tasks that can be accomplished with native SQL that you cannot do with JPQL. Explain why you would choose to use native SQL over JPQL for these specific tasks.

Consultas complejas con funciones avanzadas
SQL nativo permite hacer cálculos y filtros complejos que no se pueden hacer con JPQL, 
como clasificar o agrupar datos de maneras sofisticadas. Si necesitas usar funciones especiales de la base de datos, 
SQL nativo es la opción.

Consultas entre bases de datos diferentes
SQL nativo puede acceder a varias bases de datos al mismo tiempo, lo que no se puede hacer con JPQL, 
que solo trabaja con una base de datos a la vez. Si tu consulta involucra diferentes fuentes de datos, 
SQL nativo es más adecuado.

Operaciones de administración de bases de datos
SQL nativo te permite crear, modificar o eliminar estructuras de la base de datos (como tablas e índices), 
algo que no puedes hacer con JPQL. Para cambiar la estructura de la base de datos, siempre usarás SQL nativo.

<br>

## FAQs

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">I am stuck and don't know how to solve the problem or where to start. What should I do?</summary>

  <br> <!-- ✅ -->

  If you are stuck in your code and don't know how to solve the problem or where to start, you should take a step back and try to form a clear, straight forward question about the specific issue you are facing. The process you will go through while trying to define this question, will help you narrow down the problem and come up with potential solutions.

  For example, are you facing a problem because you don't understand the concept or are you receiving an error message that you don't know how to fix? It is usually helpful to try to state the problem as clearly as possible, including any error messages you are receiving. This can help you communicate the issue to others and potentially get help from classmates or online resources.

  Once you have a clear understanding of the problem, you should be able to start working toward the solution.

  <br>

  

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">How do I create a Spring boot project?</summary>

  <br> <!-- ✅ -->

  Spring boot is a framework for creating stand-alone, production-grade applications that are easy to launch and run. The best way to create a Spring boot project is to use the Spring Initializer website. The website provides a convenient way to generate a basic project structure with all the necessary dependencies and configurations.

  - Step 1: Go to [start.spring.io](https://start.spring.io/)
  - Step 2: Choose the type of project you want to create, such as Maven or Gradle.
  - Step 3: Select the version of Spring Boot you want to use.
  - Step 4: Choose the dependencies you need for your project. Some common dependencies include web, jpa and data-jpa.
  - Step 5: Click the "Generate" button to download the project files.

  Alternatively, you can use an Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA. These IDEs have plugins for creating Spring boot projects, making it easy to set up the environment and get started with coding.

  <br>

  

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is JPA and how can I use it in Java?</summary>

  <br> <!-- ✅ -->

  JPA stands for Java Persistence API, which is a Java specification for accessing, persisting and managing data between Java objects and a relational database. JPA provides a standard interface for accessing databases, reducing the need for custom data access code and enabling efficient management of database connections.

  To use JPA in Java, you will need to include the necessary dependencies in your project, such as the Hibernate JPA implementation and create entity classes to represent your data. These entity classes will be annotated with JPA-specific annotations, such as `@Entity` and `@Id`, to indicate the mapping between the Java class and the database table.

  Here is a code snippet to show you how to create a JPA entity class in Java:

  ```java
  @Entity
  public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String position;

    // Getters and Setters for the attributes
  }
  ```

  <br>

    

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is the purpose of using the "@Entity", "@Table" and "@Column" annotations in JPA (Java Persistence API)?</summary>

  <br> <!-- ✅ -->

  The `@Entity`, `@Table` and `@Column` annotations in JPA (Java Persistence API) are used to map Java objects to relational database tables.

  `@Entity` is used to mark a class as a persistent entity. This means that instances of the class can be stored in a database.

  `@Table` is used to define the name of the database table that the entity will be mapped to.

  `@Column` is used to define the columns in the table that correspond to the attributes of the entity.

  Here is an example of how to use these annotations:

  ```java
  @Entity
  @Table(name="employee")
  public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    //getters and setters
  }
  ```

  In this example, the `Employee` class is marked as a persistent entity using the `@Entity` annotation. The name of the database table is defined using the `@Table` annotation as "employee". The `id`, `firstName` and `lastName` attributes are mapped to columns in the "employee" table using the `@Column` annotation.

  <br>

    

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is the difference between "JOINED", "TABLE_PER_CLASS" and "SINGLE_TABLE" inheritance strategies in JPA and when to use them?</summary>

  <br> <!-- ✅ -->

  The `@Inheritance` annotation in JPA can be used to specify inheritance strategy for entities in JPA. There are three strategies available in JPA: `SINGLE_TABLE`, `JOINED` and `TABLE_PER_CLASS`. The inheritance strategy is specified using the strategy attribute in the `@Inheritance` annotation.

  The inheritance strategies in JPA determine how the data is stored in the database for the entities that inherit from a parent entity.

  - **JOINED strategy**: creates separate tables for each concrete entity and a join between them is used to retrieve the data.

    ```java
    @Inheritance(strategy=InheritanceType.JOINED)
    @Entity
    public class Parent {
    // ...
    }
    ```

  - **TABLE_PER_CLASS strategy**: creates a separate table for each concrete entity and includes all the columns of the parent entity as well.

    ```java
    @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
    @Entity
    public class Parent {
    // ...
    }
    ```

  - **SINGLE_TABLE strategy**: creates a single table for all the entities in the hierarchy, including a discriminator column to distinguish between the entities.

    ```java
    @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
    @Entity
    public class Parent {
    // ...
    }
    ```

  The choice of inheritance strategy depends on the requirements of the application, such as the need for normalization, the number of columns in the table and the number of joins required to retrieve data. For example, if the entities have many columns and normalization is important, then JOINED strategy is appropriate. If there are fewer columns, the TABLE_PER_CLASS strategy may be more suitable. The SINGLE_TABLE strategy is the simplest and most compact but may result in a less flexible data model.

  <br>

    

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">How do I use "@Embedded" and "@Embeddable" annotations in Java with JPA?</summary>

  <br> <!-- ✅ -->

  The `@Embedded` and `@Embeddable` annotations in JPA are used to map an embedded field or class in a JPA entity.

  These annotations are used to store a set of related fields within another JPA entity. This allows the developer to store complex data within a single entity, as opposed to having multiple entities for different data fields.

  The `@Embeddable` annotation is used to annotate the embedded class, while the `@Embedded` annotation is used to annotate the field within the JPA entity that will store the embedded class.

  Example:

  ```java
  @Embeddable
  public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    // getters and setters
  }

  @Entity
  public class Employee {
    @Id
    private long id;
    private String name;
    @Embedded
    private Address address;
    // getters and setters
  }
  ```

  JPA will store the data in the embedded class as part of the owning entity in the database. When retrieving the entity from the database, the embedded class data will also be retrieved and stored as part of the entity.

  In conclusion, the `@Embedded` and `@Embeddable` annotations in JPA allow developers to store complex data within a single JPA entity, providing a more organized and efficient way to store and retrieve data from the database.

  <br>

    

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">I am unable to push changes to my repository. What should I do?</summary>

  <br> <!-- ✅ -->

  If you are unable to push changes to your repository, here are a few steps that you can follow:

  1. Check your internet connection: Ensure that your internet connection is stable and working.
  1. Verify your repository URL: Make sure that you are using the correct repository URL to push your changes.
  2. Check Git credentials: Ensure that your Git credentials are up-to-date and correct. You can check your credentials using the following command:

  ```bash
  git config --list
  ```

  4. Update your local repository: Before pushing changes, make sure that your local repository is up-to-date with the remote repository. You can update your local repository using the following command:

  ```bash
  git fetch origin
  ```

  5. Check for conflicts: If there are any conflicts between your local repository and the remote repository, resolve them before pushing changes.
  6. Push changes: Once you have resolved any conflicts and updated your local repository, you can try pushing changes again using the following command:

  ```bash
  git push origin <branch_name>
  ```

</details>
