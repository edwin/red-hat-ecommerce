FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:latest

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

COPY --chown=185 target/*.jar /deployments/app.jar

EXPOSE 8080
USER 185

ENTRYPOINT [ "java", "-jar", "/deployments/app.jar" ]