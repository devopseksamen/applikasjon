FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/pgr301-0.0.1-SNAPSHOT.jar pgr301.jar
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
