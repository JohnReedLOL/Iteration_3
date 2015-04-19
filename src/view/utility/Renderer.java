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

	// for Avatar visibility
	protected int[] upperbound;
	protected int[] lowerbound;
	// brightness
	protected int brightness;

	protected int avatarx = 2;
	protected int avatary = 9;
	protected int viewDistance = 2;

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

	protected boolean withinAvatarViewDistance(int x, int y) {
		int startDistY = avatary - viewDistance;
		boolean ret = false;
		for (int i = 0; i < upperbound.length; i++) {
			if (x >= upperbound[i] && x <= lowerbound[i] && y == startDistY) {
				ret = true;
				break;
			}
			startDistY++;
		}
		return ret;
	}
	
	protected void generateViewDistanceBounds(int avatarx, int avatary,
			int distance) {
		this.upperbound = new int[2 * distance + 1];
		this.lowerbound = new int[2 * distance + 1];

		if (avatary % 2 == 0) {
			int count = 0;
			int match = 0;
			int upDistBound = distance;
			int lowDistBound = distance;
			for (int i = distance; i >= 0; i--) {
				if (count == 0) {
					upperbound[i] = avatarx - upDistBound;
					upperbound[distance + match] = avatarx - upDistBound;
					lowerbound[i] = avatarx + lowDistBound;
					lowerbound[distance + match] = avatarx + lowDistBound;
					count++;
				} else {
					upperbound[i] = avatarx - upDistBound;
					upperbound[distance + match] = avatarx - upDistBound;
					upDistBound--;
					lowDistBound--;
					lowerbound[i] = avatarx + lowDistBound;
					lowerbound[distance + match] = avatarx + lowDistBound;
					count = 0;
				}
				match++;
			}
		} else {
			int count = 0;
			int match = 0;
			int upDistBound = distance;
			int lowDistBound = distance;
			for (int i = distance; i >= 0; i--) {
				if (count == 0) {
					upperbound[i] = avatarx - upDistBound;
					upperbound[distance + match] = avatarx - upDistBound;
					lowerbound[i] = avatarx + lowDistBound;
					lowerbound[distance + match] = avatarx + lowDistBound;
					count++;
				} else {
					upDistBound--;
					upperbound[i] = avatarx - upDistBound;
					upperbound[distance + match] = avatarx - upDistBound;
					lowerbound[i] = avatarx + lowDistBound;
					lowerbound[distance + match] = avatarx + lowDistBound;
					lowDistBound--;
					count = 0;
				}
				match++;
			}
		}
	}

	protected abstract void scaleXandY(int x, int y);
}
