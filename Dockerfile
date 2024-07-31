FROM openjdk:17-jdk-alpine
COPY .env .env
COPY target/rrss-0.0.1-SNAPSHOT.jar mongo-app.jar
ENTRYPOINT ["java", "-jar", "mongo-app.jar"]
