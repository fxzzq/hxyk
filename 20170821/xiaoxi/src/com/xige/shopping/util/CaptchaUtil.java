package com.xige.shopping.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class CaptchaUtil {

	static public String generateCaptcha(OutputStream out)throws IOException{
		//1随机生成验证码字符串
		String code=generateCode(6);
		//2创建图片
		int w=200;
		int h=50;
		BufferedImage img=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g=(Graphics2D)img.getGraphics();
		//3背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		//4干扰线
		for(int i=100;i-->0;){
			g.setColor(new Color(randomAB(0, 0xffffff)));
			g.drawArc(randomAB(0, w), randomAB(0, h), randomAB(0, w), randomAB(0, w), randomAB(0, 360), randomAB(0, 360));
		}
		//5绘制验证码到图片
		Font f=new Font("黑体",Font.BOLD,30);
		g.setColor(Color.RED);
		g.setFont(f);
		//把文字绘制到居中
		TextLayout layout=new TextLayout(code,f,g.getFontRenderContext());
		Rectangle2D bounds = layout.getBounds();
		int x=(int)(w-bounds.getWidth())/2;
		int y=(int)(h-bounds.getHeight())/2;
		g.drawString(code, (int)(x-bounds.getX()), (int)(y-bounds.getY()));
		//6扭曲或混淆等图片处理
		//7输出图片
		ImageIO.write(img, "png", out);
		return code;
	}
	/*
	 * 随机生成验证码字符串
	 * ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789
	 */
	private static String generateCode(int n){
		final String codes="ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789";
		char[] cs=new char[n];
		for(int i=n;i-->0;){
			cs[i]=codes.charAt(randomAB(0, codes.length()));
		}
		return new String(cs);
	}
	/**
	 * 随机生成a和b之间的数
	 * @param a
	 * @param b
	 * @return
	 */
	private static int randomAB(int a,int b){
		return (int)(Math.random()*Math.abs(a-b))+Math.min(a, b);		
	}
}
