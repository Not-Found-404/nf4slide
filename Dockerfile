FROM java

RUN mkdir /app
COPY slide-web-starter/target/slide-web-starter.jar  /app/app.jar
CMD ["java","-jar" ,"/app/app.jar"]