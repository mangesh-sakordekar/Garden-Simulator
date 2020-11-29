/*************
 * File Plant.java
 * This file contains Plant.
 * This is a parent class for three other classes.
 */

package sakordekar_mangesh;

import javafx.scene.image.Image;

/**
 * class EmptyPlant
 * class EmptyPlant holds EmptyPlant details
 * */
public class Plant {

    //Class Variable
    public Double health = 0.0;
    public Double waterNeeds = 0.0;
    public String name = "";
    public Double moisture = 0.0;

    Image image = new Image(getClass().getResourceAsStream("soil.png"));

    //abstract method
    public void fertilize(){

    }

    /**
     * void water(Double amount)
     * Adds amount to moisture
     */
    public void water (Double amount){
        moisture += amount;
    }

    //abstract function
    public Boolean newDay (){
        return true;
    }

    //abstract method
    public String getData(){
        return "";
    }

    //abstract method
    public Image getImage(){
        return image;
    }
}
