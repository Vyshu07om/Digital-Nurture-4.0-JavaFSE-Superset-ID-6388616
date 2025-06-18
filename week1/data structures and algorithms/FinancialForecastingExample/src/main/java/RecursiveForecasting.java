import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * RecursiveForecasting class implementing recursive algorithms for financial forecasting
 * Demonstrates both basic recursive and optimized (memoized) approaches
 */
public class RecursiveForecasting {
    
    // Cache for memoization to avoid excessive computation
    private static Map<String, Double> forecastCache = new HashMap<>();
    
    /**
     * Basic recursive method to calculate future value
     * Time Complexity: O(2^n) - Exponential due to repeated calculations
     * Space Complexity: O(n) - Stack space for recursion depth
     * 
     * @param currentValue Current financial value
     * @param growthRate Growth rate as percentage (e.g., 5.0 for 5%)
     * @param periods Number of periods to forecast
     * @return Future value after specified periods
     */
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int periods) {
        // Base case: if no periods left, return current value
        if (periods <= 0) {
            return currentValue;
        }
        
        // Recursive case: calculate growth for one period, then recurse
        double growthFactor = 1 + (growthRate / 100.0);
        double nextValue = currentValue * growthFactor;
        
        // Recursive call for remaining periods
        return calculateFutureValueRecursive(nextValue, growthRate, periods - 1);
    }
    
    /**
     * Optimized recursive method using memoization
     * Time Complexity: O(n) - Linear due to caching
     * Space Complexity: O(n) - Cache space + stack space
     * 
     * @param currentValue Current financial value
     * @param growthRate Growth rate as percentage
     * @param periods Number of periods to forecast
     * @return Future value after specified periods
     */
    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int periods) {
        // Create cache key for memoization
        String cacheKey = String.format("%.2f_%.2f_%d", currentValue, growthRate, periods);
        
        // Check if result is already cached
        if (forecastCache.containsKey(cacheKey)) {
            return forecastCache.get(cacheKey);
        }
        
        // Base case: if no periods left, return current value
        if (periods <= 0) {
            forecastCache.put(cacheKey, currentValue);
            return currentValue;
        }
        
        // Recursive case: calculate growth for one period, then recurse
        double growthFactor = 1 + (growthRate / 100.0);
        double nextValue = currentValue * growthFactor;
        
        // Recursive call for remaining periods
        double result = calculateFutureValueOptimized(nextValue, growthRate, periods - 1);
        
        // Cache the result
        forecastCache.put(cacheKey, result);
        return result;
    }
    
    /**
     * Recursive method to forecast based on historical data
     * Uses average growth rate from historical data
     * 
     * @param historicalData Array of historical financial data
     * @param periods Number of periods to forecast
     * @return Array of forecasted values
     */
    public static double[] forecastFromHistoricalData(FinancialData[] historicalData, int periods) {
        if (historicalData == null || historicalData.length < 2) {
            throw new IllegalArgumentException("Need at least 2 historical data points");
        }
        
        // Calculate average growth rate from historical data
        double avgGrowthRate = calculateAverageGrowthRate(historicalData);
        
        // Get the most recent value
        double currentValue = historicalData[historicalData.length - 1].getValue();
        
        // Generate forecast using optimized recursive method
        double[] forecast = new double[periods];
        for (int i = 0; i < periods; i++) {
            forecast[i] = calculateFutureValueOptimized(currentValue, avgGrowthRate, i + 1);
        }
        
        return forecast;
    }
    
    /**
     * Calculate average growth rate from historical data
     * 
     * @param historicalData Array of historical financial data
     * @return Average growth rate as percentage
     */
    private static double calculateAverageGrowthRate(FinancialData[] historicalData) {
        double totalGrowthRate = 0;
        int count = 0;
        
        for (int i = 1; i < historicalData.length; i++) {
            double previousValue = historicalData[i - 1].getValue();
            double currentValue = historicalData[i].getValue();
            
            if (previousValue > 0) {
                double growthRate = ((currentValue - previousValue) / previousValue) * 100;
                totalGrowthRate += growthRate;
                count++;
            }
        }
        
        return count > 0 ? totalGrowthRate / count : 0;
    }
    
    /**
     * Recursive method to forecast with variable growth rates
     * Each period can have a different growth rate
     * 
     * @param currentValue Current financial value
     * @param growthRates Array of growth rates for each period
     * @param currentPeriod Current period index (used for recursion)
     * @return Future value after all periods
     */
    public static double forecastWithVariableRates(double currentValue, double[] growthRates, int currentPeriod) {
        // Base case: if we've processed all periods, return current value
        if (currentPeriod >= growthRates.length) {
            return currentValue;
        }
        
        // Calculate growth for current period
        double growthFactor = 1 + (growthRates[currentPeriod] / 100.0);
        double nextValue = currentValue * growthFactor;
        
        // Recursive call for next period
        return forecastWithVariableRates(nextValue, growthRates, currentPeriod + 1);
    }
    
    /**
     * Recursive method to find the number of periods needed to reach a target value
     * 
     * @param currentValue Current financial value
     * @param targetValue Target value to reach
     * @param growthRate Growth rate as percentage
     * @param currentPeriod Current period (used for recursion)
     * @return Number of periods needed to reach target, or -1 if not reachable
     */
    public static int findPeriodsToTarget(double currentValue, double targetValue, double growthRate, int currentPeriod) {
        // Base case: if we've reached or exceeded target, return current period
        if (currentValue >= targetValue) {
            return currentPeriod;
        }
        
        // Base case: if growth rate is negative or zero and we haven't reached target
        if (growthRate <= 0 && currentValue < targetValue) {
            return -1; // Target not reachable
        }
        
        // Calculate next value
        double growthFactor = 1 + (growthRate / 100.0);
        double nextValue = currentValue * growthFactor;
        
        // Recursive call for next period
        return findPeriodsToTarget(nextValue, targetValue, growthRate, currentPeriod + 1);
    }
    
    /**
     * Clear the forecast cache
     * Useful for memory management in long-running applications
     */
    public static void clearCache() {
        forecastCache.clear();
    }
    
    /**
     * Get cache statistics
     * @return Number of cached entries
     */
    public static int getCacheSize() {
        return forecastCache.size();
    }
    
    /**
     * Generate sample historical data for testing
     * @return Array of sample financial data
     */
    public static FinancialData[] generateSampleData() {
        return new FinancialData[] {
            new FinancialData("2023-01-01", 10000.0, 5.0),
            new FinancialData("2023-02-01", 10500.0, 4.5),
            new FinancialData("2023-03-01", 10972.5, 6.2),
            new FinancialData("2023-04-01", 11652.8, 3.8),
            new FinancialData("2023-05-01", 12095.6, 5.5),
            new FinancialData("2023-06-01", 12760.9, 4.2)
        };
    }
    
    /**
     * Display forecast results in a formatted way
     * @param initialValue Initial value
     * @param growthRate Growth rate
     * @param periods Number of periods
     * @param forecastValues Array of forecasted values
     */
    public static void displayForecast(double initialValue, double growthRate, int periods, double[] forecastValues) {
        System.out.println("\n=== FINANCIAL FORECAST RESULTS ===");
        System.out.printf("Initial Value: $%.2f%n", initialValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate);
        System.out.printf("Forecast Periods: %d%n", periods);
        System.out.println();
        
        System.out.println("Period | Forecasted Value | Growth");
        System.out.println("-------|------------------|--------");
        
        for (int i = 0; i < forecastValues.length; i++) {
            double growth = i == 0 ? forecastValues[i] - initialValue : forecastValues[i] - forecastValues[i-1];
            System.out.printf("%6d | $%15.2f | $%8.2f%n", i + 1, forecastValues[i], growth);
        }
        
        System.out.println();
        System.out.printf("Total Growth: $%.2f (%.2f%%)%n", 
                         forecastValues[forecastValues.length - 1] - initialValue,
                         ((forecastValues[forecastValues.length - 1] - initialValue) / initialValue) * 100);
    }
} 