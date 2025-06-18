import java.util.Arrays;

/**
 * SearchAlgorithms class implementing linear and binary search for e-commerce products
 * Demonstrates different search strategies and their performance characteristics
 */
public class SearchAlgorithms {
    
    /**
     * Linear Search Algorithm
     * Time Complexity: O(n) - Best: O(1), Average: O(n/2), Worst: O(n)
     * Space Complexity: O(1)
     * 
     * @param products Array of products to search in
     * @param targetId Product ID to search for
     * @return Product if found, null otherwise
     */
    public static Product linearSearch(Product[] products, int targetId) {
        System.out.println("Performing Linear Search for Product ID: " + targetId);
        int comparisons = 0;
        
        for (int i = 0; i < products.length; i++) {
            comparisons++;
            if (products[i].getProductId() == targetId) {
                System.out.println("✓ Product found after " + comparisons + " comparisons");
                return products[i];
            }
        }
        
        System.out.println("✗ Product not found after " + comparisons + " comparisons");
        return null;
    }
    
    /**
     * Binary Search Algorithm (requires sorted array)
     * Time Complexity: O(log n) - Best: O(1), Average: O(log n), Worst: O(log n)
     * Space Complexity: O(1) for iterative, O(log n) for recursive
     * 
     * @param products Sorted array of products to search in
     * @param targetId Product ID to search for
     * @return Product if found, null otherwise
     */
    public static Product binarySearch(Product[] products, int targetId) {
        System.out.println("Performing Binary Search for Product ID: " + targetId);
        int comparisons = 0;
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            int currentId = products[mid].getProductId();
            
            if (currentId == targetId) {
                System.out.println("✓ Product found after " + comparisons + " comparisons");
                return products[mid];
            } else if (currentId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println("✗ Product not found after " + comparisons + " comparisons");
        return null;
    }
    
    /**
     * Binary Search by Product Name (requires sorted array by name)
     * Time Complexity: O(log n)
     * 
     * @param productsByName Array sorted by product name
     * @param targetName Product name to search for
     * @return Product if found, null otherwise
     */
    public static Product binarySearchByName(Product[] productsByName, String targetName) {
        System.out.println("Performing Binary Search for Product Name: " + targetName);
        int comparisons = 0;
        int left = 0;
        int right = productsByName.length - 1;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            String currentName = productsByName[mid].getProductName();
            int comparison = currentName.compareToIgnoreCase(targetName);
            
            if (comparison == 0) {
                System.out.println("✓ Product found after " + comparisons + " comparisons");
                return productsByName[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println("✗ Product not found after " + comparisons + " comparisons");
        return null;
    }
    
    /**
     * Sort products by ID for binary search
     * @param products Array of products to sort
     */
    public static void sortProductsById(Product[] products) {
        System.out.println("Sorting products by ID for binary search...");
        Arrays.sort(products);
        System.out.println("✓ Products sorted successfully");
    }
    
    /**
     * Sort products by name for binary search by name
     * @param products Array of products to sort
     */
    public static void sortProductsByName(Product[] products) {
        System.out.println("Sorting products by name for binary search...");
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        System.out.println("✓ Products sorted by name successfully");
    }
    
    /**
     * Display array of products
     * @param products Array to display
     * @param title Title for the display
     */
    public static void displayProducts(Product[] products, String title) {
        System.out.println("\n" + title + ":");
        System.out.println("=".repeat(80));
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, products[i]);
        }
        System.out.println("=".repeat(80));
    }
    
    /**
     * Generate sample products for testing
     * @return Array of sample products
     */
    public static Product[] generateSampleProducts() {
        return new Product[] {
            new Product(1001, "Laptop", "Electronics", 999.99, "High-performance laptop"),
            new Product(1002, "Smartphone", "Electronics", 699.99, "Latest smartphone model"),
            new Product(1003, "Headphones", "Electronics", 199.99, "Wireless noise-canceling headphones"),
            new Product(2001, "T-Shirt", "Clothing", 29.99, "Cotton t-shirt"),
            new Product(2002, "Jeans", "Clothing", 79.99, "Blue denim jeans"),
            new Product(2003, "Sneakers", "Clothing", 89.99, "Comfortable running shoes"),
            new Product(3001, "Coffee Maker", "Home", 149.99, "Automatic coffee machine"),
            new Product(3002, "Blender", "Home", 79.99, "High-speed blender"),
            new Product(3003, "Microwave", "Home", 199.99, "Countertop microwave oven"),
            new Product(4001, "Novel", "Books", 19.99, "Bestselling fiction novel"),
            new Product(4002, "Cookbook", "Books", 24.99, "Collection of recipes"),
            new Product(4003, "Magazine", "Books", 9.99, "Monthly lifestyle magazine")
        };
    }
} 