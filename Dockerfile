FROM amazoncorretto:17

# Instala Maven manualmente (já que não é a imagem oficial do Maven)
RUN yum install -y maven

ENV TZ=America/Fortaleza

COPY . /app
WORKDIR /app

RUN mvn clean install -DskipTests

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/ecos-api.jar"]
