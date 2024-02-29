# Stage 1: Build the JAR file using Maven
FROM maven:3.8.4-openjdk-17-slim AS build
LABEL maintainer="Desta <destafajri@gmail.com>"
LABEL version="1.0"
LABEL description="Desta Spring Boot application"
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY **/application.yml.example src/main/resources/application.yml
RUN mvn install

# Stage 2: Create the final Docker image
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port 8080
EXPOSE 8080