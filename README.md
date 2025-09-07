# Spring Boot Aspect-Oriented Programming

A Spring Boot application demonstrating Aspect-Oriented Programming (AOP) concepts with execution time logging, REST API endpoints using `@PathVariable` and `@RequestParam`, and SMS/Customer management functionality.

## 📁 Project Structure

```
.idea/
├── .gitignore
├── encodings.xml
├── misc.xml
└── vcs.xml
logs/
└── app.log
src/
└── main/
    ├── java/
    │   └── edu/
    │       └── icet/
    │           └── demoervice/
    │               ├── annotation/
    │               │   └── LogExecutionTime.java
    │               ├── aspects/
    │               │   └── LoggingAspectResolver.java
    │               ├── controller/
    │               │   ├── CustomerController.java
    │               │   └── SMSController.java
    │               ├── model/
    │               │   └── Customer.java
    │               └── Main.java
    │   └── resources/
    │       └── application.yml
.gitignore
pom.xml
```

## 🚀 Features

### Aspect-Oriented Programming (AOP)
- **Custom Annotation**: `@LogExecutionTime` for method execution time logging
- **Aspect Class**: `LoggingAspectResolver` to handle cross-cutting concerns
- **Execution Time Monitoring**: Automatic logging of method execution times

### REST API Endpoints
- **Customer Management**: CRUD operations with path variables and request parameters
- **SMS Service**: SMS handling with various parameter binding techniques
- **Parameter Binding**: Demonstrates `@PathVariable` and `@RequestParam` usage

### Logging
- **Centralized Logging**: Application logs stored in `logs/app.log`
- **AOP-based Logging**: Automatic execution time logging through aspects

## 🛠️ Technologies Used

- **Spring Boot** - Main framework
- **Spring AOP** - Aspect-Oriented Programming
- **Spring Web** - REST API development
- **Java** - Programming language
- **Maven** - Dependency management
- **YAML** - Configuration management

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6+
- IDE with Spring Boot support (IntelliJ IDEA recommended)

## ⚙️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd demoservice
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run the `Main.java` class directly from your IDE.

4. **Access the application**
   ```
   http://localhost:8080
   ```

## 📚 API Documentation

### Customer Controller Endpoints

#### GET /customers/{id}
Retrieve customer by ID using `@PathVariable`
```http
GET /customers/123
```

#### GET /customers
Retrieve customers with optional filtering using `@RequestParam`
```http
GET /customers?name=John&status=active&page=1&size=10
```

#### POST /customers
Create a new customer
```http
POST /customers
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john@example.com"
}
```

#### PUT /customers/{id}
Update customer by ID
```http
PUT /customers/123
Content-Type: application/json

{
    "name": "John Smith",
    "email": "johnsmith@example.com"
}
```

#### DELETE /customers/{id}
Delete customer by ID
```http
DELETE /customers/123
```

### SMS Controller Endpoints

#### POST /sms/send/{phoneNumber}
Send SMS using path variable for phone number
```http
POST /sms/send/+1234567890?message=Hello World
```

#### GET /sms/status
Check SMS status with request parameters
```http
GET /sms/status?messageId=12345&trackingId=abc123
```

## 🔧 AOP Configuration

### @LogExecutionTime Annotation
Custom annotation to mark methods for execution time logging:

```java
@LogExecutionTime
public Customer getCustomerById(Long id) {
    // Method implementation
}
```

### Aspect Configuration
The `LoggingAspectResolver` automatically intercepts methods annotated with `@LogExecutionTime` and logs:
- Method name
- Execution time in milliseconds
- Parameters (optional)
- Return value (optional)

### Usage Examples

**Controller Method with AOP:**
```java
@GetMapping("/customers/{id}")
@LogExecutionTime
public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    // Method will be automatically logged
}
```

**Service Method with AOP:**
```java
@LogExecutionTime
public List<Customer> findCustomersByName(@RequestParam String name) {
    // Execution time will be logged
}
```

## 📝 Configuration

### application.yml
Configuration file contains:
- Server port settings
- Logging configuration
- Database connection (if applicable)
- AOP settings

### Logging Configuration
Logs are written to:
- **Console**: For development
- **File**: `logs/app.log` for production

## 🧪 Testing

### Manual Testing
1. Start the application
2. Use Postman or curl to test endpoints
3. Check `logs/app.log` for execution time logs
4. Verify AOP functionality by calling annotated methods

### Example cURL Commands
```bash
# Get customer by ID
curl -X GET http://localhost:8080/customers/1

# Get customers with parameters
curl -X GET "http://localhost:8080/customers?name=John&status=active"

# Send SMS
curl -X POST "http://localhost:8080/sms/send/1234567890?message=Hello"
```

## 📊 Monitoring & Logging

### Execution Time Logging
Methods annotated with `@LogExecutionTime` will automatically log:
```
[INFO] Method: getCustomerById executed in 45ms
[INFO] Method: sendSMS executed in 120ms
```

### Application Logs
Check `logs/app.log` for:
- Application startup logs
- Method execution times
- Error logs
- Request/response logs

## 🔍 Key Learning Points

### AOP Concepts Demonstrated
- **Cross-cutting Concerns**: Logging separated from business logic
- **Annotations**: Custom annotations for aspect targeting
- **Pointcuts**: Method selection for aspect application
- **Advice**: Before/After/Around advice implementation

### Spring Boot Features
- **@PathVariable**: Extract values from URL path
- **@RequestParam**: Handle query parameters
- **@RestController**: RESTful web service creation
- **Auto-configuration**: Minimal configuration setup

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

For questions or support, please contact:
- Email: yasithprabaswara1@gmail.com
- GitHub: [https://github.com/yasith-1]

## 🔗 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring AOP Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
- [REST API Best Practices](https://restfulapi.net/)
- [Maven Documentation](https://maven.apache.org/guides/)
