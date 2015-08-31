/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Graphics2D;

/**
 *
 * @author JustInG
 */
public class ShapeCircle extends Shape {

    public ShapeCircle(){
        super.setId(ShapeName.CIRCLE);
    }
    
    @Override
    public void draw(Graphics2D g2) {
        g2.drawOval(50, 50, 50, 50);
    }
}
