package Load;

import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.behavior.movement.FlyingBehavior;

public class MovementBehaviorFactory {

    private static MovementBehavior[] movementBehaviors = new MovementBehavior[2];
    private static MovementBehaviorFactory instance = null;

    private MovementBehaviorFactory() {
        movementBehaviors[0] = ClassicMovementBehavior.getInstance();
        movementBehaviors[1] = FlyingBehavior.getInstance();
    }
    public static MovementBehaviorFactory getInstance() {

        if(instance == null) {
            instance = new MovementBehaviorFactory();
            return instance;
        }
        else {
            return instance;
        }
    }

    public MovementBehavior get(int id) throws Exception {
       if(id >= movementBehaviors.length) {
           throw new Exception("Not valid movement id: " + id);
       }
        return movementBehaviors[id];
    }

}
