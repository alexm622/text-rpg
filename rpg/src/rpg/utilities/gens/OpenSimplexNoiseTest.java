package rpg.utilities.gens;

/*

 * OpenSimplex Noise sample class.
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.Random;

public class OpenSimplexNoiseTest
{
	
	private int height, width;
	private double feature_size;

	public OpenSimplexNoiseTest(int width, int height, double feature_size){
		this.height = height;
		this.width = width;
		this.feature_size = feature_size;
	}

	public double[][] main() throws IOException {
		Random ran = new Random();
		long seed = ran.nextLong();
		double[][] out = new double[height][width];

		OpenSimplexNoise noise = new OpenSimplexNoise(seed);
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				double value = noise.eval(x / feature_size, y / feature_size, 0.0);
				//System.out.println(value);
				if(value < 0) {
					value = Math.round(value * 100.0) / 100.0;
				}else {
					value = Math.round(value * 100.0) / 100.0;
				}
				double divisor = 2.5;
				double temp;
				temp = value / divisor;
				temp = Math.round(temp * 10.0) / 10.0;
				if(temp != value/divisor) {
					value = temp*divisor;
					//System.out.println(value);
				}
				
				out[y][x] = value*10;
				
				int rgb = 0x010101 * (int)((value + 1) * 127.5);
				image.setRGB(x, y, rgb);
				
			}
		}
		ImageIO.write(image, "png", new File(
			System.getenv("APPDATA") + "\\AlexRpg\\" + "map.png"));
		return out;
	}
}