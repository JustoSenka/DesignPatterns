/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternproxy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JustInG
 */
public class ImageReal implements Image {

   private String fileName;
   BufferedImage img = null;

   public ImageReal(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }

   @Override
   public void display() {
      System.out.println("Displaying " + fileName);
   }

   private void loadFromDisk(String fileName){
      System.out.println("Loading " + fileName);
      
       try {
           img = ImageIO.read(new File("strawberry.jpg"));
       } catch (IOException ex) {
           Logger.getLogger(ImageReal.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
