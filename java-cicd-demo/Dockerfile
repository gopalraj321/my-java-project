# Use a minimal Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy only the final jar (already built by Jenkins)
COPY target/*.jar app.jar
# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
