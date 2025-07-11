FROM eclipse-temurin:17-jdk-jammy
ADD target/*.jar /home/app.jar
WORKDIR /home/
ENV ZIPKIN_HOST=localhost
ENV ZIPKIN_PORT=9411
CMD java -jar app.jar