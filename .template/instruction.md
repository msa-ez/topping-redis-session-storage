Redis Session Storage is an efficient solution for session management in distributed system environments. Unlike traditional in-memory session management methods, Redis enables secure and fast sharing of session information across multiple servers.

###Benefits
1. Scalability
- Easy horizontal scaling
- Automatic session synchronization between multiple server instances
- Seamless session management in load-balanced environments

2. Performance
- Fast access through in-memory data storage
- Superior read/write performance compared to persistent storage
- Efficient serialization/deserialization of session data

3. Reliability
- Ensures session data persistence
- Preserves session information even during server failures
- High availability through Redis replication features

### Implementation Features
In this project, we implement the following features using Spring Session Data Redis:

#### 1. Security Enhancement
- Enhanced communication security with HTTPS-only cookie settings
- Session timeout management
#### 2. Microservice Integration
- Session sharing between services via Feign Client
- Header-based session ID propagation
- Secure cookie information transfer
#### 3. Configuration Management
- Separate configurations for development/production environments
- Easy customization of Redis connection settings

Value Proposition
Redis Session Storage is an essential component in modern microservice architecture. It provides significant value in enterprise applications where scalability, performance, and reliability are crucial. Through integration with Spring Session, developers can focus on business logic without worrying about complex session management logic.

### How to run

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
