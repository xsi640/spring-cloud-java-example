FROM openjdk:8-jdk-alpine
ADD ["sentinel-dashboard-1.6.2.jar", "/app/app.jar"]
WORKDIR /app
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar app.jar
EXPOSE 8080