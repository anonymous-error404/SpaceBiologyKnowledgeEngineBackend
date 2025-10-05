# Use official Eclipse Temurin 23 JDK runtime
FROM openjdk:23-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built Spring Boot jar into the container
COPY target/SpaceBiologyKnowledgeEngineBackend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot jar
ENTRYPOINT ["java", "-jar", "app.jar"]
