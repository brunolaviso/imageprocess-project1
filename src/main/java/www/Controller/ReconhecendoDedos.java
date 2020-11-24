package www.Controller;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;
import java.io.File;

public class ReconhecendoDedos {

    public static void main(String[] args) {
        String[] PathImgs = new String[61];
        double[] meansImgs = new double[61];
        ImagePlus img;
        ImageProcessor ip;
        GaussianBlur gb = new GaussianBlur();

        for (int i = 1; i <= 30; i++) {
            PathImgs[i] = new File(String.format("assets/1/1 dedo/d - %d.png", i)).getPath();//ImageIO.read(new File();
            System.out.println(PathImgs[i]);
            img = ij.IJ.openImage(PathImgs[i]); // Teste para leitura
            //Imagemteste.show(); // Teste para exibição das imagens EM LOTE!

            ip = img.getProcessor();
            gb.blur(ip, 5);
            ip.autoThreshold();

            meansImgs[i] = ip.getStatistics().mean;
            System.out.println(meansImgs[i]);
        }
        
        for (int i = 1; i <= 30; i++) {
            PathImgs[i] = new File(String.format("assets/3/3 dedos/d - %d.png", i)).getPath();//ImageIO.read(new File();
            System.out.println(PathImgs[i]);
            img = ij.IJ.openImage(PathImgs[i]); // Teste para leitura
            //Imagemteste.show(); // Teste para exibição das imagens EM LOTE!

            ip = img.getProcessor();
            gb.blur(ip, 5);
            ip.autoThreshold();

            meansImgs[i+30] = ip.getStatistics().mean;
            System.out.println(meansImgs[i]);
        }
    }
}
