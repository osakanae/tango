# ベースイメージ
FROM openjdk:21-jdk-slim

# 作業ディレクトリを設定
WORKDIR /app

# 必要なファイルをコピー
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# プロジェクトのソースコードをコピー
COPY src/ ./src

# Maven Wrapper に実行権限を付与
RUN chmod +x mvnw

# プロジェクトをビルド
RUN ./mvnw package

# アプリケーションを実行
CMD ["java", "-jar", "target/tango-0.0.1-SNAPSHOT.jar"]
