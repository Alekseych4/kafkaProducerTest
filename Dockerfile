FROM openjdk:11
COPY target/*.jar /app.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","/app.jar"]