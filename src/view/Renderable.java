/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.viewport.GameViewport;
import view.viewport.MiniMapViewport;

/**
 *
 * @author John
 */
public interface Renderable {
    /**
     * 
     * @param game_viewport - viewport to render image
     * @param x - x position on Panel to render image (top left is zero-zero)
     * @param y - y position on Panel to render image
     * @return - 0 if image can be found and rendered, -1 otherwise  
     */
    public int renderAsImageToJPanel(GameViewport game_viewport, int x, int y);
    
    public int renderAsDotToJPanel(MiniMapViewport game_viewport, int x, int y);
    
}
