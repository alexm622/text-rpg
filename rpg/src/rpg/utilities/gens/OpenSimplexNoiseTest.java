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
	private static final int WIDTH = 512;
	private static final int HEIGHT = 512;
	private static final double FEATURE_SIZE = 80;

	public double[][] main() throws IOException {
		Random ran = new Random();
		long seed = ran.nextLong();
		double[][] out = new double[HEIGHT][WIDTH];

		OpenSimplexNoise noise = new OpenSimplexNoise(seed);
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				double value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0.0);
				//System.out.println(value);
				if(value < 0) {
					value = Math.round(value * 50.0) / 50.0;
				}else {
					value = Math.round(value * 50.0) / 50.0;
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
		ImageIO.write(image, "png", new File("noise.png"));
		return out;
	}
}