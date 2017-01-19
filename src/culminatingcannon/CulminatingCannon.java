
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
        

        String unknownVar = "";
        int numVar = 0;
        double v1, v1x, v1y, v2, v2y, dx, dy, t, a, theta1, theta2;
        String[] varName = new String[numVar];
        double[] varValue = new double[numVar];

        decisionMaker awnser = new decisionMaker(unknownVar, numVar, varName, varValue);
        
        awnser.decisionStatements();
                
    } 
}
