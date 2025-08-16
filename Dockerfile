# Dockerfile
FROM openjdk:17
WORKDIR /app
COPY . /app
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/myapp-0.0.1-SNAPSHOT.jar"]
