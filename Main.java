/*************
 * File Main.java
 * This file contains the Main
 * This starts the application
 */

package sakordekar_mangesh;
/**
 * name:      Garden Simulator
 *
 * author:    Mangesh Sakordekar
 *
 * course:    CSC 468 GUI Programming
 * section:   M1
 * date:      02/13/2019
 *
 * version:  java10
 *
 * Description :
 * This program simulates a garden model. It uses the WYSIWYG editor
 * to make the layout.It uses the Model-View-Controller model to handle
 * the events. The program creates an user interface to handle the tasks
 * of resizing the garden, adding and removing a plant or a flower,
 * watering the garden and fertilize the garden. It also displays the
 * number of filled tiles, number of days passed and the number of plants
 * that died.
 *
 * Observer Pattern:
 * File : PlantBtn.java
 * Lines : 23, 24
 * Observer - PlantBtn
 * Subject - Tile
 *
 * Extensions:
 * 1. Added images instead of saying Tree/Flower/None.
 * 2. Added padding and colored text to buttons.
 *
 * Issues:
 * 1. Grid had to be made public due to WYSIWYG.
 * 2. Adds 10 to moisture if the textbox is empty and water all is pressed
 *    (Added as it was mentioned in rubric to add a hardcoded amount)
 *
 * Bugs:
 * None
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * class Main
 * class Main sets up the WYSIWYG layout and starts the program
 * */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        primaryStage.setTitle("Plant Simulator");
        primaryStage.setScene(new Scene(root, 800, 600));

        Controller gardenSimulator = new Controller();
        gardenSimulator.initialize();

        primaryStage.show();
    }

    //Main function
    public static void main(String[] args) {
        launch(args);
    }
}
