mvn clean package -U -DskipTests
docker build  -t nf404/slide:v3  --build-arg REDIS_HOST=$REDIS_HOST,MYSQL_HOST=$MYSQL_HOST,MYSQL_USERNAME=$MYSQL_USERNAME,MYSQL_PASSWORD=$MYSQL_PASSWORD .
docker run -d -p 8888:8888 nf404/slide:v3