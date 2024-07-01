# Use an official OpenJDK runtime as a parent image
FROM openjdk:amazoncorretto-22-alpine-jdk

MAINTAINER cedricbondoc.com

# Copy the application JAR file into the container at /app
COPY target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
