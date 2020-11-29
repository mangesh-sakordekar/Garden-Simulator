/*************
 * File GardenModel.java
 * This file contains the class GardenModel.
 * This handles the data of the project
 */


package sakordekar_mangesh;

import javafx.scene.Node;

/**
 * class GardenModel
 * class GardenModel handles the garden grid
 * and does all the required operations
 * */
public class GardenModel  {

    //Array to store garden details
    private Tile[][] grid;

    //counts
    private Integer dayCnt = 0;
    private Integer diedCnt = 0;
    private Integer filledCnt = 0;
    private Integer size = 0;

    /**
     * GardenModel(int num)
     * Initializes the variables and
     * makes a grid of size num
     */
    GardenModel(int num){

        dayCnt = 0;
        diedCnt = 0;
        filledCnt = 0;
        size = num;

        grid = new Tile[size][size];
        for(int i=0;i<size;i++){
            for(int j =0; j<size; j++)
                grid[i][j] = new Tile();
        }
    }


    /**
     * void fertilize(int x, int y)
     * Fertilizes the tile at position [x,y] in the grid
     */
    public void fertilize(int x, int y){
        grid[x][y].fertilize();
    }

    /**
     * void water (Double amount)
     * Adds water to each tile in the array
     */
    public void water (Double amount){
        for(int i=0;i<size;i++){
            for(int j =0; j<size; j++)
                grid[i][j].water(amount);
        }
    }

    /**
     * void newDay()
     * Updates to a new day and checks if any plants
     * are dead and sets the counts accordingly.
     */
    public void newDay(){

        dayCnt += 1;
        for(int i=0;i<size;i++){
            for(int j =0; j<size; j++) {
                if (!grid[i][j].newDay()){
                    diedCnt++;
                    filledCnt --;
                    grid[i][j] = new Tile();
                }
            }
        }
    }

    /**
     * void setTile(int ind, Object btn, int x, int y)
     * sets a tile to given type of plant  according to the index
     *  at position [x,y] in the grid
     */
    public void setTile(int ind, int x, int y){

        if(ind == 2 && grid[x][y].isFilled())
            filledCnt -= 1;
        if(ind != 2 && !grid[x][y].isFilled())
            filledCnt += 1;
        grid[x][y].setTile(ind);
    }


    //Getter for filledCnt
    public Integer getFilledCnt(){
        return filledCnt;
    }

    //Getter for dayCnt
    public Integer getDays(){
        return dayCnt;
    }

    //Getter for diedCnt
    public Integer getDiedCnt(){
        return diedCnt;
    }

    //Getter for tile
    public Tile getTile(int x, int y){
        return grid[x][y];
    }
}
