/**
 * Concrete WordDocumentFactory class that extends DocumentFactory
 * Implements the factory method to create Word documents
 */
public class WordDocumentFactory extends DocumentFactory {
    
    /**
     * Factory method implementation for creating Word documents
     * @param name The name of the Word document to create
     * @return A WordDocument object
     */
    @Override
    public Document createDocument(String name) {
        System.out.println("Creating Word document: " + name);
        return new WordDocument(name);
    }
    
    /**
     * Get the type of factory
     * @return The type of factory (Word Document Factory)
     */
    @Override
    public String getFactoryType() {
        return "Word Document Factory";
    }
    
    /**
     * Word-specific factory method for creating formatted documents
     * @param name The name of the document
     * @param template The template to use
     * @return A WordDocument object
     */
    public WordDocument createFormattedDocument(String name, String template) {
        System.out.println("Creating formatted Word document: " + name + " with template: " + template);
        WordDocument document = new WordDocument(name);
        document.addContent("Template: " + template);
        return document;
    }
} 