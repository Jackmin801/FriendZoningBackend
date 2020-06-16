package com.meowmeow.dhateapp.Adapter;

class TinderAPIreply {
    private Meta meta;
    private Data data;

    public TinderAPIreply(){};
    public TinderAPIreply(Meta meta, Data data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
