/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.ArrayList;

import model.ModelViewBundle;
import model.map.GameMap;
import model.map.location.Tile;
import mvc_bridgeway.control_map.ControlMap;
import view.utility.GameTileRenderer;
import view.utility.TileRenderer;
import application.Application;

/**
 *
 * @author comcc_000
 */
public class GameViewport extends Viewport {

	private GameMap gameMap;
	private int[][] brightness;
	
	private TileRenderer tileRendererVisitor;

	/**
	 * Creates new form MainScreen
	 */
	public GameViewport() {
		initComponents();
        
        //TODO fake map
        gameMap = new GameMap();
        Application.check(gameMap.getAvatar() != null, "Avatar is null cannot get brightness table");
        brightness = gameMap.getAvatar().getBrightnessTable();
	}

	@Override
	protected void generateView() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Tile visitor
        tileRendererVisitor = new GameTileRenderer(g);
		displayMap(tileRendererVisitor, gameMap.getTiles());
	}

	/**
	 * 
	 * @param tileRendererVisitor - this components Graphics object
	 * @param map - Tile[][] of the GameMap
	 * @param starty - where to begin rendering on y axis
	 * @param startx - where to begin rendering on x axis
	 */
	private void displayMap(TileRenderer tileRendererVisitor, Tile[][] map) {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				tileRendererVisitor.setX(x);
				tileRendererVisitor.setY(y);
				tileRendererVisitor.setBrightness(brightness[x][y]);
				map[x][y].accept(tileRendererVisitor);
				
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
