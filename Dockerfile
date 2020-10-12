FROM java

RUN mkdir /app
COPY slide-web-starter/target/slide-web-starter-0.0.1-SNAPSHOT.jar  /app/app.jar
CMD ["java","-jar" ,"/app/app.jar"]