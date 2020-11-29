/*************
 * File GardenView.java
 * This file contains the class GardenModel.
 * This handles the view of the project
 */

package sakordekar_mangesh;

/**
 * class  GardenView
 * class  GardenView handles the garden buttons
 * and does all the required operations
 * */
public class GardenView {

    private PlantBtn grid[][];
    private Integer size = 3;

    /**
     * GardenModel(int num)
     * Initializes the variables and
     * makes a grid of size num
     */
    GardenView(int num){

        size = num;

        grid = new PlantBtn[size][size];
        for(int i=0;i<size;i++){
            for(int j =0; j<size; j++)
                grid[i][j] = new PlantBtn();
        }
    }


    /**
     * void update(Tile Observable, Object btn, int x, int y)
     * passes the arguments to the plantbtn for updates
     */
    public void update(Tile Observable, Object btn, int x, int y){
        grid[x][y].update(Observable, btn);
    }

}
