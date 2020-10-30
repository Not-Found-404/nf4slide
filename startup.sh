mvn clean package -U -DskipTests
docker build  -t nf404/slide:v3  --build-arg REDIS_HOST=$REDIS_HOST,MYSQL_HOST=$MYSQL_HOST,MYSQL_USERNAME=$MYSQL_USERNAME,MYSQL_PASSWORD=$MYSQL_PASSWORD .
# nohup java -jar slide-web-starter/target/slide-web-starter.jar > /root/workplace/web.out  2>&1 &
docker run -d -p 8888:8888 nf404/slide:v3