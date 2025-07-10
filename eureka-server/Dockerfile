FROM eclipse-temurin:17-jdk-jammy
ADD target/*.jar /home/app.jar
WORKDIR /home/
ENV EUREKA_PORT=8761
ENV EUREKA_HOST=localhost
CMD java -jar app.jar