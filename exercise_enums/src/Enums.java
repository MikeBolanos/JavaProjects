public class Enums {
    // Coffee sizes enum
    enum CoffeeSizes {
        SMALL,
        MEDIUM,
        LARGE
    }

    // Seat sections enum
    enum SeatSection {
        GENERAL,
        PREMIUM,
        VIP
    }

    // Traffic light enum
    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
    }

    // Weekday enum
    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    //Emergency alert enum
    enum AlertLevel {
        LOW,
        MODERATE,
        HIGH,
        SEVERE
    }

    public static void main(String[] args) {

        // Using enum variables
        CoffeeSizes size = CoffeeSizes.LARGE;
        System.out.println("\nSelected coffee size: " + size);

        // Convert enum to Integer Values
        SeatSection sectionGen = SeatSection.GENERAL;
        System.out.println("\nGENERAL is assigned value: " + sectionGen.ordinal());

        SeatSection sectionPrem = SeatSection.PREMIUM;
        System.out.println("Premium is assigned value: " + sectionPrem.ordinal());

        SeatSection sectionVip = SeatSection.VIP;
        System.out.println("VIP is assigned value: " + sectionVip.ordinal());


        //Convert integer to enum
        TrafficLight[] lights = TrafficLight.values();
        System.out.println("\nTraffic light signal: " + lights[1]);

        //Declare workday
        Weekday workday = Weekday.WEDNESDAY;

        //Check if Workday falls on a weekend
        System.out.println("\nWorkday selected: " + workday);
        if (workday == Weekday.SATURDAY || workday == Weekday.SUNDAY) {
            System.out.println("Is it a weekend?: True");
        } else {
            System.out.println("Is it a weekend? False");

            //Emergency alert system
            AlertLevel currentAlert = AlertLevel.HIGH;
            System.out.println("\nCurrent alert level: " + currentAlert);

            switch (currentAlert) {
                case LOW:
                    System.out.println("No immediate danger.");
                    break;
                case MODERATE:
                    System.out.println("Stay alert and aware.");
                    break;
                case HIGH:
                    System.out.println("Take precautions and stay informed.");
                    break;
                case SEVERE:
                    System.out.println("Immediate action required!");
                    break;


            }

        }
    }

}
