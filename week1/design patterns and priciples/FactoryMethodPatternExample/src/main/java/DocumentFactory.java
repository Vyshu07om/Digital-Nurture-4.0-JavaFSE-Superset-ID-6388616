/**
 * Abstract DocumentFactory class that defines the Factory Method pattern
 * This is the Creator class in the Factory Method pattern
 */
public abstract class DocumentFactory {
    
    /**
     * Factory method that creates documents
     * This is the abstract factory method that subclasses must implement
     * @param name The name of the document to create
     * @return A Document object
     */
    public abstract Document createDocument(String name);
    
    /**
     * Template method that demonstrates the document creation workflow
     * This method uses the factory method to create and work with documents
     * @param name The name of the document to create
     */
    public void createAndWorkWithDocument(String name) {
        System.out.println("=== Creating and working with " + getFactoryType() + " ===");
        
        // Use the factory method to create the document
        Document document = createDocument(name);
        
        // Work with the created document
        document.open();
        document.addContent("Sample content for " + document.getDocumentType());
        document.save();
        document.close();
        
        System.out.println("=== " + getFactoryType() + " workflow completed ===\n");
    }
    
    /**
     * Get the type of factory
     * @return The type of factory
     */
    public abstract String getFactoryType();
} 