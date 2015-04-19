/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import view.utility.GameTileRenderer;
import view.utility.MiniTileRenderer;
import view.utility.TileRenderer;
import model.ModelViewBundle;
import model.map.GameMap;
import model.map.location.Tile;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.control.virtual_control.swing_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;

/**
 * Represents the mini-map. 
 * Note that to draw points on the minimap, you have to use Graphics.drawLine(x1, y1, x1, y1). 
 * See http://stackoverflow.com/questions/13656296/drawing-a-point-on-a-jpanel
 * @author comcc_000 & John-Michael Reed
 */
public class MiniMapViewport extends Viewport {

	private GameMap gameMap;
	
	private TileRenderer tileRendererVisitor;
	
    /**
     * Creates new form MainScreen
     */
    public MiniMapViewport() {
        initComponents();
        
        //TODO fake map
        gameMap = new GameMap();
    }

    @Override
    protected void generateView() {
        //TODO
    }


    @Override
    public void update(ModelViewBundle mvb) {
        repaint();
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        //TODOD
        return controlMaps;
    }
    
    @Override
	public void paint(Graphics g) {
		super.paint(g);
		// Tile visitor
        tileRendererVisitor = new MiniTileRenderer(g,0,0);
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
				tileRendererVisitor.setX(x);
				tileRendererVisitor.setY(y);
				map[x][y].accept(tileRendererVisitor);
				
			}
		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
