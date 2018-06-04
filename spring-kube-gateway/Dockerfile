FROM openjdk:8
MAINTAINER Juan Medina <jamedina@gmail.com>

VOLUME /tmp

ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 8080

ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
