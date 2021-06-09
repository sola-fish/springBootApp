FROM harbor.jd.com/jpipe/centos7.5-java:1.8-maven3.5.4

MAINTAINER ldy
COPY sample-0.0.1-SNAPSHOT.war /opt/sample-0.0.1-SNAPSHOT.war
COPY sample-0.0.1-SNAPSHOT1.war /opt/sample-0.0.1-SNAPSHOT1.war
COPY run.sh /opt/run.sh
COPY run1.sh /opt/run1.sh

RUN chmod 777 /opt/run.sh
RUN chmod 777 /opt/run1.sh

RUN ls -l /opt

ENTRYPOINT ["java", "-jar"]
CMD ["/opt/sample-0.0.1-SNAPSHOT.war"]
