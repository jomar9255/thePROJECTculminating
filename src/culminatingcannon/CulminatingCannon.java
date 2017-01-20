
package culminatingcannon;

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
        
        double solution;
        String unknownVar = "";
        int numVar = 0;
        double v1, v1x, v1y, v2, v2y, dx, dy, t, a, theta1, theta2;
        String varName = "";
        //double[] varValue = new double[numVar];
        double[] varValue = {0,10,0,0,5,0,0,0,0,0,0};
        
        unknownVar = "v2";
        numVar = 2;
        varName = "v1xv2y";

        //In GUI the user will input info in alphabetical order and each variable they
        //are using will be added to a megastring

        decisionMaker awnser = new decisionMaker(unknownVar, numVar, varName, varValue);
        
        solution = awnser.decisionStatements();
        
        System.out.println(solution);
                
    } 
}
