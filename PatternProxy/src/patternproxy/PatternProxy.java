/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternproxy;

/**
 *
 * @author JustInG
 */
public class PatternProxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Image image = new ImageProxy("test_10mb.jpg");

      //image will be loaded from disk
      image.display(); 
      System.out.println("");
      
      //image will not be loaded from disk
      image.display(); 	
    }
    
}
