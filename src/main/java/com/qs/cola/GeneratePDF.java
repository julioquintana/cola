package com.qs.cola;

import java.io.FileOutputStream;

import org.springframework.scheduling.annotation.Async;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {
	static final String DIRECCION = "C:\\pdf\\";
	static final String DIRECCION_IMG = "C:\\Users\\user\\Pictures\\";

	@Async
	public Runnable writePDF(int name) {
		
		try {
			//Thread.sleep(5000);
			Document document = new Document(PageSize.LETTER, 80, 80, 50, 50);
			FileOutputStream salida = new FileOutputStream(DIRECCION + "archivo" + String.valueOf(name) + ".pdf");

			PdfWriter writer = PdfWriter.getInstance(document, salida);
			writer.setInitialLeading(0);

			Paragraph paragraph = new Paragraph();
			paragraph.add("Primera linea del documento: " + name);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);

			Image image = Image.getInstance(DIRECCION_IMG + "solid.jpeg");
			Image image2 = Image.getInstance(DIRECCION_IMG + "1.png");
			Image image3 = Image.getInstance(DIRECCION_IMG + "2.png");
			Image image4 = Image.getInstance(DIRECCION_IMG + "3.png");
			Image image5 = Image.getInstance(DIRECCION_IMG + "4.png");
			Image image6 = Image.getInstance(DIRECCION_IMG + "5.png");
			Image image7 = Image.getInstance(DIRECCION_IMG + "6.png");
			Image image8 = Image.getInstance(DIRECCION_IMG + "7.png");
		
			//image6.scaleToFit(400, 400);
			image.setAlignment(Chunk.ALIGN_CENTER);

			Paragraph paragraph_2 = new Paragraph();
			paragraph_2.setFont(new Font(FontFactory.getFont("Courier", 12, Font.BOLD, BaseColor.ORANGE)));
			paragraph_2.add("Ultima linea del documento");
			paragraph_2.setAlignment(Paragraph.ALIGN_LEFT);

			document.open();
			document.add(paragraph);
			
				document.add(image);
				document.add(image2);
				document.add(image3);
				document.add(image4);
				document.add(image5);
				document.add(image6);
				document.add(image7);
				document.add(image8);
			document.add(paragraph_2);
			document.close();
		
			 
		} catch (Exception e) {

		}
		 return () -> {
	            System.out.printf("running task %d. Thread: %s%n",
	                              name,
	                              Thread.currentThread().getName());
			 };

	}

}
