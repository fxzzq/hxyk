package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class Test {

	public static void main(String[] args) throws Exception {
		MultiFormatWriter writer = new MultiFormatWriter();
		String contents = "你大爷abc你大爷abc你大爷abc你大爷abc你大爷abc你大爷abc你大爷abc";
		int w = 200;
		int h = 200;
		HashMap<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, w, h, hints);
		
		//自定义创建图片绘制
		BufferedImage qr=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				if(bitMatrix.get(x, y)) {
					qr.setRGB(x, y, 0xFF0000);
				}else {
					qr.setRGB(x, y, 0xffffff);
				}
			}
		}
		//1读取logo
		BufferedImage logoImg=ImageIO.read(new File("f:/logo.png"));
		int logoW=30,logoH=30;
				
		Image logoUse=logoImg.getScaledInstance(logoW, logoH, Image.SCALE_FAST);
		//2绘制logo
		Graphics g=qr.getGraphics();
		int logoX=(w-logoW)/2;
		int logoY=(h-logoH)/2;
		g.drawImage(logoUse, logoX, logoY, null);
		
		ImageIO.write(qr, "png", new File("f:/1.png"));
		//MatrixToImageWriter.writeToPath(bitMatrix, "png", new File("f:/1.png").toPath());
	}
}
