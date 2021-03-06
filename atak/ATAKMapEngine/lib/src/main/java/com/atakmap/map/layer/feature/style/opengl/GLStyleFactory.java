package com.atakmap.map.layer.feature.style.opengl;

import android.util.Pair;

import com.atakmap.map.layer.feature.style.Style;
import com.atakmap.map.layer.feature.geometry.Geometry;
import com.atakmap.spi.PriorityServiceProviderRegistry2;

public final class GLStyleFactory {

    private final static PriorityServiceProviderRegistry2<GLStyle, Pair<Style, Geometry>, GLStyleSpi> registry = new PriorityServiceProviderRegistry2<GLStyle, Pair<Style, Geometry>, GLStyleSpi>();
    
    public static void register(GLStyleSpi spi) {
        registry.register(spi, spi.getPriority());
    }
    
    public static void unregister(GLStyleSpi spi) {
        registry.unregister(spi);
    }
    
    public static GLStyle create(Pair<Style, Geometry> arg) {
        return registry.create(arg);
    }
}
