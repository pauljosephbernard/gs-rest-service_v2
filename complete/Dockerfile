FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
RUN ls -al
COPY ./complete/src /tmp/src/
COPY ./complete/pom.xml /tmp/

WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-slim

USER root
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /opt/rel/test-rest-service.jar


EXPOSE 8082

WORKDIR /opt/rel/
ENTRYPOINT java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -XshowSettings:vm -Xms2G -Xmx2G -jar test-rest-service.jar
