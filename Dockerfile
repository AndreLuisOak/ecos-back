FROM amazoncorretto:17

# Instala Maven manualmente (versão 3.9.6)
RUN yum install -y curl tar && \
    curl -fsSL https://downloads.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -o maven.tar.gz && \
    tar -xzf maven.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.6 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME=/opt/maven

ENV TZ=America/Fortaleza

COPY . /app
WORKDIR /app

RUN mvn clean install -DskipTests

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/ecos-api.jar"]
