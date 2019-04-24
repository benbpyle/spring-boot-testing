FROM openjdk:8-jdk-alpine
VOLUME ["/app"]

COPY target/testing-1.0.jar /app/

ARG DEPENDENCY=target/dependency

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-jar", "/app/testing-1.0.jar"]