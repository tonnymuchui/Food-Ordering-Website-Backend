FROM openjdk:21-slim

WORKDIR /app

COPY FoodOrdering-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 5454

CMD ["java", "-jar", "app.jar"]

RUN  mvn clean package -DskipTests