FROM eclipse-temurin:17-jdk-jammy
ADD target/*.jar /home/app.jar
WORKDIR /home/
ENV EUREKA_PORT=8761
ENV EUREKA_HOST=localhost
ENV DB_HOST=localhost
ENV DB_PORT=3306
ENV DB_USER=root
ENV DB_PASSWORD=root
ENV DB_DRIVER=org.mariadb.jdbc.Driver
ENV DB_NAME=springdb
CMD java -jar app.jar