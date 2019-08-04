FROM openjdk:11.0.3
ADD ./target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]