package model.entity.stats;

import model.entity.stats.Stats;

public interface StatsVisitor {
	public abstract void visit(Stats stats);
}
