package mvc_bridgeway.control.physical_control;

// @author comcc_000

public class KeyboardControl extends PhysicalControl {

    /*Properties*/
    
    private int keycode;

    /*Constructors*/
    
    public KeyboardControl(int keycode) {
        super();
        this.keycode = keycode;
    }

    /*Methods*/
    
    @Override
    public boolean equals(Object o) {
        KeyboardControl kc = (KeyboardControl)o;
        return this.keycode == kc.getKeycode();
    }

    /*Get-Sets*/
    
    public int getKeycode() {
        return keycode;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
