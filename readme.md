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

