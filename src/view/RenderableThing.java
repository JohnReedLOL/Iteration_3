/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view;

import application.Application;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import model.MapObject;
import view.Renderable;
import view.viewport.GameViewport;
import view.viewport.MiniMapViewport;
import view.viewport.screen_viewport.GameScreenViewport;

/**
 *
 * @author johnmichaelreed2
 */
public class RenderableThing <T extends MapObject> implements Renderable {
    final T to_render_;
    
    /**
     * Gets the file name of this object's image without the leading "/" but with the trailing ".png"
     * @return File name corresponding to this object.
     */
    protected String getMyImagesFileName() {
        final String[] substrings = to_render_.getClass().getCanonicalName().split(".");
        Application.check(substrings.length > 1);
        // remove dollar signs from class name and append .png
        return substrings[substrings.length - 1].replaceAll("$", "") + ".png";
    }
    
    public RenderableThing(T thing) {
        to_render_ = thing;
    }
    
    @Override
    public int renderAsImageToJPanel(GameViewport game_viewport, int x, int y) {
        return 0;
    }
    @Override
    public int renderAsDotToJPanel(MiniMapViewport game_viewport, int x, int y) {
        return 0;
    }
    /**
     * Renders this wrapper object to a JLabel
     * @param panel - The viewport to render myself to
     * @return 0 on success, -1 on failure
     */
    public int renderAsImageOnJLabel(JLabel label) {
        return 0;
    }
    
    public void printMeToTheTerminal() {
    }
    
    public void getMyCharacterRepresentation() {
    }
    
    public BufferedImage getMyImageRepresentation() {
        
        final String class_name;
        
        Application.check(false, "not yet implemented");
        return null;
    }
}
