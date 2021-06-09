FROM maven:3.5.4

MAINTAINER test
COPY sample-0.0.1-SNAPSHOT.war /opt/sample-0.0.1-SNAPSHOT.war
COPY run.sh /opt/run.sh

RUN chmod 777 /opt/run.sh

RUN ls -l /opt

ENTRYPOINT ["java", "-jar"]
CMD ["/opt/sample-0.0.1-SNAPSHOT.war"]
