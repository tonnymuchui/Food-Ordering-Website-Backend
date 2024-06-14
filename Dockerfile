FROM openjdk:21-slim AS build

# Copy your project files to the build stage
COPY . .

# Run Maven to build your project, skipping tests
RUN mvnw clean package -DskipTests

# Create a new stage based on openjdk:21-slim for the final image
FROM openjdk:21-slim

# Copy the built JAR file from the build stage to the final image
COPY --from=build /target/FoodOrdering-0.0.1-SNAPSHOT.jar FoodOrdering.jar

# Expose port 5454 where your application might listen
EXPOSE 5454

# Define the default command to run your application using the JAR file
ENTRYPOINT ["java", "-jar", "FoodOrdering.jar"]
