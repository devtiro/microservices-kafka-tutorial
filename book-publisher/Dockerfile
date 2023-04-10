FROM maven:3.8-openjdk-17 as builder

COPY src /usr/app/src
COPY pom.xml /usr/app

RUN mvn -f /usr/app/pom.xml clean package

FROM openjdk:17-alpine

COPY --from=builder /usr/app/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]