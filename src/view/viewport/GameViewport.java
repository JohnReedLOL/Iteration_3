/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.ModelViewBundle;
import model.map.GameMap;
import model.map.location.Tile;
import mvc_bridgeway.control_map.ControlMap;
import application.Application;

/**
 *
 * @author comcc_000
 */
public class GameViewport extends Viewport {

	private BufferedImage img1;
	private BufferedImage img2;
	private BufferedImage img3;
	private GameMap gameMap;
        
        /**
         * Takes in a BufferedImage and a percentage and produces a new BufferedImage that is darker by that percentage amount.
         * @param bufferedImage - image to be copied and darkened.
         * @param percentage - percentage to darken that BufferedImage by. If this value were 10 it would darken the image by 10%.
         * @return The darkened image.
         */
        public BufferedImage produceBufferedImageDarkenedByPercentage(BufferedImage bufferedImage, int percentage) {
            if(percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException("Illegal percentage");
            }
            final int remainder = 100 - percentage;
            final float remaining_light = (float) remainder;
            RescaleOp op = new RescaleOp(remaining_light, 0, null);
            // If the destination image (second parameter of op.filter) is null, a [new] BufferedImage will be created.
            BufferedImage darkened_image = op.filter(bufferedImage, null);
            return darkened_image;
        }
        
        /**
         * 100 corresponds to pitch black, 50 corresponds to 50% darkened, and 0 corresponds to regular rendering.
         * Do not go over 100 or under 0% brightness.
         */
        private final int[][] brightness_map_;

	/**
	 * Creates new form MainScreen
	 */
	public GameViewport() {
		initComponents();
                brightness_map_ = new int[1000][1000];
                Application.check(brightness_map_[0][0] == 0, "Invalid assumption");
        gameMap = new GameMap();
        gameMap.getTiles();
		try {
            System.out.println();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource("resources/png/grass.png");
			img1 = ImageIO.read(new File(url.getPath()));
            url = classLoader.getResource("resources/png/mountain.png");
			img2 = ImageIO.read(new File(url.getPath()));
            url = classLoader.getResource("resources/png/water.png");
			img3 = ImageIO.read(new File(url.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void generateView() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		displayMap(g, gameMap.getTiles(), 30, 30);
		//displayMap(g, map2, 500, 100);
	}

	/*
	 * TODO CHANGE INT MAP TO GAMEMAP TYPE - PLEASE USE JAVADOC I DO NOT KNOW WHAT STARTX OR STARTY DO>
	 * TODO CHANGE CHECKS THINGS, MAYBE ADD VISITOR PATTER
	 * TODO FIX HOW IMAGES TO RETREIVED REMOVE FROM CONSTRUCTOR?
	 */
        /**
         * 
         * @param g - this components Graphics object
         * @param map - Tile[][] of the GameMap
         * @param startx - left pixel to start rendering from
         * @param starty  - top pixel to start rendering from
         */
	private void displayMap(Graphics g, Tile[][] map, int startx, int starty) {
		/**
		 * Tile[x][y]
		 * for a Game map the first index is the x and the second index is y
		 *   ____      ____ 
		 *  / 0,0\____/ 0,2\   x,y
		 *  \____/ 0,1\____/
		 *  / 1,0\____/ 1,2\
		 *  \____/ 1,1\____/
		 *  / 2,0\____/ 2,2\
		 *  \____/    \____/
		 *  
		 *  BECAUSE OF THIS, we need to translate the Tile x and y
		 *  to the Graphics x and y
		 */
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				int drawx = 0;
				int drawy = 0;
				if (y % 2 == 0) {
					drawx = startx + y * 75;
					drawy = starty + x * 86;
				} else {
					drawx = startx + y * 75;
					drawy = starty + x * 86 + 43;
				}
					g.drawImage(img1, drawx, drawy, 100, 100, null);
					g.setColor(Color.RED);
					g.drawRect(drawx, drawy, 100, 100);
					g.drawString("x: " + x + ",y: " + y, drawx, drawy);
				
			}
		}
	}

	@Override
	public void update(ModelViewBundle mvb) {
		repaint();
	}

	@Override
	public ArrayList<ControlMap> getControlMaps() {
		ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
		// TODOD
		return controlMaps;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("GameMap");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 712, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 541, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
