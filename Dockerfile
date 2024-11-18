FROM eclipse-temurin:latest

WORKDIR /usr/src/myserver


COPY .mvn .mvn
COPY pom.xml pom.xml
COPY mvnw mvnw

RUN echo "stacionar.dumbo 10.10.0.1" >> /etc/hosts

RUN ./mvnw dependency:resolve

COPY src src

CMD ["./mvnw", "spring-boot:run"]