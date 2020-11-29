/*************
 * File Controller.java
 * This file contains the controller class and handles
 * all the events.
 */

package sakordekar_mangesh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * class Controller
 * class Controller handles the events and
 * controls the flow of control to various classes.
 * */
public class Controller {

    private GardenView garden = new GardenView(3);
    private GardenModel gModel = new GardenModel( 3);

    //Setting up the combo box
    private ObservableList<String> options = FXCollections.observableArrayList("3", "4", "5","6");
    @FXML
    public ComboBox comboBoxSize = new ComboBox();

    //Declaring the UI buttons
    @FXML
    public Button buttonNewDay = new Button();
    @FXML
    public Button buttonUpdate = new Button();
    @FXML
    public Button buttonTree = new Button();
    @FXML
    public Button buttonFlower = new Button();
    @FXML
    public Button buttonRemove = new Button();
    @FXML
    public Button buttonWaterAll = new Button();
    @FXML
    public Button buttonFertilize1 = new Button();
    @FXML
    public Button buttonFertilize2 = new Button();

    //declaring labels
    @FXML
    public Label lblDay = new Label();
    @FXML
    public Label lblFilled = new Label();
    @FXML
    public Label lblDied = new Label();

    //Declaring TextFields
    @FXML
    public TextField txtWater = new TextField();


    //Declaring grids
    //Require to be public for WYSIWYG
    @FXML
    public GridPane grid3x3 = new GridPane();
    @FXML
    public GridPane grid4x4 = new GridPane();
    @FXML
    public GridPane grid5x5 = new GridPane();
    @FXML
    public GridPane grid6x6 = new GridPane();


    private Boolean isTree = false;
    private Boolean isFlower = false;
    private Boolean isRemove = false;

    private Boolean fertilized1 = false;
    private Boolean fertilized2 = false;

    private Integer gridSize = 3;


    /**
     * initialize()
     * Initializes the variables to the objects
     * created using WYSIWYG.
    */
    @FXML
    public void initialize(){

        comboBoxSize.setValue("3");
        comboBoxSize.setItems(options);

        buttonNewDay.setText("New Day");
        buttonUpdate.setText("Update");
        buttonTree.setText("Tree");
        buttonFlower.setText("Flower");
        buttonRemove.setText("Remove");
        buttonWaterAll.setText("Water All");
        buttonFertilize1.setText("Fertilize");
        buttonFertilize2.setText("Fertilize");

        lblDay.setText("00");
        lblFilled.setText("00");
        lblDied.setText("00");

        txtWater.setText("");


        grid3x3.setGridLinesVisible(true);
        grid4x4.setGridLinesVisible(true);
        grid5x5.setGridLinesVisible(true);
        grid6x6.setGridLinesVisible(true);

        update(grid3x3);
    }


    /**
     * handleNewDayClick()
     * event handler to handle "New Day" button clicks
     */
    @FXML
    void handleNewDayClick(){

        buttonFertilize1.setDisable(false);
        buttonFertilize2.setDisable(false);

        isTree = false;
        isFlower = false;
        isRemove = false;

        fertilized1 = false;
        fertilized2 = false;

        //calls newday in Garden Model
        gModel.newDay();

        //Updates counts
        lblDay.setText(setLbl(gModel.getDays()));
        lblDied.setText(setLbl(gModel.getDiedCnt()));
        lblFilled.setText(setLbl(gModel.getFilledCnt()));
        update(selectGrid());
    }

    /**
     * handleUpdateClick()
     * event handler to handle "Update" button clicks
     */
    @FXML
    void handleUpdateClick(){

        //Set Labels to 0
        lblDay.setText("00");
        lblFilled.setText("00");
        lblDied.setText("00");

        buttonFertilize1.setDisable(false);
        buttonFertilize2.setDisable(false);

        isTree = false;
        isFlower = false;
        isRemove = false;

        //Make all grids invisible
        grid3x3.setVisible(false);
        grid4x4.setVisible(false);
        grid5x5.setVisible(false);
        grid6x6.setVisible(false);

        gridSize = Integer.parseInt(comboBoxSize.getValue().toString());
        gModel = new GardenModel(gridSize);
        garden = new GardenView(gridSize);

        //Set the required grid visible
        GridPane grid = selectGrid();
        update(grid);
        grid.setVisible(true);

    }

    /**
     * handleTreeClick()
     * event handler to handle "Tree" button clicks
     */
    @FXML
    void handleTreeClick(){
        isTree = true;
        isFlower = false;
        isRemove = false;

        fertilized1 = false;
        fertilized2 = false;
    }

