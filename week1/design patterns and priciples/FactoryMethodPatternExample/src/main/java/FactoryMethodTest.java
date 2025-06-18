/**
 * Test class to demonstrate the Factory Method pattern implementation
 * Shows how different document types are created using their respective factories
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");
        
        // Test 1: Basic Factory Method Usage
        System.out.println("Test 1: Basic Factory Method Usage");
        testBasicFactoryMethod();
        
        // Test 2: Document Workflow using Template Method
        System.out.println("Test 2: Document Workflow using Template Method");
        testDocumentWorkflow();
        
        // Test 3: Specific Factory Methods
        System.out.println("Test 3: Specific Factory Methods");
        testSpecificFactoryMethods();
        
        // Test 4: Polymorphic Behavior
        System.out.println("Test 4: Polymorphic Behavior");
        testPolymorphicBehavior();
        
        System.out.println("=== Factory Method Pattern Test Completed Successfully! ===");
    }
    
    /**
     * Test basic factory method usage
     */
    private static void testBasicFactoryMethod() {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Create documents using factory methods
        Document wordDoc = wordFactory.createDocument("Report");
        Document pdfDoc = pdfFactory.createDocument("Manual");
        Document excelDoc = excelFactory.createDocument("Budget");
        
        // Verify document types
        System.out.println("Created: " + wordDoc.getDocumentType());
        System.out.println("Created: " + pdfDoc.getDocumentType());
        System.out.println("Created: " + excelDoc.getDocumentType());
        System.out.println();
    }
    
    /**
     * Test document workflow using template method
     */
    private static void testDocumentWorkflow() {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Use template method to create and work with documents
        wordFactory.createAndWorkWithDocument("Business Report");
        pdfFactory.createAndWorkWithDocument("User Manual");
        excelFactory.createAndWorkWithDocument("Financial Data");
    }
    
    /**
     * Test specific factory methods for each document type
     */
    private static void testSpecificFactoryMethods() {
        // Word Document specific methods
        WordDocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument formattedDoc = wordFactory.createFormattedDocument("Resume", "Professional Template");
        formattedDoc.open();
        formattedDoc.formatText("John Doe - Software Engineer");
        formattedDoc.save();
        formattedDoc.close();
        System.out.println();
        
        // PDF Document specific methods
        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument securedDoc = pdfFactory.createSecuredDocument("Confidential Report", "secret123");
        securedDoc.open();
        securedDoc.addBookmark("Introduction");
        securedDoc.addBookmark("Conclusion");
        securedDoc.save();
        securedDoc.close();
        System.out.println();
        
        // Excel Document specific methods
        ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();
        String[][] data = {
            {"Name", "Age", "Salary"},
            {"John", "30", "50000"},
            {"Jane", "25", "45000"},
            {"Bob", "35", "60000"}
        };
        ExcelDocument spreadsheet = excelFactory.createSpreadsheetWithData("Employee Data", data);
        spreadsheet.open();
        spreadsheet.createChart("Bar Chart");
        spreadsheet.save();
        spreadsheet.close();
        System.out.println();
    }
    
    /**
     * Test polymorphic behavior of the factory method pattern
     */
    private static void testPolymorphicBehavior() {
        System.out.println("Testing polymorphic behavior:");
        
        // Create an array of factories
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        
        // Use polymorphic behavior to create documents
        for (DocumentFactory factory : factories) {
            Document doc = factory.createDocument("Test Document");
            System.out.println("Factory type: " + factory.getFactoryType());
            System.out.println("Document type: " + doc.getDocumentType());
            System.out.println("Document name: " + doc.getName());
            System.out.println("---");
        }
        System.out.println();
    }
} 