/**
 * Abstract Document class that serves as the base for all document types
 * This is the Product interface in the Factory Method pattern
 */
public abstract class Document {
    protected String name;
    protected String content;
    
    /**
     * Constructor for Document
     * @param name The name of the document
     */
    public Document(String name) {
        this.name = name;
        this.content = "";
    }
    
    /**
     * Abstract method that must be implemented by concrete document classes
     * Each document type will have its own way of opening
     */
    public abstract void open();
    
    /**
     * Abstract method that must be implemented by concrete document classes
     * Each document type will have its own way of saving
     */
    public abstract void save();
    
    /**
     * Abstract method that must be implemented by concrete document classes
     * Each document type will have its own way of closing
     */
    public abstract void close();
    
    /**
     * Method to add content to the document
     * @param content The content to add
     */
    public void addContent(String content) {
        this.content += content + "\n";
    }
    
    /**
     * Get the document name
     * @return The name of the document
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the document content
     * @return The content of the document
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Get the document type
     * @return The type of document
     */
    public abstract String getDocumentType();
} 