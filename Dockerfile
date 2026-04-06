FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

# Build project
RUN ./mvnw clean install -DskipTests

# Run app
CMD ["java", "-jar", "target/JobTracker-0.0.1-SNAPSHOT.jar"]