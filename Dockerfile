# Stage 1: Build the JAR file using Maven
FROM maven:4.0.0-openjdk-21-slim AS build
LABEL maintainer="Desta <destafajri@gmail.com>"
LABEL version="1.0"
LABEL description="Desta Spring Boot application"
WORKDIR /app
COPY . .
COPY **/application.yml.example core-module/src/main/resources/application.yml
RUN make build

# Stage 2: Create the final Docker image
FROM openjdk:21-jdk-alpine
COPY --from=build /app/core-module/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port 8080
EXPOSE 8080