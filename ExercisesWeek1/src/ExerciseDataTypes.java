public class ExerciseDataTypes {
    public static void main(String[] args) {
        // Sports Statistics
        String playerName = "Lionel Messi";
        int jerseyNumber = 10;
        String position = "Forward";
        boolean isStarter = true;
        String teamName = "Inter Miami CF";

        if (isStarter) {
            System.out.println("Soccer Player: " + playerName + " wears jersey number " + jerseyNumber +
                    " and he plays as " + position + ".");

        } else {
            System.out.println(" Here comes " + playerName + " from the sidelines for " + teamName + ".");

        }
        jerseyNumber = 30;
        isStarter = false;

        if (isStarter) {
            System.out.println("\nAthlete update: " + playerName + " now wears jersey number " + jerseyNumber + " and is a starter.");
        } else {
            System.out.println("\nAthlete update: " + playerName + " now wears jersey number " + jerseyNumber + " and is not a starter.");
        }


        //Movie Information
        String movieTitle = "The Fifth Element";
        int releaseYear = 1997;
        String rating = "PG-13";
        boolean isSequel = false;
        String leadActor = "Bruce Willis";


        System.out.println("\nThe movie, " + movieTitle +  " stars " + leadActor  + " and was released in the year "
                + releaseYear + ", and it is rated " + rating + ".");

        if (isSequel) {
            System.out.println(movieTitle + " is a sequel.");
        } else {
            System.out.println(movieTitle + " is not a sequel.");
        }
        rating = "R";
        isSequel = true;

        System.out.println("\nMovie update: " + movieTitle + " is now rated " + rating + ".");
        if (isSequel) {
            System.out.println("\nMovie update: " + movieTitle + " is now a sequel, due to a prequel moive in the works.");
        }


        // Weather Report
        String cityName = "Austin";
        double temperature = 80.5;
        boolean isRaining = true;
        int humidity = 67;
        String weatherCondition = "cloudy";

        System.out.println("\nWeather report: " + cityName + " has a temperature of " + temperature + "°F, with a humidity of "
                + humidity + " and " + weatherCondition + " skies.");

        if (isRaining) {
            System.out.println("Be sure to take that umbrella with you!");
        }

        temperature = 100;
        weatherCondition = "sunny";
        System.out.println("\nWeather update: it is now " + temperature + "°F and " + weatherCondition + ".");


        // Flight Information
        String flightNumber = "AA256";
        String departureCity = "New York";
        String arrivalCity = "Los Angeles";
        String gateNumber = "B12";
        int terminal = 43;
        boolean isDelayed = false;

        System.out.println("Flight " + flightNumber + " from " + departureCity + " to " + arrivalCity + " is ready to board at gate "
                 + gateNumber + ", Terminal: " + terminal);

        if (isDelayed) {
            System.out.println("The flight is delayed.");
        } else {
            System.out.println("The flight is on time.");

        }
        gateNumber = "C25";
        isDelayed = true;

        System.out.println("\nFlight update:");
        System.out.println("Gate changed to " + gateNumber + ".");
        if (isDelayed) {
            System.out.println("The flight is now delayed.");

        }
        // Boolean Variables
        boolean hasHomework = true;
        boolean isWeekend = false;
        boolean attendedClass = true;

        System.out.println("\nDo I have homework? " + hasHomework);
        if (hasHomework) {
            System.out.println("Yes, I have homework.");
        } else {
            System.out.println("No, I don't have any homework.");
        }

        System.out.println("\nIs it the weekend? " + isWeekend);
        if (isWeekend) {
            System.out.println("Huzzah! It's the weekend!");
        } else {
            System.out.println("Nope, it's a weekday.");
        }

        System.out.println("\nDid I attend class today? " + attendedClass);
        if (attendedClass) {
            System.out.println("Yes, I attended class today.");
        } else {
            System.out.println("No, I did not attend class today.");
        }
        char firstInitial = 'M';
        char lastInitial = 'B';
        char favoriteGrade = 'A';

        System.out.println("\nMy first name starts with a " + firstInitial + ", my last name starts with a " + lastInitial +
                ", and my favorite grade is an " + favoriteGrade + ".");

    }
}