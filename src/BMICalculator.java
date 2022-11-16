

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Coverts and calculates user's BMI based on height and weight
 * @version 22.11.16
 * @author Amelia Kazcarmyk
 */
public class BMICalculator {
    /** Convert English to Metric units, perform the BMI calculation
     * NOTE: this method must properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return User's BMI, expressed as weight(kg)/height(m)^2: 24.43 kg/m^2
     */
    public static double computeBMI(int inches, int pounds){
        double kgs, meters;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        if(kgs > 0 && meters > 0){
            return kgs / Math.pow(meters, 2);
        }
        return 0.0;
    }
    /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information. */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches = 0, pounds = 0;
        while(true){
            System.out.print("Enter your height in feet and inches (Ex 6'1\"): 5'11\" ");
            userin = in.nextLine();
            if(userin.equals("0")){
                break;
            }
            try {
                //sanitize height and convert to inches
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12 + Integer.parseInt(userin.substring(userin.indexOf("'")+1,userin.indexOf(("\""))));
                //System.out.println(inches);
                System.out.print("Enter your weight, in pounds ");
                userin = in.nextLine();
                pounds = Integer.parseInt(userin);
                break;
            }
            catch(Exception e){
                System.out.println("There was an error, see here: " + e);
            }
        }
        DecimalFormat df = new DecimalFormat("00.00");

        System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)) + "kg/m^2");
    }
}