FROM maven:3.8.5-openjdk:21-slim AS build
COPY . .
RUN  mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/FoodOrdering-0.0.1-SNAPSHOT.jar FoodOrdering.jar
EXPOSE 5454
ENTRYPOINT ["java", "-jar", "FoodOrdering.jar"]