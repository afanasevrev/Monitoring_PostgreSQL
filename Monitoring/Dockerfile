FROM openjdk:latest

WORKDIR /app

COPY target/Monitoring-0.0.1-SNAPSHOT.jar /app/Monitoring.jar

ENTRYPOINT ["java", "-jar", "Monitoring.jar"]
