FROM openjdk:17.0.2
WORKDIR /app
COPY ./target/practica-fifa22-jpa-0.0.1-SNAPSHOT.war .
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "practica-fifa22-jpa-0.0.1-SNAPSHOT.war"]
