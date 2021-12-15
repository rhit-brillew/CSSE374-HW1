public class TaxCalculator {

    public static double calculateBasedOnLocation(String state) {
        switch (state) {
            case "California":
                return 0.0725;
            case "Tennessee":
            case "Rhode Island":
            case "Mississippi":
            case "Indiana":
                return 0.0700;
            case "Minnesota":
                return 0.0688;
            case "Nevada":
                return 0.0685;
            case "New Jersey":
                return 0.0663;
            case "Washington":
            case "Arkansas":
            case "Kansas":
                return 0.0650;
            case "Connecticut":
                return 0.0635;
            case "Texas":
            case "Massachusetts":
            case "Illinois":
                return 0.0625;
            case "West Virginia":
            case "Vermont":
            case "South Carolina":
            case "Pennsylvania":
            case "Michigan":
            case "Maryland":
            case "Kentucky":
            case "Iowa":
            case "Idaho":
            case "Florida":
                return 0.0600;
            case "Utah":
                return 0.0595;
            case "Ohio":
                return 0.0575;
            case "Arizona":
            case "Maine":
                return 0.0550;
            case "Virginia":
                return 0.0530;
            case "New Mexico":
                return 0.0513;
            case "Wisconsin":
            case "North Dakota":
                return 0.0500;
            case "North Carolina":
                return 0.0475;
            case "South Dakota":
            case "Oklahoma":
                return 0.0450;
            case "Louisiana":
                return 0.0445;
            case "Missouri":
                return 0.0423;
            case "Wyoming":
            case "New York":
            case "Hawaii":
            case "Georgia":
            case "Alabama":
                return 0.0400;
            case "Colorado":
                return 0.0290;
            case "Oregon":
            case "New Hampshire":
            case "Montana":
            case "Delaware":
            case "Alaska":
                return 0.000;
        }
        return 0;
    }

}
