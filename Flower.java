/*************
 * File Flower.java
 * This file contains the class Flower.
 */

package sakordekar_mangesh;

import javafx.scene.image.Image;

/**
 * class Flower
 * class Flower holds Flower details.
 * It is derived from the class Plant.
 * */
public class Flower extends Plant {


    private Image image = new Image(getClass().getResourceAsStream("flower.png"));

    /**
     * Flower()
     * Initializes derived variables
     */
    Flower(){
        health = 20.0;
        waterNeeds = 10.0;
        name = "flower";
    }

    /**
     * fertilize()
     * Adds 10 to health
     */
    public void fertilize(){
        health += 10.0;
    }

    /**
     * void water(Double amount)
     * Adds amount to moisture
     */
    public void water (Double amount){
        super.water(amount);
    }

    /**
     * Boolean newDay ()
     * Subtracts 10 from moisture and 5 from health.
     * If moisture is less than needed subtracts 10 from health.
     * Returns false if the flower is dead
     */
    public Boolean newDay (){

        if(moisture < waterNeeds)
            health -= 10.0;
        health -= 5.0;
        moisture -= 10;

        if(moisture < 0.0)
            moisture = 0.0;

        if(health < 0)
            return false;

        return true;
    }

    /**
     * String getData()
     * Returns the string containing data
     */
    public String getData(){
        return "Health: " + health +"\nSoil Moisture: " + moisture;
    }

    /**
     * Image getImage()
     * Returns the image;
     */
    public Image getImage(){
        return image;
    }
}
