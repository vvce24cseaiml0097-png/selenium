FROM maven:3.9-eclipse-temurin-17

RUN apt-get update && \
    apt-get install -y chromium chromium-driver && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

ENV CHROME_BIN=/usr/bin/chromium

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

CMD ["mvn", "test"]