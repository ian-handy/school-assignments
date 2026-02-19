//Ian Handy 9/29/25
import java.util.*;

public class cyclone {

    public static void main(String[] args) {

        //Delcare scanner
        Scanner scanner = new Scanner(System.in);

        //Prompt to get windSpeed
        System.out.println("Please enter the maximum sustained wind speed:");
        double windSpeed = Math.abs(scanner.nextDouble());

        //Prompt to get maxGust
        System.out.println("Please enter the maximum wind gusts:");
        double maxGust = Math.abs(scanner.nextDouble());

        //Change maxGust to 1 if user entered 0
        if (maxGust == 0) {maxGust++;}

        //Prompt to get level of detail
        System.out.println("Please enter how detailed you would like the response to be (Levels: 1, 2, or 3):");
        int lod = scanner.nextInt();

        //Close scanner
        scanner.close();

        //Define windSpeed categories
        String[] windArray = {
            "Tropical Depression",
            "Tropical Storm",
            "Category 1 Hurricane",
            "Category 2 Hurricane",
            "Category 3 Hurricane",
            "Category 4 Hurricane",
            "Category 5 Hurricane"
        };

        //Define maxGust categories
        String[] gustArray = {
            "Steady",
            "Turbulent",
            "Chaotic"
        };

        //Define cyclone facts
        String[] factArray = {
            "Katrina (2005) was the most costly hurricane on record causing an estimated $108 billion in damage in Louisiana and Mississippi. It also caused an estimated 1500 deaths.",
            "Sandy (2012) was the second most costly hurricane on record causing $71 billion in damage on the eastern seaboard of the USA.",
            "Andrew (1992) was a Category 5 hurricane which hit south-east Florida and south-east Louisiana causing $26.5 billion of damage",
            "Cyclone Tracy (1974) was a small but intense cyclone which struck the Australian city of Darwin destroying most of the city's buildings and causing many deaths.",
            "The most deadly tropical cyclone ever recorded hit Bangladesh in 1970 killing approximately 300,000 people as a result of the storm surge.",
            "Typhoon Haiyan (2013) was a category 5 typhoon with 1-minute average winds of 195 m.p.h. It hit the central Philippines.",
            "Patricia (2015) was a Category 5 hurricane in the eastern North Pacific with 1-minute average winds of 215 m.p.h. and a central pressure of 872 mb. It was the strongest recorded tropical cyclone in the western hemisphere.",
        };

        //Determine category of windspeed
        String windCat = windArray[0];

        if (windSpeed>=38&&windSpeed<74) {windCat = windArray[1];}
        if (windSpeed>=74&&windSpeed<96) {windCat = windArray[2];}
        if (windSpeed>=96&&windSpeed<111) {windCat = windArray[3];}
        if (windSpeed>=111&&windSpeed<130) {windCat = windArray[4];}
        if (windSpeed>=130&&windSpeed<157) {windCat = windArray[5];}
        if (windSpeed>=157) {windCat = windArray[6];}

        //Calculate gustPercent
        double gustPercent = maxGust/windSpeed;

        //Determine category of gustPercent
        String gustCat = gustArray[0];

        if (gustPercent>=1.1) {gustCat = gustArray[1];}
        if (gustPercent>=1.2) {gustCat = gustArray[2];}

        //Check which level of detail to use and return calculated results
        switch (lod) {
            case 1:
                System.out.println(windCat);
                break;
            case 2:
                System.out.println(gustCat + " " + windCat);
                break;
            case 3:
                Random random = new Random();
                System.out.println(gustCat + " " + windCat + "\n" + factArray[random.nextInt(7)]);
                break;
            default:
                System.out.println("Invalid level of detail. Aborting.");
                break;
        }

    }
}
