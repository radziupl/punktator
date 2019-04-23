FROM openjdk:8u191-jdk-alpine3.9
ADD target/punktator-0.0.1-SNAPSHOT.war .
EXPOSE 8000
CMD java -war punktator-0.0.1-SNAPSHOT.war