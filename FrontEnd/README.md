# About this Repo

A front end app created with HTML, JQuery and Quarkus as Backend. It display a basic functionality for a simple ecommerce application.

 How To
 ------------
 
 Run the app
 ```
 $ mvn -Dquarkus.profile=dev quarkus:dev
 ```
 
 Build by using mvn
 ```
 $ mvn clean package
 ```

 Docker build
 ```
 $ docker build -t ecommerce-fe .
 ```
 
 Docker run with specific environment (dev/prod)
 ```
 $ docker run -e QUARKUS_PROFILE=dev -p 8080:8080 ecommerce-fe
 ```

Libraries
------------
- Java 11
- Quarkus 2.9.1.Final
- Bootstrap 4.6.1
- JQuery 3.6.0