package model.entity.detection;

import model.entity.Entity;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class Detection {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> detectionRequirements;

    /**
     * CONSTRUCTORS
     */

    public Detection() {
        this.detectionRequirements = new ArrayList<Prerequisite>();
    }

    public Detection(ArrayList<Prerequisite> reqs) {
        this.detectionRequirements = reqs;
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getDetectionRequirements() {
        return this.detectionRequirements;
    }

    /**
     * MUTATORS
     */

    public void setDetectionRequirements(ArrayList<Prerequisite> reqs) {
        this.detectionRequirements = reqs;
    }

    public void addDetectionRequirement(Prerequisite req) {
        getDetectionRequirements().add(req);
    }

    public void removeDetectionRequirement(Prerequisite req) {
        getDetectionRequirements().remove(req);
    }

    public void clearDetectionRequirements() {
        getDetectionRequirements().clear();
    }

    /**
     * IMPLEMENTATIONS
     */

    public boolean canSee(Entity spectator, Entity target) {
        if (!meetsOpposingDetectionRequirements(spectator, target.getDetectionMechanism())) {
            return false;
        }
        else if (!meetsOpposingDetectionRequirements(target, spectator.getDetectionMechanism())) {
            return false;
        }

        return true;
    }

    private boolean meetsOpposingDetectionRequirements(Entity target, Detection opposingReqs) {
        for (Prerequisite req : opposingReqs.getDetectionRequirements()) {
            if (!req.meetsRequirement(target)) {
                return false;
            }
        }

        return true;
    }
}
