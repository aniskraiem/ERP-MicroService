FROM openjdk:8
ADD target/reservation-server.jar reservation-docker.jar
EXPOSE 8760
ENTRYPOINT ["java", "-jar", "reservation-docker.jar"]