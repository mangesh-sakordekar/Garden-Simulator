/*************
 * File Tile.java
 * This file contains the class Tile.
 * This holds the basic data of the garden
 */

package sakordekar_mangesh;

import javafx.scene.image.Image;

/**
 * class Tile
 * class Tile handles the tile and
 * holds the plant.
 * */
public class Tile  {

    //Private class variabes
    private Plant plant = new Plant();
    private Boolean is_changed = true;

    /**
     * Tile()
     * Initializes the tile to an empty plant
     */
    Tile(){
        plant = new EmptyPlant();
    }


    /**
     * String triggerUpdate()
     * Returns the data of the tile in string format
     */
    public String triggerUpdate(){
        return plant.getData();
    }


    /**
     * fertilize()
     * Fertilizes the plant in the block
     */
    public void fertilize(){
        is_changed = true;
        plant.fertilize();
    }

    /**
     * fertilize()
     * Fertilizes the plant in the block
     */
    public void water(Double amount){
        is_changed = true;
        plant.water(amount);
    }


    /**
     * newDay()
     * Updated plant to a new day.
     * Returns false if plant is dead and true otherwise.
     */
    public Boolean newDay(){
        is_changed = true;
        return plant.newDay();
    }


    /**
     * setTile(int ind, Object btn)
     * Sets the button btn to a plant type
     * according to the index.
     */
    public void setTile(int ind){

        is_changed = true;
        if(ind == 0) {
            plant = new Tree();
        }
        else if(ind == 1) {
            plant = new Flower();
        }
        else if (ind == 2) {
            plant = new EmptyPlant();
        }
    }

    /**
     * isFilled()
     * Checks if the tile is empty
     * Returns false if the tile is empty.
     */
    public Boolean isFilled(){
        if (plant instanceof Tree)
            return true;
        if (plant instanceof Flower)
            return true;
        return false;
    }

    /**
     * Boolean isChanged()
     * Checks if any changes were made to the tile
     */
    public Boolean isChanged(){
        if(is_changed){
            is_changed = false;
            return true;
        }
        return false;
    }

    /**
     * Image getImage()
     * Returns the image
     */
    public Image getImage(){
        return plant.getImage();
    }
}
