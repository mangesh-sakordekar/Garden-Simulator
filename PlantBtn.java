/*************
 * File PlantBtn.java
 * This file contains the class PlantBtn
 * This class uses the observer pattern to update view
 */

package sakordekar_mangesh;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * class PlantBtn
 * This class acts as the observer and observes the tile
 * and updates the view if the tile is changed.
 * */
public class PlantBtn {

    /**
     * void update(Tile Observable, Object btn)
     * updates the btn if the Observable has changed
     */
    public void update(Tile Observable, Object btn){
        if(Observable.isChanged()){
            if(btn instanceof Button){
                ((Button) btn).setGraphic(new ImageView((Observable.getImage())));
                ((Button) btn).setText(Observable.triggerUpdate());
            }
        }
    }
}
