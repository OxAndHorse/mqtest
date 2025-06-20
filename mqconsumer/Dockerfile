FROM openjdk:8-jre-slim

WORKDIR /app
COPY mq-consumer-1.0.0.jar app.jar
RUN chmod +x app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
