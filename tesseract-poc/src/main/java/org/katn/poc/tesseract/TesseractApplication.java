/*
 * Created on Sep 9, 2017
 */

package org.katn.poc.tesseract;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * @author Guy Turner
 *
 */
public class TesseractApplication {

	public static void main(String[] args) {
		File imageFile = new File(getFilePath("sample_images/example.PNG"));
		ITesseract instance = new Tesseract(); // JNA Interface Mapping

		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static String getFilePath(String path) {
		return ClassLoader.getSystemResource(path).getPath();
	}
}
