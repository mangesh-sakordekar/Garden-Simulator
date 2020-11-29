/*************
 * File EmptyPlant.java
 * This file contains the class Empty plant.
 */

package sakordekar_mangesh;

import javafx.scene.image.Image;

/**
 * class EmptyPlant
 * class EmptyPlant holds EmptyPlant details.
 * It is derived from Plant class.
 * */
public class EmptyPlant extends Plant {

    private Image image = new Image(getClass().getResourceAsStream("soil.png"));

    //Dummy Function
    public void fertilize(){

    }

    //Dummy Function
    public void water (Double amount){

    }

    //Dummy function
    public Boolean newDay (){
        return true;
    }


    /**
     * String getData()
     * Returns the string containing data
     */
    public String getData(){
        return "";
    }

    /**
     * Image getImage()
     * Returns the image;
     */
    public Image getImage(){
        return image;
    }
}
