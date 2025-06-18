/**
 * Concrete WordDocument class that extends Document
 * Implements specific behavior for Word documents
 */
public class WordDocument extends Document {
    
    /**
     * Constructor for WordDocument
     * @param name The name of the Word document
     */
    public WordDocument(String name) {
        super(name);
    }
    
    /**
     * Opens the Word document
     * Simulates opening a Word document
     */
    @Override
    public void open() {
        System.out.println("Opening Word document: " + name + ".docx");
        System.out.println("Launching Microsoft Word...");
        System.out.println("Document opened successfully!");
    }
    
    /**
     * Saves the Word document
     * Simulates saving a Word document
     */
    @Override
    public void save() {
        System.out.println("Saving Word document: " + name + ".docx");
        System.out.println("Document saved successfully!");
    }
    
    /**
     * Closes the Word document
     * Simulates closing a Word document
     */
    @Override
    public void close() {
        System.out.println("Closing Word document: " + name + ".docx");
        System.out.println("Document closed successfully!");
    }
    
    /**
     * Get the document type
     * @return The type of document (Word)
     */
    @Override
    public String getDocumentType() {
        return "Word Document";
    }
    
    /**
     * Word-specific method for formatting text
     * @param text The text to format
     */
    public void formatText(String text) {
        System.out.println("Formatting text in Word document: " + text);
        addContent("Formatted: " + text);
    }
} 