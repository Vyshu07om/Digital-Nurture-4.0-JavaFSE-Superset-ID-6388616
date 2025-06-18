/**
 * Concrete ExcelDocumentFactory class that extends DocumentFactory
 * Implements the factory method to create Excel documents
 */
public class ExcelDocumentFactory extends DocumentFactory {
    
    /**
     * Factory method implementation for creating Excel documents
     * @param name The name of the Excel document to create
     * @return An ExcelDocument object
     */
    @Override
    public Document createDocument(String name) {
        System.out.println("Creating Excel document: " + name);
        return new ExcelDocument(name);
    }
    
    /**
     * Get the type of factory
     * @return The type of factory (Excel Document Factory)
     */
    @Override
    public String getFactoryType() {
        return "Excel Document Factory";
    }
    
    /**
     * Excel-specific factory method for creating spreadsheet with data
     * @param name The name of the document
     * @param data 2D array of data to populate
     * @return An ExcelDocument object
     */
    public ExcelDocument createSpreadsheetWithData(String name, String[][] data) {
        System.out.println("Creating Excel spreadsheet with data: " + name);
        ExcelDocument document = new ExcelDocument(name);
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                document.addCellData(i + 1, j + 1, data[i][j]);
            }
        }
        
        return document;
    }
    
    /**
     * Excel-specific factory method for creating chart document
     * @param name The name of the document
     * @param chartType The type of chart to create
     * @return An ExcelDocument object
     */
    public ExcelDocument createChartDocument(String name, String chartType) {
        System.out.println("Creating Excel chart document: " + name);
        ExcelDocument document = new ExcelDocument(name);
        document.createChart(chartType);
        return document;
    }
    
    /**
     * Excel-specific factory method for creating financial document
     * @param name The name of the document
     * @param formulas Array of formulas to apply
     * @return An ExcelDocument object
     */
    public ExcelDocument createFinancialDocument(String name, String[] formulas) {
        System.out.println("Creating Excel financial document: " + name);
        ExcelDocument document = new ExcelDocument(name);
        
        for (String formula : formulas) {
            document.applyFormula(formula);
        }
        
        return document;
    }
} 