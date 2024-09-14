FROM openjdk:11

WORKDIR /usr/src/myserver

COPY src .

RUN mv Main.java
CMD ["java", "Main"]