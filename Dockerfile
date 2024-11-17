FROM openjdk:17.0.2
WORKDIR /app
COPY ./build/target/mi-api.jar .
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "mi-api.jar"]
