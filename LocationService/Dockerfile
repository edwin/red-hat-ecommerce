FROM registry.redhat.io/jboss-eap-7/eap74-openjdk11-openshift-rhel8

COPY target/*.war $JBOSS_HOME/standalone/deployments/

USER root
RUN chown jboss:jboss -R $JBOSS_HOME/standalone/deployments/
USER jboss

EXPOSE 8080