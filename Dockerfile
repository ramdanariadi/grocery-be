FROM openjdk:11
RUN groupadd grocerry && useradd grocerry -g grocerry
USER grocerry:grocerry
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]