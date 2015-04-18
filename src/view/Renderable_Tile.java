/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Application;
import model.map.location.Tile;
import view.Renderable;

/**
 *
 * @author John
 */
public class Renderable_Tile<T extends Tile> implements Renderable {

    final T tile_to_render_;

    /**
     * Gets the file name of this object's image without the leading "/" but with the trailing
     * ".png"
     *
     * @return File name corresponding to this object.
     */
    protected String getMyImagesFileName() {
        final String[] substrings = tile_to_render_.getClass().getCanonicalName().split(".");
        Application.check(substrings.length > 1);
        // remove dollar signs from class name and append .png
        return substrings[substrings.length - 1].replaceAll("$", "") + ".png";
    }

    Renderable_Tile(T t) {
        tile_to_render_ = t;
    }

    public int renderAsImageToJPanel(view.viewport.GameViewport game_viewport, int x, int y) {
        return 0;
    }

    public int renderAsDotToJPanel(view.viewport.MiniMapViewport game_viewport, int x, int y) {
        return 0;
    }
}
