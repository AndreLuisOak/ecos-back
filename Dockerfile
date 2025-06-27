FROM amazoncorretto:17

# Instala Maven manualmente (versão 3.9.6)
RUN yum install -y curl tar gzip && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -o maven.tar.gz && \
    tar -xzf maven.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.6 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME=/opt/maven
ENV TZ=America/Fortaleza

COPY . /app
WORKDIR /app

# ⚠️ Aqui está a flag mágica para resolver o erro do Lombok
RUN mvn clean install -DskipTests -Dmaven.compiler.compilerArgs="--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/ecos-api.jar"]
