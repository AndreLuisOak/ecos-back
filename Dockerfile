FROM maven:3.9.6-openjdk-17-slim

ENV TZ=America/Fortaleza

COPY . /app
WORKDIR /app

RUN mvn clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/ecos-api.jar"]
