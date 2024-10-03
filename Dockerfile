FROM jelastic/maven:3.8.6-openjdk-19
ARG JAR_FILE=fooddelivery-server/target/fooddelivery-server-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
