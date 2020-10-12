mvn clean package -U -DskipTests
docker build -t nf404/slide:v3 .