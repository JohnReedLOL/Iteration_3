/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport.screen_viewport;

import java.util.ArrayList;

import model.ModelViewBundle;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.Viewport;

import com.sun.prism.image.ViewPort;

/**
 *
 * @author comcc_000
 */
public abstract class ScreenViewport extends Viewport {

    /*Properties*/
    
    private ArrayList<Viewport> interiorViewports = new ArrayList<Viewport>();
    
    /**
     * Creates new form ScreenViewport
     */
    public ScreenViewport() {
        initComponents();
        
    }

    /*Constructors*/

    /*Methods*/
    
    
    @Override
    protected final void addViewport(Viewport viewport) {
        interiorViewports.add(viewport);
        super.addViewport(viewport);
    }
    
    @Override
    public final void update(ModelViewBundle mvb) {
        int numInteriorViewports = interiorViewports.size();
        Viewport viewport;
        for (int i=0; i<numInteriorViewports; i++) {
            viewport = interiorViewports.get(i);
//            Long begin = System.nanoTime();
            viewport.update(mvb);
//            Long end = System.nanoTime();
//            System.out.println(viewport.getClass().getCanonicalName()+" "+(end-begin));
        }
    }
   
    /*GetSets*/
    
    protected final ArrayList<Viewport> getInteriorViewports(){
    	return interiorViewports;
    }
    
    @Override
    public final ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> ims = new ArrayList<ControlMap>(1);
        ArrayList<ControlMap> temp_ims = new ArrayList<ControlMap>(1);
        int numInteriorViewports = interiorViewports.size();
        Viewport viewport;
        for (int i=0; i<numInteriorViewports; i++) {
            viewport = interiorViewports.get(i);
            temp_ims = viewport.getControlMaps();
            aggregateControlMaps(ims, temp_ims);
        }
        return ims;
    }
    
    @Override
    public final boolean isRefreshControllerNeeded() {
        for (Viewport viewport : interiorViewports) {
            if (viewport.isRefreshControllerNeeded()) {
                return true;
            }
        }
        return false;
    }

    private final void aggregateControlMaps(ArrayList<ControlMap> ims1, ArrayList<ControlMap> ims2) {
        int numims2 = ims2.size();
        for (int i=0; i<numims2; i++) {
            ims1.add(ims2.get(i));
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

        setPreferredSize(new java.awt.Dimension(1280, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
