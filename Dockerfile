FROM java

# RUN  apt-get update
# RUN  apt-get upgrade -y
# RUN  apt-get install -y python
# RUN  apt-get install -y git

RUN mkdir /app
COPY slide-web/target/slide-web-0.0.1-SNAPSHOT.jar  /app/app.jar
CMD ["java","-jar" ,"/app/app.ar"]