# Stage 1: Build stage
FROM maven:3.9.8-amazoncorretto-17 as builder

COPY ./src /usr/src/app/src
COPY ./pom.xml /usr/src/app/pom.xml

RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Stage 2: Production stage
FROM amazoncorretto:22-alpine-jdk

COPY --from=builder /usr/src/app/target/*.jar /usr/app/app.jar

CMD ["java", "-jar", "/usr/app/app.jar"]