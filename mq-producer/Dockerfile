FROM openjdk:8-jre-slim

# 设置工作目录
WORKDIR /app

# 复制 jar 文件到容器
COPY mq-producer-1.0.0.jar app.jar
RUN chmod +x app.jar
# 设置 JVM 参数 & 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]
