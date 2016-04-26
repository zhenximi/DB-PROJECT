package etc;

/**
 * Created by sulei on 4/25/16.
 */
public enum PermissionType {

    open(0),
    friends(1),
    FOF(2),
    self(3);

    private int value;

    private PermissionType(int value) {
        this.value = value;
    }
}