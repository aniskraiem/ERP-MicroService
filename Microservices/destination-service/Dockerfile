FROM openjdk:8
ADD target/destination-server.jar destination-docker.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "destination-docker.jar"]