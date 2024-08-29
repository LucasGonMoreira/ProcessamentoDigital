import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagem1 {
    public static void main(String[] args) throws IOException {

        String img = "src\\ImagePath\\Imagem1.jpg";
        BufferedImage imagem = ImageIO.read(new File(img));

        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imagemNova = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int largura = 0; largura< width; largura++){
            for (int altura=0; altura<height; altura++){

                int rgb = imagem.getRGB(largura,altura);

                Color cor = new Color(rgb);

                int green = cor.getGreen();
                int red = cor.getRed();
                int blue = cor.getBlue();
                int cinza = (green+red+blue)/3;

                if (cinza >= 150){
                    imagemNova.setRGB(largura,altura,Color.BLACK.getRGB());
                }else{
                    imagemNova.setRGB(largura,altura,Color.WHITE.getRGB());
                }

            }
        }
        ImageIO.write(imagemNova,"jpg",new File("src\\ImagePath\\imagem1_nova.jpg"));
    }
}