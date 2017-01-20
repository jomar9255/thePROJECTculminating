
package culminatingcannon;

import java.text.DecimalFormat;

/**
 *
 * @author wipri9236
 */
public class CulminatingCannon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // DECLARATIONS / INITIALZATIONS
        
        //Decimal Format to give awnser to two decimal places
        DecimalFormat x = new DecimalFormat("##.##");
        
        //Declare variables
        int numVar = 0;
        double v1, v1x, v1y, v2, v2y, dx, dy, t, a, theta1, theta2, solution;
        String unknownVar = "", varName = "";
        
        //Array holding the users variable values with each index corresponding to a specific variable
        //double[] varValue = new double[numVar];
        
        //Testing
        double[] varValue = {0,10,0,0,5,0,0,0,0,0,0};
        unknownVar = "v2";
        numVar = 2;
        varName = "v1xv2y";

        //In GUI the user will input info in alphabetical order and each variable they
        //are using will be added to a megastring

        //Create a new decisionmaker object called awnser
        //Input the users unknown and known variables, the number of variables, and the value of all of them
        decisionMaker awnser = new decisionMaker(unknownVar, numVar, varName, varValue);
        
        //Find the users unknown variable and store in solution var
        solution = awnser.decisionStatements();
        
        //Output the users solution
        System.out.println(x.format(solution));
                
    }
    

}
