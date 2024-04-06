FROM maven:3.9.6-eclipse-temurin-21 as builder
WORKDIR /app
COPY pom.xml pom.xml
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=builder "/app/target/human_resources-0.1.0.jar" "app.jar"
CMD ["java", "-jar", "app.jar"]
