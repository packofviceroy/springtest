FROM eclipse-temurin:latest

WORKDIR /usr/src/myserver


COPY .mvn .mvn
COPY pom.xml pom.xml
COPY mvnw mvnw

RUN ./mvnw dependency:resolve

COPY src src


CMD ["sleep", "999d"]
#CMD ["./mvnw", "spring-boot:run"]