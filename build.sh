#!/bin/bash

set -e  # 遇到错误就退出

# 配置变量（可按需修改）
PRODUCER_DIR="mq-producer"
CONSUMER_DIR="mqconsumer"
PRODUCER_JAR="mq-producer-1.0.0.jar"
CONSUMER_JAR="mq-consumer-1.0.0.jar"

echo "🔧 编译 Producer..."
cd $PRODUCER_DIR
mvn clean package -DskipTests
cp target/*.jar ./$PRODUCER_JAR

echo "构建 Producer 镜像..."
docker build -t mq-producer:1.0 .

cd ..

echo "🔧 编译 Consumer..."
cd $CONSUMER_DIR
mvn clean package -DskipTests
cp target/*.jar ./$CONSUMER_JAR

echo "构建 Consumer 镜像..."
docker build -t mq-consumer:1.0 .

cd ..

echo "所有镜像构建完成"
