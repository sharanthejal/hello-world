package com.sharan.java.image;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
//Java program to demonstrate read and write of image 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageCp {
	public static void main(String args[]) throws IOException {
		int width = 1020; // width of the image
		int height = 510; // height of the image

		// This can be taken from args
		int noOfOutPutImages = 3;

		List<String> productIds = new ArrayList<String>();
		String csvFile = "C:\\Users\\l.sharantheja\\Documents\\products.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		// For storing image in RAM
		BufferedImage image = null;

		// READ IMAGE
		try {

			br = new BufferedReader(new FileReader(csvFile));
			String header = br.readLine();
			System.out.println(header);
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] productId = line.split(csvSplitBy);
				productIds.add(productId[0]);

			}

			File input_file = new File("C:\\Users\\l.sharantheja\\Pictures\\panda.jpg"); // image file path

			/*
			 * create an object of BufferedImage type and pass as parameter the width,
			 * height and image int type.TYPE_INT_ARGB means that we are representing the
			 * Alpha, Red, Green and Blue component of the image pixel using 8 bit integer
			 * value.
			 */
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			// Reading input file
			image = ImageIO.read(input_file);

			System.out.println("Reading complete.");
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// WRITE IMAGE
		try {
			// Output file path
			File output_file = null;
			for (String i : productIds) {
				for (int j = 0; j < noOfOutPutImages; j++) {
					output_file = new File("C:\\Users\\l.sharantheja\\Pictures\\output1\\" + i+"_"+j + ".jpg");
					// Writing to file taking type and path as
					ImageIO.write(image, "jpg", output_file);
				}
			}

			System.out.println("Writing complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}// main() ends here
}// class ends here
