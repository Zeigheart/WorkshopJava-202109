FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/Zeigheart/WorkshopJava-202109.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=clone /app/demoapp /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/demoapp-0.0.1-SNAPSHOT.jar /app
CMD ["java -jar demoapp-0.0.1-SNAPSHOT.jar"]
