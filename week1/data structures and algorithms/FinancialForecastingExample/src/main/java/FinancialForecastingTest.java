/**
 * FinancialForecastingTest class demonstrating recursive algorithms for financial forecasting
 * Includes recursion explanation, algorithm analysis, and practical testing
 */
public class FinancialForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== FINANCIAL FORECASTING WITH RECURSIVE ALGORITHMS ===\n");
        
        // Step 1: Understand Recursive Algorithms
        System.out.println("STEP 1: UNDERSTANDING RECURSIVE ALGORITHMS");
        System.out.println("=".repeat(60));
        RecursionAnalysis.explainRecursion();
        
        // Step 2: Setup - Create sample data
        System.out.println("STEP 2: SETUP - SAMPLE FINANCIAL DATA");
        System.out.println("=".repeat(60));
        setupSampleData();
        
        // Step 3: Implementation - Test recursive algorithms
        System.out.println("STEP 3: RECURSIVE ALGORITHM IMPLEMENTATION");
        System.out.println("=".repeat(60));
        testRecursiveAlgorithms();
        
        // Step 4: Analysis - Compare algorithms
        System.out.println("STEP 4: ALGORITHM ANALYSIS");
        System.out.println("=".repeat(60));
        analyzeAlgorithms();
        
        // Step 5: Advanced features
        System.out.println("STEP 5: ADVANCED FORECASTING FEATURES");
        System.out.println("=".repeat(60));
        testAdvancedFeatures();
        
        System.out.println("=== FINANCIAL FORECASTING ANALYSIS COMPLETED SUCCESSFULLY! ===");
    }
    
    /**
     * Setup and display sample financial data
     */
    private static void setupSampleData() {
        FinancialData[] sampleData = RecursiveForecasting.generateSampleData();
        
        System.out.println("Sample Historical Financial Data:");
        System.out.println("=".repeat(80));
        for (int i = 0; i < sampleData.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, sampleData[i].toDisplayString());
        }
        System.out.println("=".repeat(80));
        
        // Calculate and display average growth rate
        double avgGrowthRate = calculateAverageGrowthRate(sampleData);
        System.out.printf("Average Growth Rate: %.2f%%%n", avgGrowthRate);
        System.out.printf("Most Recent Value: $%.2f%n", sampleData[sampleData.length - 1].getValue());
        System.out.println();
    }
    
    /**
     * Calculate average growth rate from sample data
     */
    private static double calculateAverageGrowthRate(FinancialData[] data) {
        double totalGrowthRate = 0;
        int count = 0;
        
        for (int i = 1; i < data.length; i++) {
            double previousValue = data[i - 1].getValue();
            double currentValue = data[i].getValue();
            
            if (previousValue > 0) {
                double growthRate = ((currentValue - previousValue) / previousValue) * 100;
                totalGrowthRate += growthRate;
                count++;
            }
        }
        
        return count > 0 ? totalGrowthRate / count : 0;
    }
    
    /**
     * Test both basic and optimized recursive algorithms
     */
    private static void testRecursiveAlgorithms() {
        double initialValue = 10000.0;
        double growthRate = 5.0;
        int periods = 10;
        
        System.out.println("Testing Basic Recursive Algorithm:");
        System.out.println("-".repeat(50));
        
        long startTime = System.nanoTime();
        double basicResult = RecursiveForecasting.calculateFutureValueRecursive(initialValue, growthRate, periods);
        long basicTime = System.nanoTime() - startTime;
        
        System.out.printf("Initial Value: $%.2f%n", initialValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate);
        System.out.printf("Periods: %d%n", periods);
        System.out.printf("Result: $%.2f%n", basicResult);
        System.out.printf("Execution Time: %.3f milliseconds%n", basicTime / 1_000_000.0);
        System.out.println();
        
        System.out.println("Testing Optimized Recursive Algorithm:");
        System.out.println("-".repeat(50));
        
        startTime = System.nanoTime();
        double optimizedResult = RecursiveForecasting.calculateFutureValueOptimized(initialValue, growthRate, periods);
        long optimizedTime = System.nanoTime() - startTime;
        
        System.out.printf("Result: $%.2f%n", optimizedResult);
        System.out.printf("Execution Time: %.3f milliseconds%n", optimizedTime / 1_000_000.0);
        System.out.printf("Cache Size: %d entries%n", RecursiveForecasting.getCacheSize());
        System.out.printf("Speedup: %.1fx faster%n", (double) basicTime / optimizedTime);
        System.out.println();
        
        // Verify results are the same
        System.out.println("Verification:");
        System.out.printf("Results Match: %s%n", Math.abs(basicResult - optimizedResult) < 0.01 ? "✓ Yes" : "✗ No");
        System.out.println();
    }
    
    /**
     * Test forecasting from historical data
     */
    private static void testHistoricalForecasting() {
        FinancialData[] historicalData = RecursiveForecasting.generateSampleData();
        int forecastPeriods = 5;
        
        System.out.println("Forecasting from Historical Data:");
        System.out.println("-".repeat(50));
        
        double[] forecast = RecursiveForecasting.forecastFromHistoricalData(historicalData, forecastPeriods);
        double initialValue = historicalData[historicalData.length - 1].getValue();
        double avgGrowthRate = calculateAverageGrowthRate(historicalData);
        
        RecursiveForecasting.displayForecast(initialValue, avgGrowthRate, forecastPeriods, forecast);
    }
    
    /**
     * Test variable growth rate forecasting
     */
    private static void testVariableGrowthRates() {
        double initialValue = 10000.0;
        double[] growthRates = {5.0, 6.0, 4.5, 7.2, 3.8}; // Different rates for each period
        
        System.out.println("Forecasting with Variable Growth Rates:");
        System.out.println("-".repeat(50));
        
        System.out.printf("Initial Value: $%.2f%n", initialValue);
        System.out.println("Growth Rates by Period:");
        for (int i = 0; i < growthRates.length; i++) {
            System.out.printf("Period %d: %.2f%%%n", i + 1, growthRates[i]);
        }
        System.out.println();
        
        double result = RecursiveForecasting.forecastWithVariableRates(initialValue, growthRates, 0);
        System.out.printf("Final Value: $%.2f%n", result);
        System.out.printf("Total Growth: $%.2f (%.2f%%)%n", 
                         result - initialValue,
                         ((result - initialValue) / initialValue) * 100);
        System.out.println();
    }
    
    /**
     * Test finding periods to reach target value
     */
    private static void testTargetPeriods() {
        double initialValue = 10000.0;
        double targetValue = 15000.0;
        double growthRate = 5.0;
        
        System.out.println("Finding Periods to Reach Target:");
        System.out.println("-".repeat(50));
        
        System.out.printf("Initial Value: $%.2f%n", initialValue);
        System.out.printf("Target Value: $%.2f%n", targetValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate);
        System.out.println();
        
        int periods = RecursiveForecasting.findPeriodsToTarget(initialValue, targetValue, growthRate, 0);
        
        if (periods > 0) {
            System.out.printf("Periods needed: %d%n", periods);
            double finalValue = RecursiveForecasting.calculateFutureValueOptimized(initialValue, growthRate, periods);
            System.out.printf("Final Value: $%.2f%n", finalValue);
        } else {
            System.out.println("Target not reachable with current growth rate");
        }
        System.out.println();
    }
    
    /**
     * Analyze and compare the algorithms
     */
    private static void analyzeAlgorithms() {
        // Analyze Basic Recursion
        RecursionAnalysis.analyzeBasicRecursion();
        
        // Analyze Optimized Recursion
        RecursionAnalysis.analyzeOptimizedRecursion();
        
        // Compare approaches
        RecursionAnalysis.compareApproaches();
        
        // Explain optimization techniques
        RecursionAnalysis.explainOptimizationTechniques();
        
        // Demonstrate performance
        RecursionAnalysis.demonstratePerformance();
    }
    
    /**
     * Test advanced forecasting features
     */
    private static void testAdvancedFeatures() {
        // Test historical data forecasting
        testHistoricalForecasting();
        
        // Test variable growth rates
        testVariableGrowthRates();
        
        // Test target period finding
        testTargetPeriods();
        
        // Performance comparison with larger datasets
        System.out.println("Performance Comparison with Larger Datasets:");
        System.out.println("-".repeat(50));
        
        double initialValue = 10000.0;
        double growthRate = 5.0;
        
        for (int periods : new int[]{5, 10, 15, 20}) {
            long startTime = System.nanoTime();
            double result = RecursiveForecasting.calculateFutureValueOptimized(initialValue, growthRate, periods);
            long executionTime = System.nanoTime() - startTime;
            
            System.out.printf("Periods: %2d | Result: $%.2f | Time: %.3f ms | Cache: %d entries%n", 
                            periods, result, executionTime / 1_000_000.0, RecursiveForecasting.getCacheSize());
        }
        System.out.println();
        
        // Clear cache and show memory management
        System.out.println("Cache Management:");
        System.out.println("-".repeat(50));
        System.out.printf("Cache size before clearing: %d entries%n", RecursiveForecasting.getCacheSize());
        RecursiveForecasting.clearCache();
        System.out.printf("Cache size after clearing: %d entries%n", RecursiveForecasting.getCacheSize());
        System.out.println();
        
        // Provide recommendations
        RecursionAnalysis.provideRecommendations();
    }
} 