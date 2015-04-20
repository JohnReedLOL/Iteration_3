package model.entity.npc;

import model.map.coordinate.HexCoordinate;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.screen.TradeScreen;
import view.utility.ObjectRenderer;

/**
 * Created by Troy on 4/20/2015.
 */
public class Merchant extends NPC {
    /**
     * CONSTRUCTORS
     *
     * @param coord
     */
    public Merchant(HexCoordinate coord) {
        super(coord);
    }

    @Override
    public void accept(ObjectRenderer mapObjectRenderer) {
        this.getStatsOwnership().accept(mapObjectRenderer);
        mapObjectRenderer.visit(this);
    }
    
    @Override
    public String talk() {
        (new LaunchScreenCommand(new TradeScreen())).execute();
        return "WEEELCOOOMEEE";
    }
}
