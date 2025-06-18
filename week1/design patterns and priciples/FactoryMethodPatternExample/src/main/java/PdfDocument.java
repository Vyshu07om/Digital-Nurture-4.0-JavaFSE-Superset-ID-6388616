/**
 * Concrete PdfDocument class that extends Document
 * Implements specific behavior for PDF documents
 */
public class PdfDocument extends Document {
    
    /**
     * Constructor for PdfDocument
     * @param name The name of the PDF document
     */
    public PdfDocument(String name) {
        super(name);
    }
    
    /**
     * Opens the PDF document
     * Simulates opening a PDF document
     */
    @Override
    public void open() {
        System.out.println("Opening PDF document: " + name + ".pdf");
        System.out.println("Launching PDF reader...");
        System.out.println("Document opened successfully!");
    }
    
    /**
     * Saves the PDF document
     * Simulates saving a PDF document
     */
    @Override
    public void save() {
        System.out.println("Saving PDF document: " + name + ".pdf");
        System.out.println("Document saved successfully!");
    }
    
    /**
     * Closes the PDF document
     * Simulates closing a PDF document
     */
    @Override
    public void close() {
        System.out.println("Closing PDF document: " + name + ".pdf");
        System.out.println("Document closed successfully!");
    }
    
    /**
     * Get the document type
     * @return The type of document (PDF)
     */
    @Override
    public String getDocumentType() {
        return "PDF Document";
    }
    
    /**
     * PDF-specific method for adding bookmarks
     * @param bookmark The bookmark to add
     */
    public void addBookmark(String bookmark) {
        System.out.println("Adding bookmark to PDF: " + bookmark);
        addContent("Bookmark: " + bookmark);
    }
    
    /**
     * PDF-specific method for setting security
     * @param password The password for the PDF
     */
    public void setSecurity(String password) {
        System.out.println("Setting PDF security with password: " + password);
        addContent("Security enabled with password");
    }
} 