FROM bellsoft/liberica-openjdk-alpine

MAINTAINER Carlos A. Fernandez Cairo <cfernandezcairo@gmail.com>

#ARG artifactname
#VOLUME /tmp
#ADD ${artifactname}.jar app.jar

ADD "./../target/*.jar" "app.jar"
ENV JAVA_OPTS=""
EXPOSE 8081

#ADD wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch /app.jar'
RUN sh -c 'touch /wait-for-it.sh'
RUN sh -c 'chmod +x /wait-for-it.sh'
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]