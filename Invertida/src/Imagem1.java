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

        BufferedImage imagemNova = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        for (int largura=0; largura<width; largura++){
            for (int altura=0; altura<height; altura++){

                int rgb = imagem.getRGB(largura,altura);
                Color cor = new Color(rgb);

                int green = 255-cor.getGreen();
                int red = 255-cor.getRed();
                int blue = 255-cor.getBlue();

                Color novaCor = new Color(red,green,blue);

                imagemNova.setRGB(largura,altura,novaCor.getRGB());

            }
        }
        ImageIO.write(imagemNova, "png", new File("src\\ImagePath\\imagem1_nova.png"));
    }
}