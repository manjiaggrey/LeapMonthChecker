import java.util.Scanner;

public class LeapMonthChecker {
    
    // Declare variables
    private int year;
    private int month;
    private boolean isLeapMonth;
    
    // Constructor
    public LeapMonthChecker() {
        this.year = 0;
        this.month = 0;
        this.isLeapMonth = false;
    }
    
    // Method to check if a month is a leap month
    public boolean checkLeapMonth(int year, int month) {
        // Based on the Boolean expressions given:
        // isLeapMonth = (year % 4 == 0)
        // isLeapMonth = isLeapMonth && (month % 100 != 0)
        // isLeapMonth = isLeapMonth || (month % 400 == 0)
        
        boolean isLeapMonth;
        
        // Step 1: Check if year divisible by 4
        isLeapMonth = (year % 4 == 0);
        
        // Step 2: But not divisible by 100
        isLeapMonth = isLeapMonth && (year % 100 != 0);
        
        // Step 3: Unless divisible by 400
        isLeapMonth = isLeapMonth || (year % 400 == 0);
        
        return isLeapMonth;
    }
    
    // Method to get user input and display result
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== LEAP MONTH CHECKER ===");
        System.out.println("(A month is a leap month if February has 29 days)");
        System.out.println();
        
        try {
            // Get year input
            System.out.print("Enter year (e.g., 2024): ");
            year = scanner.nextInt();
            
            // Validate year
            if (year < 1) {
                System.out.println("Error: Year must be positive!");
                return;
            }
            
            // Check if it's a leap month (February in leap year)
            isLeapMonth = checkLeapMonth(year, 2); // Check February
            
            // Display result
            System.out.println("\n=== RESULT ===");
            System.out.println("Year: " + year);
            
            if (isLeapMonth) {
                System.out.println(year + " is a leap year.");
                System.out.println("Therefore, February " + year + " is a LEAP MONTH (has 29 days).");
            } else {
                System.out.println(year + " is NOT a leap year.");
                System.out.println("Therefore, February " + year + " is NOT a leap month (has 28 days).");
            }
            
            // Show the calculation steps
            System.out.println("\n=== CALCULATION STEPS ===");
            System.out.println("Step 1: Divisible by 4? " + (year % 4 == 0));
            System.out.println("Step 2: Not divisible by 100? " + (year % 100 != 0));
            System.out.println("Step 3: Divisible by 400? " + (year % 400 == 0));
            System.out.println("Final result: " + isLeapMonth);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter a valid year.");
        } finally {
            scanner.close();
        }
    }
    
    // Alternative method: Check any month (not just February)
    public boolean checkAnyMonth(int year, int month) {
        // First check if it's a leap year
        boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
        
        // Then check if the month is February (month 2)
        return (month == 2) && isLeapYear;
    }
    
    // Main method
    public static void main(String[] args) {
        LeapMonthChecker checker = new LeapMonthChecker();
        checker.run();
        
        // Test with multiple years
        System.out.println("\n=== TESTING MULTIPLE YEARS ===");
        int[] testYears = {2024, 2025, 1900, 2000, 2023, 2028};
        
        for (int year : testYears) {
            boolean result = checker.checkLeapMonth(year, 2);
            System.out.println(year + ": " + (result ? "Leap month ✓" : "Not leap month ✗"));
        }
    }
}
