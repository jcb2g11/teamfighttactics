# Use an official amazoncorretto runtime as a parent image
FROM amazoncorretto:22-alpine-jdk

MAINTAINER cedricbondoc.com

RUN ls -l ./backend/target

# Copy the application JAR file into the container at /app
COPY ./backend/target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
