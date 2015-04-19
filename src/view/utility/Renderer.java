package view.utility;

import java.awt.Graphics;

public abstract class Renderer {
	// JComponents graphics reference
		protected Graphics g;

		// where to start drawing from
		protected int startx;
		protected int starty;

		// graphics x and y
		protected int drawx;
		protected int drawy;

		// map index
		protected int x;
		protected int y;
		
		public Renderer(Graphics g) {
			this.g = g;
		}
		
		public void setX(int drawx) {
			this.x = drawx;
		}

		public void setY(int drawy) {
			this.y = drawy;
		}


		public void setStartX(int startx) {
			this.startx = startx;
		}

		public void setStartY(int starty) {
			this.starty = starty;
		}

		protected abstract void scaleXandY(int x, int y);
}
