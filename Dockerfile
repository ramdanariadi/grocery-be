FROM maven:3.8.6-openjdk-11-slim as build
WORKDIR /home/app
COPY src ./src
COPY pom.xml ./
RUN mvn clean package -DskipTests=true

FROM openjdk:11
RUN groupadd grocery && useradd grocery -g grocery
USER grocery:grocery
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]