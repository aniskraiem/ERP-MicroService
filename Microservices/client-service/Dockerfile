FROM openjdk:8
ADD target/client-server.jar client-docker.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "client-docker.jar"]