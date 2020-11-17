/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.Controller;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Bruno Laviso
 */
public class ImageController {

    public void exibeImagemProcessada(ImageProcessor saida, JLabel label) {
        ImagePlus iplus = new ImagePlus(null, saida);
        
        double scale = (double)label.getHeight() / iplus.getProcessor().getHeight();
        int sizeW = (int) (iplus.getProcessor().getWidth() * scale);
        ImagePlus iplusThumbnail = new ImagePlus(null, iplus.getProcessor().resize(sizeW, label.getHeight()));
        
        label.setText(null);
        label.setIcon(new ImageIcon(iplusThumbnail.getBufferedImage()));
    }
}
