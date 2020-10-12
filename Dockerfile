FROM java

RUN mkdir /app
COPY slide-web/target/slide-web-0.0.1-SNAPSHOT.jar  /app/app.jar
CMD ["java","-jar" ,"/app/app.ar"]