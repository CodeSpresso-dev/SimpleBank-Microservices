# <b>Simple Bank – Microservices Architecture</b>
Simple Bank is a microservices-based application that consists of the following modules:

## 📌 Modules
Simple Bank includes three modules that named
1. <b>Accounts</b> – Manages user accounts.
2. <b>Cards</b> – Handles credit and debit card operations.
3. <b>Loans</b> – Manages loan-related transactions.

## 📌 Features & Specifications
✅ <b>Global Exception Handling</b> – Centralized error handling using a Global Exception Handler.
✅ <b>REST API Validation</b> – Implements Spring Boot Validation for request validation.

## 🚀 How to Dockerized the Microservices
This project uses Google Jib to containerize microservices without needing Dockerfiles.
### 🔧 Configuration
Add the following Maven Jib plugin configuration to your `pom.xml`:
~~~
 <plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>3.4.0</version>
                <configuration>
                    <from>
                        <image>eclipse-temurin:21-jre</image>  <!-- ✅ Java 21 Base Image -->
                    </from>
                    <to>
                        <image>codespresso/${project.artifactId}</image>
                    </to>
                </configuration>
            </plugin>
~~~
### 📦 Building & Running the Docker Image
Ensure Docker is running on your system, then execute the following command to build the image and load it into your local Docker repository:
~~~
mvn compile jib:dockerBuild
~~~