/**
 * Concrete PdfDocumentFactory class that extends DocumentFactory
 * Implements the factory method to create PDF documents
 */
public class PdfDocumentFactory extends DocumentFactory {
    
    /**
     * Factory method implementation for creating PDF documents
     * @param name The name of the PDF document to create
     * @return A PdfDocument object
     */
    @Override
    public Document createDocument(String name) {
        System.out.println("Creating PDF document: " + name);
        return new PdfDocument(name);
    }
    
    /**
     * Get the type of factory
     * @return The type of factory (PDF Document Factory)
     */
    @Override
    public String getFactoryType() {
        return "PDF Document Factory";
    }
    
    /**
     * PDF-specific factory method for creating secured documents
     * @param name The name of the document
     * @param password The password for the PDF
     * @return A PdfDocument object
     */
    public PdfDocument createSecuredDocument(String name, String password) {
        System.out.println("Creating secured PDF document: " + name);
        PdfDocument document = new PdfDocument(name);
        document.setSecurity(password);
        return document;
    }
    
    /**
     * PDF-specific factory method for creating documents with bookmarks
     * @param name The name of the document
     * @param bookmarks Array of bookmarks to add
     * @return A PdfDocument object
     */
    public PdfDocument createDocumentWithBookmarks(String name, String[] bookmarks) {
        System.out.println("Creating PDF document with bookmarks: " + name);
        PdfDocument document = new PdfDocument(name);
        for (String bookmark : bookmarks) {
            document.addBookmark(bookmark);
        }
        return document;
    }
} 