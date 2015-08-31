/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.util.ArrayList;
import shape.ShapeCircle;
import shape.ShapeSquare;
import shape.ShapeRectangle;
import shape.Shape;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import shape.ShapeName;

/**
 *
 * @author JustInG
 */
public class ShapeCache {

    private static final Map<ShapeName, Shape> shapeMap = new Hashtable<>();
    //private static final Hashtable<ShapeName, Shape> shapeMap = new Hashtable<>();
    
    // Paklausk grazeviciaus apie diamond operator ######################
    //** ##########################
    
    public static Shape getShape(ShapeName shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
    
    public static void loadCache() {
        ShapeCircle circle = new ShapeCircle();
        shapeMap.put(circle.getId(), circle);

        ShapeSquare square = new ShapeSquare();
        shapeMap.put(square.getId(), square);

        ShapeRectangle rectangle = new ShapeRectangle();
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
