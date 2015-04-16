package model.prerequisite;

import model.entity.Entity;

public interface Prerequisite {
    boolean meetsRequirement(Entity target);
}
