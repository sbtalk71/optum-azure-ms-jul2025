FROM eclipse-temurin:17-jdk-jammy
ADD target/*.jar /home/app.jar
WORKDIR /home/
ENV DB_HOST=localhost
ENV DB_PORT=3306
ENV DB_USER=root
ENV DB_PASSWORD=root
ENV DB_DRIVER=org.mariadb.jdbc.Driver
ENV DB_NAME=springdb
ENV ZIPKIN_HOST=localhost
ENV ZIPKIN_PORT=9411
CMD java -jar app.jar