### Setup Instructions

### 1. Configure Redis Password
Configure Redis settings in your microservice's `application.yml`:

```yaml
spring:
  redis:
    host: localhost
    port: 6379
    password: your_redis_password # Remove this line if no password is required
```

### 2. Start Redis Server
Launch Redis using Docker:

```bash
docker run --name redis -d -p 6379:6379 redis
```

### 3. Start Microservice
```
cd <microservice>
mvn spring-boot:run
```

### 4. Access Redis CLI
```
docker exec -it redis redis-cli
```

### 5. Test Redis
```
redis-cli > ping // Test Redis connection, returns PONG if connection is successful.

redis-cli > monitor // Real-time monitoring of session creation and sharing between service calls.
```
