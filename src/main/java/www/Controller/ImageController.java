/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.Controller;

import ij.ImagePlus;
import ij.plugin.ContrastEnhancer;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import java.io.File;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Bruno Laviso
 */
public class ImageController {
        
    String[] PathImgs = new String[61];
    double[] meansImgs = new double[61];
    ImagePlus img;
    ImageProcessor ip;
    GaussianBlur gb = new GaussianBlur();
    ImageConverter i8bits;
    ContrastEnhancer ce = new ContrastEnhancer();

    public void exibeImagemProcessada(ImageProcessor saida, JLabel label) {
        ImagePlus iplus = new ImagePlus(null, saida);
        
        double scale = (double)label.getHeight() / iplus.getProcessor().getHeight();
        int sizeW = (int) (iplus.getProcessor().getWidth() * scale);
        ImagePlus iplusThumbnail = new ImagePlus(null, iplus.getProcessor().resize(sizeW, label.getHeight()));
        
        label.setText(null);
        label.setIcon(new ImageIcon(iplusThumbnail.getBufferedImage()));
    }
    
    public ImageProcessor processarImagem(ImagePlus img) {
        i8bits = new ImageConverter(img);
        i8bits.convertToGray8();
        img.updateAndDraw();

        ip = img.getProcessor();
        
        ce.equalize(ip);

        //gb.blur(ip, 5);
        ip.autoThreshold();
        
        //img.show(); // TESTE
        
        return ip;
    }

    public double calcularMeanMediano() {
        for (int i = 1; i <= 30; i++) {
            PathImgs[i] = new File(String.format("assets/1/1 dedo/d - %d.png", i)).getPath();
            System.out.println(PathImgs[i]);

            img = ij.IJ.openImage(PathImgs[i]);

            meansImgs[i] = processarImagem(img).getStatistics().mean;
            System.out.println(meansImgs[i]);
        }

        for (int i = 1; i <= 30; i++) {
            PathImgs[i] = new File(String.format("assets/3/3 dedos/d - %d.png", i)).getPath();//ImageIO.read(new File();
            System.out.println(PathImgs[i]);
            
            img = ij.IJ.openImage(PathImgs[i]);

            meansImgs[i + 30] = processarImagem(img).getStatistics().mean;
            System.out.println(meansImgs[i]);
        }

        Arrays.sort(meansImgs);

        /*
        for (int i = 1; i < 61; i++) {
            System.out.println(meansImgs[i]);
        }
         */
        double meanMediano = ((meansImgs[30] + meansImgs[31]) / 2);

        return (meanMediano);
    }
}
