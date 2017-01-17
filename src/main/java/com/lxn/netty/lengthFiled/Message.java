package com.lxn.netty.lengthFiled;

/**
 * Created by Lin Xiangnan on 2017/1/16.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class Message {

    private byte type;
    private byte flag;
    private Object object;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
