# Singleton Pattern Example

This project demonstrates the implementation of the Singleton design pattern using a Logger utility class.

## Project Structure

```
SingletonPatternExample/
├── src/
│   └── main/
│       └── java/
│           ├── Logger.java          # Singleton Logger class
│           └── SingletonTest.java   # Test class to verify singleton behavior
└── README.md                        # This file
```

## What is the Singleton Pattern?

The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. This is useful when you need to ensure that only one instance of a class exists throughout the application lifecycle.

## Implementation Details

### Logger.java
- **Private Constructor**: Prevents direct instantiation of the Logger class
- **Private Static Instance**: Holds the single instance of the Logger
- **Public Static getInstance() Method**: Provides access to the singleton instance
- **Lazy Initialization**: The instance is created only when first requested

### Key Features
- ✅ Only one instance is created throughout the application
- ✅ Thread-safe (for this basic implementation)
- ✅ Lazy initialization (instance created on first use)
- ✅ Global access point via `getInstance()` method

## How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Command line access

### Compilation and Execution

1. **Navigate to the project directory:**
   ```bash
   cd SingletonPatternExample
   ```

2. **Compile the Java files:**
   ```bash
   javac src/main/java/*.java
   ```

3. **Run the test program:**
   ```bash
   java -cp src/main/java SingletonTest
   ```

### Expected Output

When you run the program, you should see output similar to:

```
=== Singleton Pattern Test ===

Logger instance created!
Test 1: Verifying singleton behavior
logger1 == logger2: true
logger2 == logger3: true
logger1 == logger3: true

Test 2: Using the logger functionality
[LOG] This is a test message
[ERROR] This is an error message
[INFO] This is an info message

Test 3: Verifying object identity
logger1 hashCode: 1234567890
logger2 hashCode: 1234567890
logger3 hashCode: 1234567890
All hash codes are identical: true

Test 4: Attempting to create new instance (will fail)
✓ Private constructor successfully prevents direct instantiation

=== Test completed successfully! ===
✓ Singleton pattern is working correctly
✓ Only one Logger instance exists throughout the application
```

## Test Verification

The test program verifies the Singleton pattern by:

1. **Instance Equality**: Confirms that multiple calls to `getInstance()` return the same object
2. **Functionality Test**: Demonstrates that the Logger methods work correctly
3. **Object Identity**: Verifies that all references point to the same object using `hashCode()`
4. **Constructor Protection**: Confirms that the private constructor prevents direct instantiation

## Singleton Pattern Benefits

- **Resource Management**: Ensures only one instance consumes resources
- **Consistent State**: All parts of the application use the same instance
- **Global Access**: Provides easy access to the instance from anywhere in the application
- **Lazy Loading**: Instance is created only when needed

## Use Cases

The Singleton pattern is commonly used for:
- Logging utilities
- Database connections
- Configuration managers
- Cache managers
- Thread pools

## Notes

This implementation uses lazy initialization, which is suitable for most use cases. For thread-safe applications in multi-threaded environments, consider using double-checked locking or the enum-based singleton pattern. 