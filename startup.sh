mvn clean package -U -DskipTests
docker build -t nf404/slide:v3 .
docker run nf404/slide:v3