# ---- Build Stage ----
# 使用 Maven 镜像来构建应用
FROM maven:3.8.5-openjdk-17 AS build

# 设置工作目录
WORKDIR /app

# 复制整个项目到工作目录
COPY . .

# 运行 Maven 命令来构建 user-service 模块
# -DskipTests 会跳过测试，加快构建速度
RUN mvn -pl user-service -am clean package -DskipTests

# ---- Run Stage ----
# 使用 OpenJDK 17 作为最终运行环境
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 从构建阶段复制已打包的 JAR 文件
COPY --from=build /app/user-service/target/user-service-*.jar app.jar

# 暴露端口
EXPOSE 8081

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]
