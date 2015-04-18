/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view.viewport;

import model.map.location.Tile;
import src.view.Renderable;

/**
 *
 * @author John
 */
public class Renderable_Tile implements Renderable{
    
    final Tile tile_;
    
    Renderable_Tile(Tile t) {
        tile_ = t;
    }
    
    public int renderAsImageToJPanel(view.viewport.GameViewport game_viewport, int x, int y) {
        return 0;
    }
    
    public int renderAsDotToJPanel(view.viewport.MiniMapViewport game_viewport, int x, int y) {
        return 0;
    }
}
