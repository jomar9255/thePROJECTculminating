/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package culminatingcannon;

import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class decisionMaker extends MathMethods{ 

    public double v1, v1x, v1y, v2, v2y, dx,
     dy, t, a, theta1, theta2;
    public int num;
    public String unknown;
    String[] varNameArray = {"v1","v1x","v1y","v2","v2y","dx","dy","t","a","theta1","theta2"};
    String[] knownVals;
    
    public decisionMaker(String unknownVar, int numVar, String[] varName, double[] varValue){
        
        //Set values for variables
        num = numVar;
        unknown = unknownVar;
        
        knownVals = new String[num];
        
        //Set all values in varName array to known vals array
        for(int i=0; i<varName.length; i++){
            varName[i] = knownVals[i];
        }
        
        //Set variable values *Ensure that values input by user go in this order in array
        varValue[0] = v1;
        varValue[1] = v1x;
        varValue[2] = v1y;
        varValue[3] = v2;
        varValue[4] = v2y;
        varValue[5] = dx;
        varValue[6] = dy;
        varValue[7] = t;
        varValue[8] = a;
        varValue[9] = theta1;
        varValue[10] = theta2;
        
    } 
    
    public void decisionStatements() {

        //System.out.println("Welcome to the Cannon of Physics! Here you can easily solve projectile motion problems!");
        //System.out.println("These are a list of variables you can input (Input short form):\nv1 - Initial Velocity\nv1x - Initial x Velocity\nv1y - Initial y Velocity\n"
        //+ "v2 - Final Velocity\ndx - Horizontal Displacement\ndy - Vertical Displacement\n"
        //+ "t - Time\na - Acceleration\ntheta1 - The initial angle of launch\ntheta2 - The final angle at impact");
        //System.out.println("Please input your givens one at a time and type 'done' when finished.");
        
                
        //For user input: Ask what they are trying to solve for (unkown)
        //How many pieces of information do you have (int)
        //Ask for the symbol for each variable they have (string)
        //Get the value for each variable (double)
        //Go through steps to determine which equation to use


        
        //Mega string to hold the ordered sequence of variables the user knows
        String megaString = ""; 
        
        //For loop the size of the array
        for(int i=0;i<knownVals.length;i++ ){
            //Add each element to the megastring
            megaString += knownVals[i];
        }

        
        //IF THE USER INPUTS MORE INFO THEN NEEDED WE COULD DO .CONTAINS TO CHECK IF THE MEGASTRING CONTAINS THE VARIABLES NEEDED EVEN IF IT HAS EXTRA
        if(unknown == "v1"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "theta1v1y": v1 = oppThetaOFhyp(v1y,theta1);
                break;
                case "theta1v1x": v1 = adjThetaOFhyp(v1x,theta1);
                break;
                case "v1xv1y": v1 = pythagFORHypotenuse(v1x,v1y);
                break;
                //Cant you find the initial velocity knowing v1x and v1y and theta
            }
        }
        else if(unknown == "v1x"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dxt":v1x = dxtOFv1x(dx,t) ;
                break;
                case "theta1v1y": v1x = oppThetaOFadj(v1y,theta1);
                break;
                case "theta2v2y": v1x = oppThetaOFadj(v2y,theta2);
                break;
                case "v1v1y": v1x = pythagFORSidelength(v1,v1y);
                break;
            }
        }
        else if(unknown == "v1y"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "adyt": v1y= dytaOFv1y(dy,t,a);
                break;
                case "atv2y": v1y=v2yatOFv1y(v2y,a,t);
                break;
                case "adyv2y": v1y=v2yadyOFv1y(v2y,a,dy);
                break;
                case "dytv2y": v1y=v2ydytOFv1y(v2y,dy,t);
                break;
                case "theta1v1x": v1y = adjThetaOFopp(v1x,theta1);
                break;
                case "v1v1x": v1y = pythagFORSidelength(v1,v1x);
                break;
            }
        }
        else if(unknown == "v2"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "theta2v2y": v2 = oppThetaOFhyp(v2y,theta2);
                break;
                case "theta2v1x": v2 = adjThetaOFhyp(v1x,theta2);
                break;
                case "v1xv2y": v2 = pythagFORHypotenuse(v1x,v2y);
                break;
            }
        }
        else if(unknown == "v2y"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "adyt": v2y=dytaOFv2y(dy,t,a);
                break;
                case "atv1y": v2y=v1yatOFv2y(v1y,a,t);
                break;
                case "adyv1y": v2y=v1yadyOFv2y(v1y,a,dy);
                break;
                case "dytv1y": v2y=v1ydytOFv2y(v1y,dy,t);
                break;
                case "theta2v1x": v2y = adjThetaOFopp(v1x,theta2);
                break;
                case "v1xv2": v2y = pythagFORSidelength(v2,v1y);
                break;
            }
        }
        else if(unknown == "dx"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "tv1x": dx = tv1xOFdx(t,v1x);
                break;
            }
        }
        else if(unknown == "dy"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "atv1y": dy=v1ytaOFdy(v1y,t,a);
                break;
                case "atv2y": dy=v2ytaOFdy(v2y,t,a);
                break;
                case "av1yv2y": dy=v1yv2yaOFdy(v1y,v2y,a);
                break;
                case "tv1yv2y": dy=v1yv2ytOFdy(v1y,v2y,t);
                break;
            }
        }
        else if(unknown == "t"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dxv1x": t=dxv1xOFt(dx,v1x);
                break;
                case "adyv1y": t=dyv1yaOFt(dy,a,v1y);
                break;
                case "adyv2y": t=dyv2yaOFt(dy,v2y,a);
                break;
                case "av1yv2y": t=v1yv2yaOFt(v1y,v2y,a);
                break;
                case "dyv1yv2y": t=v1yv2ydyOFt(v1y,v2y,dy);
                break;
            }
        }
        else if(unknown == "a"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dytv1y": a=dyv1ytOFa(dy,t,v1y);
                break;
                case "dytv2y": a=dyv2ytOFa(dy,v2y,t);
                break;
                case "tv1yv2y": a=v1yv2ytOFa(v1y,v2y,t);
                break;
                case "dyv1yv2y": a=v1yv2ydyOFa(v1y,v2y,dy);
                break;
            }
        }
        else if(unknown == "theta1"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "v1xv1y": theta1=oppAdjOFtheta(v1x,v1y);
                break;
                case "v1yv1": theta1 = oppHypOFtheta(v1y,v1);
                break;
                case "v1xv1": theta1 = adjThetaOFhyp(v1x,v1);
                break;
            }
        }
        else if(unknown == "theta2"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "v1xv2y": theta2=oppAdjOFtheta(v1x,v2y);
                break;
                case "v2yv2": theta2 = oppHypOFtheta(v2y,v2);
                break;
                case "v1xv2": theta2 = adjThetaOFhyp(v1x,v2);
                break;
            }
        }
        else{ // JOSH PUTS STUFF HERE
            //Implement a solution here for multistep problems ie. Cannot solve for unknown directly
        }
    }
}