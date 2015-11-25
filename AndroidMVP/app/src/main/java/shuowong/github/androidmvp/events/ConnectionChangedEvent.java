package shuowong.github.androidmvp.events;

/**
 * Created by WANGSHUO on 11/25/15.
 */
public class ConnectionChangedEvent {

    private int typeCode;
    private String typeName;

    public ConnectionChangedEvent(int typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }
}
