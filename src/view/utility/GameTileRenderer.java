package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import javax.imageio.ImageIO;

import model.MapObject;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class GameTileRenderer extends GameScreenRenderer implements TileRenderer {

    // Tile images
    private BufferedImage grass;
    private BufferedImage mountain;
    private BufferedImage water;

    // MapObjectsRenderer
    private ObjectRenderer mapObjectRenderer;

    // FOR DEBUG
    private final boolean DEBUG = false;

    public GameTileRenderer(Graphics g) {
        super(g);
        this.startx = 0;
        this.starty = 0;
        mapObjectRenderer = new GameObjectRenderer(g);
        initializeImages();
    }

    public GameTileRenderer(Graphics g, int startx, int starty) {
        super(g);
        this.startx = startx;
        this.starty = starty;
        mapObjectRenderer = new GameObjectRenderer(g, startx, starty);
        initializeImages();
    }

    private void initializeImages() {
        try {
            System.out.println();
            ClassLoader classLoader = Thread.currentThread()
                    .getContextClassLoader();
            URL url = classLoader.getResource("resources/png/grass.png");
            grass = ImageIO.read(new File(url.getPath()));
            url = classLoader.getResource("resources/png/mountain.png");
            mountain = ImageIO.read(new File(url.getPath()));
            url = classLoader.getResource("resources/png/water.png");
            water = ImageIO.read(new File(url.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void visit(GrassTile grassTile) {
        drawTileAlgorithm(grass, grassTile.getMapObjects());
    }

    public void visit(MountainTerrain mountainTerrain) {
        drawTileAlgorithm(mountain, mountainTerrain.getMapObjects());
    }

    public void visit(WaterTile waterTile) {
        drawTileAlgorithm(water, waterTile.getMapObjects());
    }

    private void drawTileAlgorithm(Image img, Collection<MapObject> mapObjects) {
        scaleXandY(x, y);
        g.drawImage(img, drawx, drawy, 100, 100, null);
        drawMapObjects(mapObjects);
        drawDebug();
    }

    private void drawMapObjects(Collection<MapObject> mapObjects) {
        mapObjectRenderer.setX(x);
        mapObjectRenderer.setY(y);
        for (MapObject mapObject : mapObjects) {
            mapObject.accept(mapObjectRenderer);
        }
    }

    /**
     * Takes in a BufferedImage and a percentage and produces a new
     * BufferedImage that is darker by that percentage amount.
     *
     * @param bufferedImage - image to be copied and darkened.
     * @param percentage - percentage to darken that BufferedImage by. If this
     * value were 10 it would darken the image by 10%.
     * @return The darkened image.
     */
    public BufferedImage produceBufferedImageDarkenedByPercentage(BufferedImage bufferedImage, int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Illegal percentage");
        }
        /**
         * 100 corresponds to pitch black, 50 corresponds to 50% darkened, and 0
         * corresponds to regular rendering. Do not go over 100 or under 0%
         * brightness.
         */
        final int remainder = 100 - percentage;
        final float remaining_light = (float) remainder;
        RescaleOp op = new RescaleOp(remaining_light, 0, null);
        // If the destination image (second parameter of op.filter) is null, a [new] BufferedImage will be created.
        BufferedImage darkened_image = op.filter(bufferedImage, null);
        return darkened_image;
    }

    private void drawDebug() {
        if (DEBUG) {
            g.setColor(Color.RED);
            g.drawRect(drawx, drawy, 100, 100);
            g.drawString("x: " + x + ",y: " + y, drawx, drawy);
        }
    }

}
