package com.adapter;

public class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public String request() {
        return adaptee.specificRequest();
    }
}

