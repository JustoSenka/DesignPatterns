/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternproxy;

import java.awt.image.BufferedImage;

/**
 *
 * @author JustInG
 */
public class ImageProxy implements Image{

   private ImageReal imageReal;
   private String fileName;

   public ImageProxy(String fileName){
      this.fileName = fileName;
   }

   @Override
   public void display() {
      if(imageReal == null){
         imageReal = new ImageReal(fileName);
      }
      imageReal.display();
   }
}
