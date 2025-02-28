FROM openjdk:17-jdk-alpine

COPY scicalc/target/scicalc-1.0.0.jar scicalc-1.0.0.jar

ENTRYPOINT ["java","-jar","/scicalc-1.0.0.jar"]
