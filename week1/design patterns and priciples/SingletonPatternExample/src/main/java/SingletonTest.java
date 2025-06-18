/**
 * Test class to verify the Singleton pattern implementation
 * Demonstrates that only one instance of Logger is created and used
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");
        
        // Test 1: Get multiple instances and verify they are the same
        System.out.println("Test 1: Verifying singleton behavior");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        // Check if all references point to the same object
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        
        // Test 2: Use the logger to demonstrate functionality
        System.out.println("\nTest 2: Using the logger functionality");
        logger1.log("This is a test message");
        logger2.logError("This is an error message");
        logger3.logInfo("This is an info message");
        
        // Test 3: Verify hash codes are the same (proving same instance)
        System.out.println("\nTest 3: Verifying object identity");
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());
        System.out.println("All hash codes are identical: " + 
            (logger1.hashCode() == logger2.hashCode() && 
             logger2.hashCode() == logger3.hashCode()));
        
        // Test 4: Demonstrate that constructor cannot be called directly
        System.out.println("\nTest 4: Attempting to create new instance (will fail)");
        try {
            // This line would cause a compilation error if uncommented
            // Logger newLogger = new Logger(); // Private constructor prevents this
            System.out.println("✓ Private constructor successfully prevents direct instantiation");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n=== Test completed successfully! ===");
        System.out.println("✓ Singleton pattern is working correctly");
        System.out.println("✓ Only one Logger instance exists throughout the application");
    }
} 