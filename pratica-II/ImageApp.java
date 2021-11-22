
import java.awt.image.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
- Gabriel Medeiros Lopes Carneiro   (19103977)
- Lorenzo Lima Franco Maturano      (19100535)
*/

public class ImageApp   {
	
	// Leitura da imagem
	public static BufferedImage loadImage(String surl) {  
		BufferedImage bimg = null;  
		try {  
			URL url = new URL(surl);
			bimg = ImageIO.read(url);  
			//bimg = ImageIO.read(new File("D:/Temp/mundo.jpg"));
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return bimg;  
	}  
	
	public void apresentaImagem(JFrame frame, BufferedImage img) {
		frame.setBounds(0, 0, img.getWidth(), img.getHeight());
		JImagePanel panel = new JImagePanel(img, 0, 0);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static BufferedImage criaImagemRGB() {
		BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

		WritableRaster raster = img.getRaster();
		
		for(int h=0;h<img.getHeight();h++) //Percorre a horizontal
			for(int w=0;w<img.getWidth();w++) {//Percorre a vertical
				raster.setSample(w,h,0,220); // Componente Vermelho
				raster.setSample(w,h,1,219); // Componente Verde
				raster.setSample(w,h,2,97);  // Componente Azul
			} 
		return img;
	}
	
	public static BufferedImage criaImagemCinza() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<img.getHeight();h++) //Percorre a horizontal
			for(int w=0;w<img.getWidth();w++) {//Percorre a vertical
				raster.setSample(w,h,0,h);//como o h = 0 e vai aumentando, cada linha vai ficando mais clara
			}
		return img;
	}

	public static BufferedImage criaImagemCinza(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
                int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
                int b = (int)(rgb&0x000000FF); //componente azul

                double y = (0.3 * r + 0.59 * g + 0.11 * b);

                raster.setSample(w,h,0,y);
            }

        return convertedImg;
    }
	
	public static BufferedImage criaImagemBinaria() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_BINARY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<img.getHeight();h++) //Percorre a horizontal
			for(int w=0;w<img.getWidth();w++) {//Percorre a vertical
				if (((h/50)+(w/50)) % 2 == 0) 
					raster.setSample(w,h,0,0); // checkerboard pattern.
				else raster.setSample(w,h,0,1); 
			}
		return img;
	}

	public static BufferedImage criaImagemBinaria(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
                int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
                int b = (int)(rgb&0x000000FF); //componente azul

                int y = (int)(0.3 * r + 0.59 * g + 0.11 * b);

                if (y >= 127) {
                    raster.setSample(w,h,0,1);
                } else {
                    raster.setSample(w,h,0,0);
                }
            }

        return convertedImg;
    }

    public static BufferedImage criaImagemR(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                double r = ((rgb&0x00FF0000)>>>16); // componente vermelho

                raster.setSample(w,h,0,r);
            }

        return convertedImg;
    }

    public static BufferedImage criaImagemG(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                double g = ((rgb&0x0000FF00)>>>8); // componente verde

                raster.setSample(w,h,0,g);
            }

        return convertedImg;
    }

    public static BufferedImage criaImagemB(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                double b = (rgb&0x000000FF); //componente azul

                raster.setSample(w,h,0,b);
            }

        return convertedImg;
    }

    public static BufferedImage reduzResolucao(BufferedImage bufferedImage) {
        BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth()/2, bufferedImage.getHeight()/2, BufferedImage.TYPE_INT_RGB);

        WritableRaster raster = convertedImg.getRaster();
        for(int h=0;h<bufferedImage.getHeight();h+=2) //Percorre a horizontal
            for(int w=0;w<bufferedImage.getWidth();w+=2) {//Percorre a vertical
                int rgb = bufferedImage.getRGB(w,h);
                int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
                int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
                int b = (int)(rgb&0x000000FF); //componente azul

                raster.setSample(w/2,h/2,0,r);
                raster.setSample(w/2,h/2,1,g);
                raster.setSample(w/2,h/2,2,b);
            }

        return convertedImg;
    }
	
	// Imprime valores dos pixeis de imagem RGB
	public static void  imprimePixeis(BufferedImage bufferedImage) {
		for(int h=0;h<bufferedImage.getHeight();h++) //Percorre a horizontal
			for(int w=0;w<bufferedImage.getWidth();w++) {//Percorre a vertical
				int rgb = bufferedImage.getRGB(w,h);
				int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
				int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
				int b = (int)(rgb&0x000000FF); //componente azul
				System.out.print("at ("+w+","+h+"): ");
				System.out.println(r+","+g+","+b);
			}
	}

	public static void main(String[] args) {
		ImageApp ia = new ImageApp();
		BufferedImage imgJPEG = loadImage("https://www.inf.ufsc.br/~roberto.willrich/INE5431/RGB1.jpg");
// 		BufferedImage imgRGB = criaImagemRGB();
// 		BufferedImage imgCinza = criaImagemCinza();
// 		BufferedImage imgBinaria = criaImagemBinaria();

        BufferedImage imgBinaria = criaImagemBinaria(imgJPEG);
        BufferedImage imgCinza = criaImagemCinza(imgJPEG);
        BufferedImage imgR = criaImagemR(imgJPEG);
        BufferedImage imgG = criaImagemG(imgJPEG);
        BufferedImage imgB = criaImagemB(imgJPEG);
        BufferedImage imgMetadeResolucao = reduzResolucao(imgJPEG);

// 		ia.apresentaImagem(new JFrame("imgJPEG"), imgJPEG);
// 		ia.apresentaImagem(new JFrame("imgRGB"), imgRGB);
// 		ia.apresentaImagem(new JFrame("imgCinza"), imgCinza);
// 		ia.apresentaImagem(new JFrame("imgBinaria"), imgBinaria);

        // 1 - Reduza de 1/2 a resolução da imagem peixe.jpg e apresente esta imagem.
        ia.apresentaImagem(new JFrame("imgMetadeResolucao"), imgMetadeResolucao);

        // 2 - Transforme a imagem RGB1.jpg em tons de cinza e a apresente.
        ia.apresentaImagem(new JFrame("imgCinza"), imgCinza);

        // 3 - Transforme a imagem RGB1.jpg em imagem binária e a apresenta.
        ia.apresentaImagem(new JFrame("imgBinaria"), imgBinaria);

        /*
        4 - Conforme ilustrado na imagem mais abaixo, realizar a separação (split)
        dos canais RGB de uma imagem colorida, é gerar 3 imagens a partir da
        imagem original, sendo que os pixels da imagem R contém as intensidades
        do componente R dos pixels da imagem original. E as imagens G e B os
        pixels contém as intensidades de G e B, respectivamente, da imagem original.
        Faça uma função que realize a separação dos canais RGB da imagem RGB1, e
        apresente tons de cinza: ImagemR, ImagemG e ImagemB. Na ImagemR, cada pixel
        deve ter a luminosidade proporcional ao componente vermelho  do pixel
        correspondente na imagem original. As ImagemG e ImagemB terão os pixels com
        intensidade luminosa proporcional aos componentes G e B da imagem original.
        */
        ia.apresentaImagem(new JFrame("imgR"), imgR);
        ia.apresentaImagem(new JFrame("imgG"), imgG);
        ia.apresentaImagem(new JFrame("imgB"), imgB);
               
// 		imprimePixeis(imgJPEG);
	}
}