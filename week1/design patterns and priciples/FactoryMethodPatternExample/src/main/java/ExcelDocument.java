/**
 * Concrete ExcelDocument class that extends Document
 * Implements specific behavior for Excel documents
 */
public class ExcelDocument extends Document {
    
    /**
     * Constructor for ExcelDocument
     * @param name The name of the Excel document
     */
    public ExcelDocument(String name) {
        super(name);
    }
    
    /**
     * Opens the Excel document
     * Simulates opening an Excel document
     */
    @Override
    public void open() {
        System.out.println("Opening Excel document: " + name + ".xlsx");
        System.out.println("Launching Microsoft Excel...");
        System.out.println("Document opened successfully!");
    }
    
    /**
     * Saves the Excel document
     * Simulates saving an Excel document
     */
    @Override
    public void save() {
        System.out.println("Saving Excel document: " + name + ".xlsx");
        System.out.println("Document saved successfully!");
    }
    
    /**
     * Closes the Excel document
     * Simulates closing an Excel document
     */
    @Override
    public void close() {
        System.out.println("Closing Excel document: " + name + ".xlsx");
        System.out.println("Document closed successfully!");
    }
    
    /**
     * Get the document type
     * @return The type of document (Excel)
     */
    @Override
    public String getDocumentType() {
        return "Excel Document";
    }
    
    /**
     * Excel-specific method for adding data to a cell
     * @param row The row number
     * @param col The column number
     * @param data The data to add
     */
    public void addCellData(int row, int col, String data) {
        System.out.println("Adding data to cell [" + row + "," + col + "]: " + data);
        addContent("Cell[" + row + "," + col + "]: " + data);
    }
    
    /**
     * Excel-specific method for creating a chart
     * @param chartType The type of chart to create
     */
    public void createChart(String chartType) {
        System.out.println("Creating " + chartType + " chart in Excel document");
        addContent("Chart created: " + chartType);
    }
    
    /**
     * Excel-specific method for applying formulas
     * @param formula The formula to apply
     */
    public void applyFormula(String formula) {
        System.out.println("Applying formula in Excel: " + formula);
        addContent("Formula: " + formula);
    }
} 