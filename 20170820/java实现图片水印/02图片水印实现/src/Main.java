import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args)throws Exception {
		//1读入原图片和水印图片
		BufferedImage sourceImg = ImageIO.read(new File("f:/meizi.png"));
		int w=sourceImg.getWidth();
		int h=sourceImg.getHeight();
				
		BufferedImage watermaskImg = ImageIO.read(new File("f:/watermask.png"));
		Graphics2D g=(Graphics2D) sourceImg.getGraphics();
		//2设置绘制的透明度
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .2f));
		//3设置旋转
		//g.rotate(Math.toRadians(-30));
		//4缩放水印图片
		Image watermaskImgUse=watermaskImg.getScaledInstance(w, h, Image.SCALE_FAST);
		//5绘制水印图片到原图中
		g.drawImage(watermaskImgUse, 0, 0, null);
		//6输出结果
		ImageIO.write(sourceImg, "png", new File("f:/1.png"));
	}
}
