FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -Dmaven.test.failure.ignore=true


FROM eclipse-temurin:21-jre-alpine AS final
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/TaskFlow-0.0.1-SNAPSHOT.jar /opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]


