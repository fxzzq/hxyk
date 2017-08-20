import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args)throws Exception {
		//1读入图片
		BufferedImage sourceImg=ImageIO.read(new File("f:/meizi.png"));
		int w=sourceImg.getWidth();
		int h=sourceImg.getHeight();
		Graphics2D g=(Graphics2D)sourceImg.getGraphics();
		//2选择要绘制的文字
		String watermaskText="版权所有，盗版必究！";
		//3设置画笔的字体和颜色
		Font f=new Font("黑体", Font.BOLD, 50);
		g.setColor(Color.RED);
		g.setFont(f);
		//4设置透明度
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		//5添加旋转
		g.rotate(Math.toRadians(-30));
		//6绘制图片
		TextLayout layout=new TextLayout(watermaskText, f, g.getFontRenderContext());
		Rectangle2D bounds = layout.getBounds();
		//水印文字的高宽
		int textW=(int)bounds.getWidth();
		int textH=(int)bounds.getHeight();
		//间隔
		int intervalX=80;
		int intervalY=80;
		for(int x=-w;x<w;x+=(intervalX+textW)) {
			for(int y=-h;y<h;y+=(intervalY+textH)) {
				g.drawString(watermaskText, x, y);
			}
		}
		//7写出水印图片
		ImageIO.write(sourceImg, "png", new File("f:/1.png"));
	}
}
