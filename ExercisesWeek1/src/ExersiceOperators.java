public class ExersiceOperators {
    public static void main(String[] args) {

        // Finance - Loan Payment Calculator
        double loanAmount = 25000.00; // in dollars
        double annualInterestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayment;

        // Calculate Monthly Payment
        monthlyPayment = (loanAmount * (annualInterestRate / 100)) / 12;

        // Use Assignment Operators
        loanAmount += 5000;
        annualInterestRate -= 1.0;
        loanTermYears++;


        // Use Comparison Operators
        boolean exceeds30000 = loanAmount > 30000;
        boolean paymentOver500 = monthlyPayment > 500;

        System.out.println("\n--- Comparisons ---");
        System.out.println("Does the loan amount exceed $30,000? " + exceeds30000);
        System.out.println("Is the monthly payment more than $500? " + paymentOver500);

        // Use Logical Operators
        boolean isAffordable = (monthlyPayment < 500) && (loanTermYears > 3);
        boolean isExpensive = (monthlyPayment > 700) || (annualInterestRate > 6);

        System.out.println("\n--- Loan Evaluation ---");
        System.out.println("Is the loan affordable? " + isAffordable);
        System.out.println("Is the loan expensive? " + isExpensive);

        // Weather - Temperature Conversion & Forecast Analysis
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

        // Convert Celsius to Fahrenheit
        double temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;

        // Step 2: Assignment Operators
        temperatureCelsius += 5;
        windSpeedKmh += 5;

        System.out.println("\n--- Updated Weather ---");
        System.out.println("Temperature: " + temperatureCelsius + "°C (" + temperatureFahrenheit + "°F)");
        System.out.println("Wind Speed: " + windSpeedKmh + " km/h");

        // Step 3: Comparison Operators
        boolean isHot = temperatureFahrenheit > 85;
        boolean isWindy = windSpeedKmh > 20;

        System.out.println("\n--- Comparisons ---");
        System.out.println("Is it hot (over 85°F)? " + isHot);
        System.out.println("Is it windy (over 20 km/h)? " + isWindy);

        // Step 4: Logical Operators
        boolean notRaining = !isRaining;
        boolean tempIsComfortable = temperatureFahrenheit >= 60 && temperatureFahrenheit <= 85;
        boolean goodDayOutside = notRaining && tempIsComfortable;

        boolean windTooHigh = windSpeedKmh > 30;
        boolean freezingTemp = temperatureCelsius < 0;
        boolean weatherWarning = windTooHigh || freezingTemp;

       


    }
}
