FROM jelastic/maven:3.9.5-openjdk-21
ARG JAR_FILE=fooddelivery-server/target/fooddelivery-server-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
