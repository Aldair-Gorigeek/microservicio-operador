FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/microservicio-operador.jar microservicio-operador.jar
EXPOSE 8082
ENTRYPOINT  ["java", "-jar", "microservicio-operador.jar"]
