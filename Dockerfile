FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/studentManagementSystem-0.0.1-SNAPSHOT.war studentManagementSystem.war
EXPOSE 9696
ENTRYPOINT ["java","-war","studentManagementSystem.war"]
