package Load;

import model.prerequisite.*;

public class PrerequisiteFactory {
    private static PrerequisiteFactory instance = null;

    public static PrerequisiteFactory getInstance() {
        if(instance == null) {
           instance = new PrerequisiteFactory();
        }

        return instance;
    }

    private PrerequisiteFactory(){
    }

    public Prerequisite get(int prereqId, int magnitude) throws Exception {
        switch (prereqId) {
            case 0:
                return new RequireAffinity(magnitude);
            case 1:
                return new RequireAgility(magnitude);
            case 2:
                return new RequireArmor(magnitude);
            case 3:
                return new RequireBane(magnitude);
            case 4:
                return new RequireBargain(magnitude);
            case 5:
                return new RequireBindWounds(magnitude);
            case 6:
                return new RequireBoon(magnitude);
            case 7:
                return new RequireBrawl(magnitude);
            case 8:
                return new RequireCreep(magnitude);
            case 9:
                return new RequireCurrentHP(magnitude);
            case 10:
                return new RequireCurrentMP(magnitude);
            case 11:
                return new RequireDefense(magnitude);
            case 12:
                return new RequireEnchantment(magnitude);
            case 13:
                return new RequireExperience(magnitude);
            case 14:
                return new RequireHardiness(magnitude);
            case 15:
                return new RequireIntellect(magnitude);
            case 16:
                return new RequireLevel(magnitude);
            case 17:
                return new RequireMaxLife(magnitude);
            case 18:
                return new RequireMaxMana(magnitude);
            case 19:
                return new RequireMovement(magnitude);
            case 20:
                return new RequireObservation(magnitude);
            case 21:
                return new RequireOffense(magnitude);
            case 22:
                return new RequireOneHanded(magnitude);
            case 23:
                return new RequirePickpocket(magnitude);
            case 24:
                return new RequireRangedWeapon(magnitude);
            case 25:
                return new RequireStaff(magnitude);
            case 26:
                return new RequireStrength(magnitude);
            case 27:
                return new RequireTrapping(magnitude);
            case 28:
                return new RequireTwoHanded(magnitude);
            default:
                throw new Exception("Not valid prereq id");

        }
    }
}
