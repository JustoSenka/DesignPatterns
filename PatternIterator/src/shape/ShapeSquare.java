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
public class ShapeSquare extends Shape {

    public ShapeSquare(){
        super.setId(ShapeName.SQUARE);
    }
    
    @Override
    public void draw(Graphics2D g2) {
        g2.drawRect(50, 200, 50, 50);
    }
}
