# Workshop_2 (Database work)
### The program connects to the database and performs standard CRUD operations on user data (username, email, password)
# :link: Introduction
The purpose of the project is to create a program that will manage and time information about users. The program connects to the database allows you to perform operations such as: 
+ *creating a new user;* 
+ *changing the user’s data;*
+ *getting a certain user from the database;*
+ *removing the user;* 
+ *receiving and removing all users from the database;*
# :link: Introduction :wrench:
The project used technologies:
+ *a controller to connect to the database*
+ *JBCrypt library allowing user password encryption*
## :eyes: Installation
1. To install a library to connect to the database, you must add a dependency to the maven project builder pom.xml file
```Java
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.31</version>
        </dependency>
```
2. To install a library for user password encryption we can download it from http://www.mindrot.org/projects/jBCrypt/ ,
it is also available as a dependency for Maven:
```Java
        <dependency>
            <groupId>org.mindrot</groupId>
            <artifactId>jbcrypt</artifactId>
            <version>0.4</version>
        </dependency>
```
# :paperclip: Links
+ *[Java Cryptography](https://medium.com/@arie.valiant/java-cryptography-blowfish-encryption-decryption-tutorial-1db5f2cc15f1)*
+ *[JDBC Oracle](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)*
+ *[JBCrypt javadoc](https://www.javadoc.io/doc/org.mindrot/jbcrypt/0.4/org/mindrot/jbcrypt/BCrypt.html)*