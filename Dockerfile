FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/microservicio-operador.jar microservicio-operador.jar
EXPOSE ${PORT}
CMD  ["java", "-jar", "microservicio-operador.jar", "--server.port=${PORT}"]
