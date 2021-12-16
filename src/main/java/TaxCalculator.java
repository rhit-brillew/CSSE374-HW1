public class TaxCalculator {

    public static double calculateBasedOnLocation(String state, double totalItemCost) {
        double taxRate = 0;
        switch (state) {
            case "California":
                taxRate = 0.0725;
                break;
            case "Tennessee":
            case "Rhode Island":
            case "Mississippi":
            case "Indiana":
                taxRate = 0.0700;
                break;
            case "Minnesota":
                taxRate = 0.0688;
                break;
            case "Nevada":
                taxRate = 0.0685;
                break;
            case "New Jersey":
                taxRate = 0.0663;
                break;
            case "Washington":
            case "Arkansas":
            case "Kansas":
                taxRate = 0.0650;
                break;
            case "Connecticut":
                taxRate = 0.0635;
                break;
            case "Texas":
            case "Massachusetts":
            case "Illinois":
                taxRate = 0.0625;
                break;
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
                taxRate = 0.0600;
                break;
            case "Utah":
                taxRate = 0.0595;
                break;
            case "Ohio":
                taxRate = 0.0575;
                break;
            case "Arizona":
            case "Maine":
                taxRate = .0550;
                break;
            case "Virginia":
                taxRate = 0.0530;
                break;
            case "New Mexico":
                taxRate = 0.0513;
                break;
            case "Wisconsin":
            case "North Dakota":
                taxRate = 0.0500;
                break;
            case "North Carolina":
                taxRate = 0.0475;
                break;
            case "South Dakota":
            case "Oklahoma":
                taxRate = 0.0450;
                break;
            case "Louisiana":
                taxRate = 0.0445;
                break;
            case "Missouri":
                taxRate = 0.0423;
                break;
            case "Wyoming":
            case "New York":
            case "Hawaii":
            case "Georgia":
            case "Alabama":
                taxRate = 0.0400;
                break;
            case "Colorado":
                taxRate = 0.0290;
                break;
            case "Oregon":
            case "New Hampshire":
            case "Montana":
            case "Delaware":
            case "Alaska":
                taxRate = 0.000;
        }
        return totalItemCost * taxRate;
    }

}
