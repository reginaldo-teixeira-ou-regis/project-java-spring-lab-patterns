# Exploring Practical Project Patterns with Java

<hr>

To start this project, was used the [spring initializr](https://start.spring.io/) was used using the options:
* Project: Maven Project;
* Language: Java 11;
* Spring Boot: 2.6.0;
* Dependencies: Spring Web, Spring Data JPA, H2 Database e OpenFeign.

Manually added dependency at the `pom.xml`: [Springdoc OpenAPI UI v1.5.12](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui/1.5.12).

<hr>

The relationship between Projects Patterns with Java and the spring framework can be seen in:
* Annotations *@Bean* and *@Autowired* as creational pattern **Singleton**;
* Annotations *@Service* and *@Repository* as behavioral pattern **Strategy**;
* Annotation *@RestController* as structural pattern **Facade**.

<hr>

Swagger: ``http://127.0.0.1:8080/swagger-ui.html``

Minimun Payload in POST:
```JSON
{
  "name": "string",
  "ean": "string",
  "unity": "string",
  "distributors": [
    {
      "name": "string",
      "comments": "string",
      "address": {
        "cep": "stringCepWith8Numbers"
      },
	  "addressNumber": 1
    }
  ]
}
```
Example:
```JSON
{
  "name": "Camiseta",
  "ean": "25411",
  "unity": "peça",
  "distributor": [
    {
      "name": "Brechó's Santa Cruz",
      "comments": "No salão da Igreja Santa Cruz",
      "address": {
        "cep": "86705610"
      },
      "addressNumber": 145
    }
  ]
}
```

<hr>

Link of API used in the application: - [ViaCEP](https://viacep.com.br);