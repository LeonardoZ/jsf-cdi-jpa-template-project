# JSF CDI JPA Template Project for Servlet Containers

This is a simples template for JSF, JPA, CDI, made to be used with Tomcat. It is configured to use MySQL and HikariCP, but you can easily change to another RDBMS system, just changing the dependencies in *pom.xml* and the configs in *src/main/resources/persistence.xml*. Use as you like. 

## Technologies
- Java 8
- Tomcat 8.x+
- JSF (2.2)
- Primeface (6.0)
- Primeface Themes (1.0.10)
- OmniFace (2.2)
- CDI (1.1)
- Weld(2.2.9)
- JPA (2.1)
- Hibernate (5.2.10.Final)
- Hibernate Validator (6.0.0.Beta2)
- HikariCP (2.6.1)
- MySQL-Connector-Java (5.1.34)
- Junit (4.8.1)
- Apache Commons Lang3 (3.4)

    
## Project Structure
```
jsf-cdi-jpa-template-project
│   .gitignore
│   pom.xml
│   README.md
├───src
│   ├───main
│   │   ├───java
│   │   │   └───br
│   │   │       └───com
│   │   │           └───leonardoz
│   │   │               ├───beans
│   │   │               │       MainPageBean.java
│   │   │               ├───config
│   │   │               │       JPAFactory.java
│   │   │               │       TransactionalOperation.java
│   │   │               │       TransactionInterceptor.java
│   │   │               ├───converters
│   │   │               │       UserConverter.java
│   │   │               ├───entities
│   │   │               │       User.java
│   │   │               └───repositories
│   │   │                       UserRepository.java
│   │   ├───resources
│   │   │   │   Messages.properties
│   │   │   └───META-INF
│   │   │           persistence.xml
│   │   └───webapp
│   │       │   index.xhtml
│   │       ├───assets
│   │       │   ├───css
│   │       │   └───js
│   │       ├───META-INF
│   │       │       context.xml
│   │       └───WEB-INF
│   │           │   beans.xml
│   │           │   faces-config.xml
│   │           │   web.xml
│   │           └───templates
│   │                   default.xhtml
│   └───test
│       └───java
```

## Architecture

This project uses a basic JSF, MVC/Java like approach. It's meant to be used with Tomcat, a Servlet Container. Because of this, we need some configurations to put CDI and JPA to work more smootly. 

The basic packages that come within the project are: 

- **br/com/leonardoz/beans**: JSF Managed beans
    
- **br/com/leonardoz/config**: Transactional facilities and a CDI Entity Manager Factory
    
- **br/com/leonardoz/converters**: JSF Converters
    
- **br/com/leonardoz/entities** POJOs with JPA and Bean Validation annotations
    
- **br/com/leonardoz/repositories**: Repositories to access database using JPA

## Tests
(comming soon)
