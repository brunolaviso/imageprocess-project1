package www.Controller;

import ij.ImagePlus;
import java.io.File;

public class ReconhecendoDedos {

    // 1 ArrayList 60 posicoes
    // foreach preenchendo 30 primeiras com 1 dedo
    // foreach preenchendo 30 ultimas com 3 dedos
    public static void main(String[] args) {
        ImagePlus Imagemteste;
        String[] ArrayDedos = new String[50];
        for (int i = 1; i <= 30; i++) {
            ArrayDedos[i] = new File(String.format("assets/1/1 dedo/d - %d.png", i)).getPath();//ImageIO.read(new File();
            System.out.println(ArrayDedos[i]);
        //Imagemteste = ij.IJ.openImage(ArrayDedos[i]);         - Teste para leitura
        //Imagemteste.show();                                   - Teste para exibição das imagens EM LOTE!
        }
    }
}
