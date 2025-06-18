import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * FinancialData class representing a single financial data point
 * Contains date, value, and growth rate information for forecasting
 */
public class FinancialData {
    private LocalDate date;
    private double value;
    private double growthRate;
    
    /**
     * Constructor for FinancialData
     * @param date The date of the financial data point
     * @param value The financial value at this date
     * @param growthRate The growth rate (as a percentage, e.g., 5.0 for 5%)
     */
    public FinancialData(LocalDate date, double value, double growthRate) {
        this.date = date;
        this.value = value;
        this.growthRate = growthRate;
    }
    
    /**
     * Constructor with string date
     * @param dateStr Date string in "yyyy-MM-dd" format
     * @param value The financial value at this date
     * @param growthRate The growth rate (as a percentage)
     */
    public FinancialData(String dateStr, double value, double growthRate) {
        this.date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.value = value;
        this.growthRate = growthRate;
    }
    
    /**
     * Get the date
     * @return The date of the financial data point
     */
    public LocalDate getDate() {
        return date;
    }
    
    /**
     * Get the financial value
     * @return The financial value
     */
    public double getValue() {
        return value;
    }
    
    /**
     * Get the growth rate
     * @return The growth rate as a percentage
     */
    public double getGrowthRate() {
        return growthRate;
    }
    
    /**
     * Set the financial value
     * @param value New financial value
     */
    public void setValue(double value) {
        this.value = value;
    }
    
    /**
     * Set the growth rate
     * @param growthRate New growth rate as a percentage
     */
    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }
    
    /**
     * Calculate the growth factor (1 + growthRate/100)
     * @return The growth factor
     */
    public double getGrowthFactor() {
        return 1 + (growthRate / 100.0);
    }
    
    /**
     * Get the next value based on current growth rate
     * @return The projected next value
     */
    public double getNextValue() {
        return value * getGrowthFactor();
    }
    
    /**
     * String representation of the financial data
     * @return Formatted string
     */
    @Override
    public String toString() {
        return String.format("FinancialData{Date=%s, Value=%.2f, GrowthRate=%.2f%%}", 
                           date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
                           value, growthRate);
    }
    
    /**
     * Get a formatted string for display
     * @return Formatted display string
     */
    public String toDisplayString() {
        return String.format("%s | Value: $%.2f | Growth Rate: %.2f%%", 
                           date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
                           value, growthRate);
    }
} 