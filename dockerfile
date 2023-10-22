FROM openjdk:8
EXPOSE 8082
ADD target/CarManagement-0.0.1-SNAPSHOT.jar Car.jar
ENTRYPOINT ["java", "-jar", "Car.jar"]