/**
 * Product class representing items in an e-commerce platform
 * Contains attributes for searching and identification
 */
public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private String description;
    
    /**
     * Constructor for Product
     * @param productId Unique identifier for the product
     * @param productName Name of the product
     * @param category Category of the product
     * @param price Price of the product
     * @param description Description of the product
     */
    public Product(int productId, String productName, String category, double price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
    }
    
    /**
     * Get product ID
     * @return Product ID
     */
    public int getProductId() {
        return productId;
    }
    
    /**
     * Get product name
     * @return Product name
     */
    public String getProductName() {
        return productName;
    }
    
    /**
     * Get product category
     * @return Product category
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Get product price
     * @return Product price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Get product description
     * @return Product description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Set product price
     * @param price New price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Set product description
     * @param description New description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Compare products by product ID for sorting
     * @param other Product to compare with
     * @return Comparison result
     */
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
    
    /**
     * Check if two products are equal based on product ID
     * @param obj Object to compare with
     * @return True if products are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId == product.productId;
    }
    
    /**
     * Generate hash code based on product ID
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(productId);
    }
    
    /**
     * String representation of the product
     * @return Formatted string
     */
    @Override
    public String toString() {
        return String.format("Product{ID=%d, Name='%s', Category='%s', Price=%.2f, Description='%s'}", 
                           productId, productName, category, price, description);
    }
} 