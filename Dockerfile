FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV IP=192.168.10.236
ENTRYPOINT ["sh", "-c" , "java -jar /app.jar --spring.rabbitmq.host=$IP --spring.datasource.url=jdbc:mysql://$IP:3306/db_measurement --spring.datasource.username=springuser --spring.datasource.password=Walter12 --spring.jpa.hibernate.ddl-auto=create --spring.rabbitmq.username=rabbituser --spring.rabbitmq.password=FelH4szn4l0 --spring.rabbitmq.port=5672 --spring.rabbitmq.virtual-host=greenhouse.dev"]