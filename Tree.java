/*************
 * File tree.java
 * This file contains the class Tree.
 */

package sakordekar_mangesh;

import javafx.scene.image.Image;

/**
 * class Tree
 * class Tree holds tree details.
 * It is derived from the class Plant.
 * */
public class Tree extends Plant {

    private Image image = new Image(getClass().getResourceAsStream("tree.png"));

    /**
     * Tree()
     * Initializes derived variables
     */
    Tree(){
        health = 50.0;
        waterNeeds = 20.0;
        name = "tree";
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
    @Override
    public void water(Double amount) {
        super.water(amount);
    }

    /**
     * Boolean newDay ()
     * Subtracts 10 from moisture and 5 from health.
     * If moisture is less than needed subtracts 10 from health.
     * Returns false if the tree is dead
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
