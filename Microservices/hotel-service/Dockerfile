FROM openjdk:8
ADD target/hotel-server.jar hotel-docker.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "hotel-docker.jar"]