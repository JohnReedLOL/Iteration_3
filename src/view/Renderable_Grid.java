/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.map.GameMap;
import model.map.location.Tile;
import view.viewport.GameViewport;
import view.viewport.MiniMapViewport;

/**
 *
 * @author John
 */
public class Renderable_Grid implements Renderable {
    
    // MapTile[][] map_tiles = null;
    final Tile[][] map_;
    final Renderable_Tile[][] renderable_map_;
    
    Renderable_Grid(Tile[][]map) {
        map_ = map;
        /*
        for(int i = 0; i < map_.length; ++i) {
            for(int j = 0; j < map_[0].length; ++j) {
                
            }
        }*/
        renderable_map_ = null;
    }
    
    @Override
    public int renderAsImageToJPanel(GameViewport game_viewport, int x, int y) {
        return 0;
    }
    @Override
    public int renderAsDotToJPanel(MiniMapViewport game_viewport, int x, int y) {
        return 0;
    }
}
