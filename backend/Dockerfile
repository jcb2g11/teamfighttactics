#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests


# Use an official amazoncorretto runtime as a parent image
FROM amazoncorretto:22-alpine-jdk

MAINTAINER cedricbondoc.com

# Copy the application JAR file into the container at /app
COPY --from=build /target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
