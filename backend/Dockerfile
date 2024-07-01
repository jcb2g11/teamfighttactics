#
# Build stage
#
FROM maven:3.9.8-amazoncorretto-8-al2023 AS build
COPY . .
RUN mvn clean package -DskipTests


# Use an official amazoncorretto runtime as a parent image
FROM amazoncorretto:22-alpine-jdk

MAINTAINER cedricbondoc.com

# Copy the application JAR file into the container at /app
COPY --from=build /target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
