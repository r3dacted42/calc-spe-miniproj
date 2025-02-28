FROM openjdk:17-jdk-alpine

EXPOSE 5000

ARG JAR_FILE=scicalc/target/scicalc-1.0.0.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
