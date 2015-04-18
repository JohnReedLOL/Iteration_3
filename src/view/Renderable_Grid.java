/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.map.GameMap;
import view.viewport.GameViewport;
import view.viewport.MiniMapViewport;

/**
 *
 * @author John
 */
public class Renderable_Grid implements Renderable {
    
    // MapTile[][] map_tiles = null;
    GameMap m = null;
    
    @Override
    public int renderAsImageToJPanel(GameViewport game_viewport, int x, int y) {
        return 0;
    }
    @Override
    public int renderAsDotToJPanel(MiniMapViewport game_viewport, int x, int y) {
        return 0;
    }
}
