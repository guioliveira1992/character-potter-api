FROM openjdk:8-jdk-alpine
COPY target/personPotterApi-0.0.1-SNAPSHOT.jar personPotterApi-0.0.1-SNAPSHOT.jar
VOLUME /tmp
ENTRYPOINT ["java","-jar","/personPotterApi-0.0.1-SNAPSHOT.jar"]