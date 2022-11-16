```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.5'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'com.tobias'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

- ``spring-boot-starter-data-mongodb``: Spring Boot starter for MongoDB
- ``spring-boot-starter-web``: Spring Boot starter for web applications
- ``lombok``: Lombok is a Java library that automatically plugs into your editor and build tools, spicing up your java.
- ``spring-boot-devtools``: Spring Boot DevTools adds development-time features to your application.

<br/>

----

<br/>


```java
package com.tobias.springdatamongodb.practice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryItem")
public class GroceryItem {

    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

    public GroceryItem(String id, String name, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

}
```

- ``@Document``: This annotation is used to specify the collection name to which the document will be mapped.
- ``@Id``: This annotation is used to specify the primary key field for the document.
- ``GroceryItem``: This is a POJO class that will be mapped to a MongoDB document.

<br/>

----

<br/>

```java
package com.tobias.springdatamongodb.practice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{ 'name' : ?0 }")
    GroceryItem findByName(String name);

    @Query(value = "{ 'category' : ?0 }", fields = "{ 'name' : 1, 'quantity' : 1 }")
    List<GroceryItem> findAll(String category);

    public long count();

}
```

- ``MongoRepository``: This interface provides CRUD operations for the specified entity.
- ``ItemRepository``: This is a repository interface that extends MongoRepository.
- ``@Query``: This annotation is used to specify the query to be executed.
- ``findByName``: This method will find a document by its name.
- ``findAll``: This method will find all documents by its category.
- ``count``: This method will count all documents.
- ``GroceryItem``: This is a POJO class that will be mapped to a MongoDB document.

<br/>

----

<br/>

```properties
spring.data.mongodb.uri=mongodb+srv://test:93414223@cluster0.3f1nxzq.mongodb.net/?retryWrites=true&w=majority
spring.data.mongodb.database=mygrocerylist
```

- ``spring.data.mongodb.uri``: This property is used to specify the MongoDB connection URI.
- ``spring.data.mongodb.database``: This property is used to specify the MongoDB database name.

<br/>

----

<br/>

```java
package com.tobias.springdatamongodb;

import com.tobias.springdatamongodb.practice.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class SpringDataMongoDbApplication {

    private final ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongoDbApplication.class, args);
    }

}
```

- ``@SpringBootApplication``: This annotation is used to enable auto-configuration of the Spring application.
- ``@EnableMongoRepositories``: This annotation is used to enable MongoDB repositories.
- ``@RequiredArgsConstructor``: This annotation is used to generate a constructor with required arguments.

<br/>

----

<br/>

