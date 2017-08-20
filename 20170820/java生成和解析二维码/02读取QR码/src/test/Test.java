package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Test {
	public static void main(String[] args) throws Exception{
		//1读取图片
		BufferedImage img = ImageIO.read(new File("F:/1.png"));
		//2转化为亮度数据源
		LuminanceSource luminanceSource=new BufferedImageLuminanceSource(img);
		//3使用转换器把亮度数据源转换为二进制位数据
		Binarizer binarizer=new HybridBinarizer(luminanceSource);
		//4二进制位数据转换位二进制位图
		BinaryBitmap binaryBitmap=new BinaryBitmap(binarizer);
		//5读取内容
		MultiFormatReader formatReader=new MultiFormatReader();
		HashMap<DecodeHintType, Object> hints=new HashMap<>();
		//hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
		Result result = formatReader.decode(binaryBitmap, hints);
		String contents=result.getText();
		System.out.println(contents);
	}
}
