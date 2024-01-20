FROM openjdk:21-jdk

EXPOSE 8080

COPY ./target/kaiburrProject-0.0.1-SNAPSHOT.jar kaiburr.jar

ENTRYPOINT ["java","-jar","kaiburr.jar"]
