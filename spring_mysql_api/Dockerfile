# Defining base docker image
FROM openjdk:17-jdk-slim
LABEL maintainer="sravani"
WORKDIR /app
COPY target/spring_mysql_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]