#docker build -t agh/demo-jenkins-ci:0.0.1-SNAPSHOT .
#docker run --rm -d -p 9090:9090 --network="host" agh/demo-jenkins-ci:0.0.1-SNAPSHOT
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]