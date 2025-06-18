# Factory Method Pattern Example

This project demonstrates the implementation of the Factory Method design pattern using a document management system that creates different types of documents (Word, PDF, Excel).

## Project Structure

```
FactoryMethodPatternExample/
├── src/
│   └── main/
│       └── java/
│           ├── Document.java              # Abstract Document class (Product)
│           ├── WordDocument.java          # Concrete Word document
│           ├── PdfDocument.java           # Concrete PDF document
│           ├── ExcelDocument.java         # Concrete Excel document
│           ├── DocumentFactory.java       # Abstract Factory class (Creator)
│           ├── WordDocumentFactory.java   # Concrete Word factory
│           ├── PdfDocumentFactory.java    # Concrete PDF factory
│           ├── ExcelDocumentFactory.java  # Concrete Excel factory
│           └── FactoryMethodTest.java     # Test class
├── README.md                              # This file
├── run.bat                               # Windows build script
└── run.sh                                # Unix/Linux build script
```

## What is the Factory Method Pattern?

The Factory Method pattern defines an interface for creating objects but lets subclasses decide which class to instantiate. It allows a class to defer instantiation to subclasses.

### Key Components

1. **Product (Document)**: The abstract class/interface for the objects being created
2. **Concrete Products (WordDocument, PdfDocument, ExcelDocument)**: The actual implementations
3. **Creator (DocumentFactory)**: The abstract factory class with the factory method
4. **Concrete Creators (WordDocumentFactory, PdfDocumentFactory, ExcelDocumentFactory)**: The actual factory implementations

## Implementation Details

### Document Classes
- **`Document.java`**: Abstract base class with common functionality
- **`WordDocument.java`**: Concrete implementation for Word documents
- **`PdfDocument.java`**: Concrete implementation for PDF documents
- **`ExcelDocument.java`**: Concrete implementation for Excel documents

### Factory Classes
- **`DocumentFactory.java`**: Abstract factory with the `createDocument()` method
- **`WordDocumentFactory.java`**: Creates Word documents
- **`PdfDocumentFactory.java`**: Creates PDF documents
- **`ExcelDocumentFactory.java`**: Creates Excel documents

### Key Features
- ✅ Polymorphic object creation
- ✅ Encapsulation of object creation logic
- ✅ Easy extension for new document types
- ✅ Template method pattern integration
- ✅ Type-specific factory methods

## How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Command line access

### Compilation and Execution

1. **Navigate to the project directory:**
   ```bash
   cd FactoryMethodPatternExample
   ```

2. **Compile the Java files:**
   ```bash
   javac src/main/java/*.java
   ```

3. **Run the test program:**
   ```bash
   java -cp src/main/java FactoryMethodTest
   ```

### Expected Output

When you run the program, you should see output similar to:

```
=== Factory Method Pattern Test ===

Test 1: Basic Factory Method Usage
Creating Word document: Report
Creating PDF document: Manual
Creating Excel document: Budget
Created: Word Document
Created: PDF Document
Created: Excel Document

Test 2: Document Workflow using Template Method
=== Creating and working with Word Document Factory ===
Creating Word document: Business Report
Opening Word document: Business Report.docx
Launching Microsoft Word...
Document opened successfully!
Saving Word document: Business Report.docx
Document saved successfully!
Closing Word document: Business Report.docx
Document closed successfully!
=== Word Document Factory workflow completed ===

[... more output showing different document types ...]

=== Factory Method Pattern Test Completed Successfully! ===
```

## Test Verification

The test program demonstrates:

1. **Basic Factory Method Usage**: Shows how different factories create different document types
2. **Document Workflow**: Uses template method pattern to demonstrate complete document lifecycle
3. **Specific Factory Methods**: Shows type-specific factory methods for each document type
4. **Polymorphic Behavior**: Demonstrates how the same interface can create different objects

## Factory Method Pattern Benefits

- **Loose Coupling**: Client code doesn't need to know concrete classes
- **Extensibility**: Easy to add new document types without changing existing code
- **Single Responsibility**: Each factory is responsible for creating one type of object
- **Open/Closed Principle**: Open for extension, closed for modification

## Use Cases

The Factory Method pattern is commonly used for:
- Document creation systems
- UI component creation
- Database connection factories
- Plugin systems
- Configuration object creation

## Design Patterns Used

This implementation also demonstrates:
- **Template Method Pattern**: The `createAndWorkWithDocument()` method in `DocumentFactory`
- **Polymorphism**: Using the same interface to create different objects
- **Inheritance**: Concrete classes extending abstract base classes

## Notes

This implementation shows both basic factory method usage and advanced features like:
- Type-specific factory methods
- Template method integration
- Polymorphic behavior
- Document-specific functionality

The pattern makes it easy to add new document types by simply creating new concrete document classes and corresponding factory classes. 