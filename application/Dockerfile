FROM openjdk:17-bullseye
RUN mkdir /app
COPY target/application-1.0-SNAPSHOT.jar /app
WORKDIR /app
CMD java -jar application-1.0-SNAPSHOT.jar
