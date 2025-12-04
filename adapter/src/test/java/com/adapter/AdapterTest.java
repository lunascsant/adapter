package com.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {
    @Test
    void testConcreteTargetRequest() {
        Target target = new ConcreteTarget();
        assertEquals("ConcreteTarget response", target.request());
    }

    @Test
    void testAdapteeSpecificRequest() {
        Adaptee adaptee = new Adaptee();
        assertEquals("Adaptee response", adaptee.specificRequest());
    }

    @Test
    void testAdapterRequest() {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        assertEquals("Adaptee response", adapter.request());
    }

    @Test
    void testAdapterWithNullAdaptee() {
        assertThrows(NullPointerException.class, () -> {
            Adapter adapter = new Adapter(null);
            adapter.request();
        });
    }

    @Test
    void testMultipleAdapters() {
        Adaptee adaptee1 = new Adaptee();
        Adaptee adaptee2 = new Adaptee();
        Target adapter1 = new Adapter(adaptee1);
        Target adapter2 = new Adapter(adaptee2);
        assertEquals(adapter1.request(), adapter2.request());
    }
}

