FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

COPY target/APILeadYourWay-0.0.1-SNAPSHOT.jar /api.v1.jr


ENTRYPOINT ["java", "-jar", "app.jar"]