    /**
     * handleFlowerClick()
     * event handler to handle "Flower" button clicks
     */
    @FXML
    void handleFlowerClick(){
        isTree = false;
        isFlower = true;
        isRemove = false;

        fertilized1 = false;
        fertilized2 = false;
    }

    /**
     * handleRemoveClick()
     * event handler to handle "Remove" button clicks
     */
    @FXML
    void handleRemoveClick(){
        isTree = false;
        isFlower = false;
        isRemove = true;

        fertilized1 = false;
        fertilized2 = false;
    }


    /**
     * handleWaterAllClick()
     * event handler to handle "Water All" button clicks
     */
    @FXML
    void handleWaterAllClick(){

        isTree = false;
        isFlower = false;
        isRemove = false;
        fertilized1 = false;
        fertilized2 = false;

        //Takes in content from text box and
        //checks if it is a number within the range
        try{
            //Add 10 by default if nothing in the text box
            if(txtWater.getText().equals(""))
                gModel.water(10.0);
            else {
                Double temp = Double.valueOf(txtWater.getText());
                if (temp > 0.0 && temp <= 20.0)
                    gModel.water(temp);
                else
                    txtWater.setText("0 < Num < 20");
            }
        }
        catch (Exception e){
            txtWater.setText("Enter a number");
        }

        update(selectGrid());
    }


    /**
     * handleFertilize1Click()
     * event handler to handle "Fertilize" button clicks
     */
    @FXML
    void handleFertilize1Click(){

        isTree = false;
        isFlower = false;
        isRemove = false;

        fertilized1 = true;
        fertilized2 = false;
    }

    /**
     * handleFertilize2Click()
     * event handler to handle "Fertilize" button clicks
     */
    @FXML
    void handleFertilize2Click(){

        isTree = false;
        isFlower = false;
        isRemove = false;

        fertilized1 = false;
        fertilized2 = true;
    }


    /**
     * handleGrid(MouseEvent e)
     * event handler to handle "Fertilize" button clicks
     */
    @FXML
    void handleGrid(MouseEvent e){

        GridPane grid = selectGrid();

        //Get the source of the event
        if(e.getSource() instanceof Button){
            Object temp = e.getSource();

            //Get x and y coordinates of the button
            int x;
            int y;
            if (grid.getRowIndex((Node)temp) == null)
                x = 0;
            else
                x = Integer.valueOf(grid.getRowIndex((Node)temp));

            if (grid.getColumnIndex((Node)temp) == null)
                y = 0;
            else
                y = Integer.valueOf(grid.getColumnIndex((Node)temp));

            //Check the previous button pressed
            if (isTree) {
                gModel.setTile(0, x, y);
            }
            else if(isFlower){
                gModel.setTile(1, x, y);
            }
            else if(isRemove){
                gModel.setTile(2, x, y);
            }
            else if (fertilized1){
                gModel.fertilize(x,y);
                fertilized1 = false;
                buttonFertilize1.setDisable(true);
            }
            else if (fertilized2){
                gModel.fertilize(x,y);
                fertilized2 = false;
                buttonFertilize2.setDisable(true);
            }

            //Update
            update(selectGrid());
            lblFilled.setText(setLbl(gModel.getFilledCnt()));
        }

    }



    /**
     * selectGrid()
     * helper function to return the grid of appropriate size
     */
    private GridPane selectGrid(){
        switch (gridSize){
            case 3 : return grid3x3;
            case 4 : return grid4x4;
            case 5 : return grid5x5;
            case 6 : return grid6x6;
        }
        return null;
    }

    /**
     * update(GridPane gridbtns)
     * updates the given grid
     */
    private void update(GridPane gridbtns){

        //Update each button
        ObservableList<Node> btnlist = gridbtns.getChildren();
        btnlist.forEach(node ->{
            if(node instanceof Button){

                int x;
                int y;

                if (gridbtns.getRowIndex((Node)node) == null)
                    x = 0;
                else
                    x = Integer.valueOf(gridbtns.getRowIndex((Node)node));

                if (gridbtns.getColumnIndex((Node)node) == null)
                    y = 0;
                else
                    y = Integer.valueOf(gridbtns.getColumnIndex((Node)node));

                garden.update(gModel.getTile(x,y),node, x, y);
            }
        });
    }

    /**
     * String setLbl(Integer x)
     * helper function to return the integer converted
     * to a string.
     */
    public String setLbl(Integer x){
        if (x>9)
            return x.toString();
        else
            return "0" + x.toString();
    }
}
