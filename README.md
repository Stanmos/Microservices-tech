# Microservices Project
This is a sample Java application using Spring Boot and microservices architecture, consisting of three main services: inventory-service, order-service and productservice , which use MySQL and MongoDB databases for storing data. The application uses Authentication and authorization are handled by Keycloak, Docker Compose to facilitate easy deployment and Prometheus for monitoring.

![project_structure](https://im.wampi.ru/2023/03/20/scheme1.png)

## Services

### Inventory-service
This microservice can check if product is in stock or not. It uses a MySQL database to store information about product IDs, SKU codes, and available quantities. A GET request to the API endpoint returns a list of all available products.

### Order-service
This microservice handles the creation of orders and uses a MySQL database to store order information. Before saving an order to the database, the orderservice checks with the inventoryservice to ensure that all products in the order are available in the required quantities. This is done through the use of Spring Boot's WebClient class. A POST request to the API endpoint saves the order to the database.

### Product-service
This microservice handles the creation and retrieval of product data, acts as Product Catalog. It uses a MongoDB database to store product information. A GET request to the API endpoint returns a list of all available products, while a POST request saves a new product to the database.

## Additional Components

### Discovery Server
The Discovery Server component of this project is built using Spring Cloud Netflix Eureka Server. It provides a centralized registry of all microservices in the application, allowing them to find and communicate with each other.

### API Gateway
The API Gateway component of this project is built using Spring Cloud Gateway. It serves as the entry point for all incoming requests to the microservices. Requests are routed to the appropriate microservice based on the URL.

### Circuit Breaker
The circuit breaker pattern implementation used in this project is Resilience4j. It is used to prevent cascading failures in the application. If a microservice fails, the circuit breaker is triggered and returns a fallback response, preventing the failure from propagating to other microservices.

### Security
Keycloak is used for authentication and authorization, providing a unified platform for securing the microservices. This project uses OAuth2ResourceServerSpec token-based security with JWT. All API endpoints are protected and require a valid JWT token to access.

### Tracing
The tracing component of this project is implemented using Spring Cloud Sleuth and Zipkin. It provides a distributed tracing solution for the microservices, allowing developers to identify and troubleshoot issues across the entire application.

### Messaging
This project uses Spring Cloud Stream and Kafka to handle messaging between microservices. Kafka serves as the message broker, while Spring Cloud Stream provides a simple way to bind microservices to the messaging system. Notification Service in project can send notifications, after order is placed.

### Jib Container Image Builder
Jib is used to build optimized Docker images without the need for a Docker daemon or a Dockerfile.

### Prometheus Monitoring 
The application is integrated with Prometheus, which provides comprehensive monitoring and alerting capabilities for the entire system.

## Deployment
The application can be easily deployed using Docker Compose. To deploy the application, run the following command:
Copy code
````
docker-compose up -d
````
This will start all three services and the necessary infrastructure (Eureka server, API gateway, Kafka, Keycloak, DB).
