/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import application.Application;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import model.MapObject;
import view.viewport.screen_viewport.GameScreenViewport;

/**
 *
 * @author johnmichaelreed2
 */
public class RenderableThing<T extends MapObject> {
    final MapObject to_render_;
    public RenderableThing(T thing) {
        to_render_ = thing;
    }
    /**
     * Renders this wrapper object to a JLabel
     * @param panel - The viewport to render myself to
     * @return 0 on success, -1 on failure
     */
    public int renderAsImageOnjPanel(GameScreenViewport panel) {
        return 0;
    }
    
    public void printMeToTheTerminal() {
    }
    
    public void getMyCharacterRepresentation() {
    }
    
    public BufferedImage getMyImageRepresentation() {
        Application.check(false, "not yet implemented");
    }
}
