package com;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadTextFromPDF {


	@Test
	public void ReadPDF() throws Exception {
		URL TestURL = new URL("http://www.africau.edu/images/default/sample.pdf");
        InputStream is = TestURL.openStream();
		BufferedInputStream TestFile = new BufferedInputStream(is);
		PDDocument pd = PDDocument.load(TestFile);
		
		String str = new PDFTextStripper().getText(pd);
		
		
		//String TestText = new PDFTextStripper().getText(TestPDF.getPDDocument());

		Assert.assertTrue(str.contains("demonstration"));
System.out.println("Text Present");
		}
}
