FROM openjdk:8
EXPOSE 8089
ADD /target/api-gateway.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]