FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# coursedatas/target/coursedatas-0.0.1-SNAPSHOT.jar