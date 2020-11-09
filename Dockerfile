FROM openjdk:8-jdk-alpine
LABEL maintainer="eric.delaire@axa.fr"
EXPOSE 8082
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]