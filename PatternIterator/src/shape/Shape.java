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
public abstract class Shape implements Cloneable {
    
   private ShapeName id;
   
   public abstract void draw(Graphics2D g2);

   public ShapeName getId() {
      return id;
   }
   
   public void setId(ShapeName id) {
      this.id = id;
   }
   
   @Override
   public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }   
}

