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
    public double awnser;
    public int num;
    public String unknown, megaString;
    String[] varNameArray = {"v1","v1x","v1y","v2","v2y","dx","dy","t","a","theta1","theta2"};
    
    
    public decisionMaker(String unknownVar, int numVar, String varName, double[] varValue){
        
        //Set values for variables
        num = numVar;
        unknown = unknownVar;
        megaString = varName;
        
        //Set variable values *Ensure that values input by user go in this order in array
        v1 = varValue[0];
        v1x = varValue[1];
        v1y = varValue[2];
        v2 = varValue[3];
        v2y = varValue[4];
        dx = varValue[5];
        dy = varValue[6];
        t = varValue[7];
        a = varValue[8];
        theta1 = varValue[9];
        theta2 = varValue[10];

    } 
    
    public double decisionStatements() {

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

        //IF THE USER INPUTS MORE INFO THEN NEEDED WE COULD DO .CONTAINS TO CHECK IF THE MEGASTRING CONTAINS THE VARIABLES NEEDED EVEN IF IT HAS EXTRA
        if(unknown == "v1"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "theta1v1y": awnser = oppThetaOFhyp(v1y,theta1);
                break;
                case "theta1v1x": awnser = adjThetaOFhyp(v1x,theta1);
                break;
                case "v1xv1y": awnser = pythagFORHypotenuse(v1x,v1y);
                break;
                //Cant you find the initial velocity knowing v1x and v1y and theta
            }
        }
        else if(unknown == "v1x"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dxt": awnser = dxtOFv1x(dx,t) ;
                break;
                case "theta1v1y": awnser = oppThetaOFadj(v1y,theta1);
                break;
                case "theta2v2y": awnser = oppThetaOFadj(v2y,theta2);
                break;
                case "v1v1y": awnser = pythagFORSidelength(v1,v1y);
                break;
            }
        }
        else if(unknown == "v1y"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "adyt": awnser = dytaOFv1y(dy,t,a);
                break;
                case "atv2y": awnser =v2yatOFv1y(v2y,a,t);
                break;
                case "adyv2y": awnser=v2yadyOFv1y(v2y,a,dy);
                break;
                case "dytv2y": awnser=v2ydytOFv1y(v2y,dy,t);
                break;
                case "theta1v1x": awnser = adjThetaOFopp(v1x,theta1);
                break;
                case "v1v1x": awnser = pythagFORSidelength(v1,v1x);
                break;
            }
        }
        else if(unknown == "v2"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "theta2v2y": awnser = oppThetaOFhyp(v2y,theta2);
                break;
                case "theta2v1x": awnser = adjThetaOFhyp(v1x,theta2);
                break;
                case "v1xv2y": awnser = pythagFORHypotenuse(v1x,v2y);
                break;
            }
        }
        else if(unknown == "v2y"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "adyt": awnser =dytaOFv2y(dy,t,a);
                break;
                case "atv1y": awnser =v1yatOFv2y(v1y,a,t);
                break;
                case "adyv1y": awnser =v1yadyOFv2y(v1y,a,dy);
                break;
                case "dytv1y": awnser=v1ydytOFv2y(v1y,dy,t);
                break;
                case "theta2v1x": awnser = adjThetaOFopp(v1x,theta2);
                break;
                case "v1xv2": awnser = pythagFORSidelength(v2,v1y);
                break;
            }
        }
        else if(unknown == "dx"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "tv1x": awnser = tv1xOFdx(t,v1x);
                break;
            }
        }
        else if(unknown == "dy"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "atv1y": awnser=v1ytaOFdy(v1y,t,a);
                break;
                case "atv2y": awnser=v2ytaOFdy(v2y,t,a);
                break;
                case "av1yv2y": awnser=v1yv2yaOFdy(v1y,v2y,a);
                break;
                case "tv1yv2y": awnser=v1yv2ytOFdy(v1y,v2y,t);
                break;
            }
        }
        else if(unknown == "t"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dxv1x": awnser=dxv1xOFt(dx,v1x);
                break;
                case "adyv1y": awnser=dyv1yaOFt(dy,a,v1y);
                break;
                case "adyv2y": awnser=dyv2yaOFt(dy,v2y,a);
                break;
                case "av1yv2y": awnser=v1yv2yaOFt(v1y,v2y,a);
                break;
                case "dyv1yv2y": awnser=v1yv2ydyOFt(v1y,v2y,dy);
                break;
            }
        }
        else if(unknown == "a"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "dytv1y": awnser=dyv1ytOFa(dy,t,v1y);
                break;
                case "dytv2y": awnser=dyv2ytOFa(dy,v2y,t);
                break;
                case "tv1yv2y": awnser=v1yv2ytOFa(v1y,v2y,t);
                break;
                case "dyv1yv2y": awnser=v1yv2ydyOFa(v1y,v2y,dy);
                break;
            }
        }
        else if(unknown == "theta1"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "v1xv1y": awnser=oppAdjOFtheta(v1x,v1y);
                break;
                case "v1yv1": awnser = oppHypOFtheta(v1y,v1);
                break;
                case "v1xv1": awnser = adjThetaOFhyp(v1x,v1);
                break;
            }
        }
        else if(unknown == "theta2"){
            switch(megaString){
                //For the case of any equation, run corresponding method
                case "v1xv2y": awnser=oppAdjOFtheta(v1x,v2y);
                break;
                case "v2yv2": awnser = oppHypOFtheta(v2y,v2);
                break;
                case "v1xv2": awnser = adjThetaOFhyp(v1x,v2);
                break;
            }
        }

        //Return the final awnser
        return awnser;
    }
}