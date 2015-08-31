/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import shape.Shape;
import shape.ShapeCircle;
import shape.ShapeRectangle;
import shape.ShapeSquare;

/**
 *
 * @author JustInG
 */
public class ShapeRepository implements Container {
   private final Shape[] shapes = {new ShapeCircle(), new ShapeSquare(), new ShapeRectangle()};

   @Override
   public Iterator getIterator() {
      return new ShapeIterator();
   }

   private class ShapeIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
         return index < shapes.length;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return shapes[index++];
         }
         return null;
      }		
   }
}