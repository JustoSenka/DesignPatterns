/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import shape.Shape;
import java.awt.Graphics2D;

/**
 *
 * @author JustInG
 */
public class ShapeRectangle extends Shape {

    public ShapeRectangle(){
        super.setId(ShapeName.RECTANGLE);
    }
    
    @Override
    public void draw(Graphics2D g2) {
        g2.drawRect(50, 50, 70, 40);
    }
}
