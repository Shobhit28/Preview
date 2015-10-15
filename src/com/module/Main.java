package com.module;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aspose.cells.Workbook;
import com.aspose.pdf.SaveFormat;
import com.aspose.slides.PdfCompliance;
import com.aspose.slides.PdfOptions;
import com.aspose.slides.PdfTextCompression;
import com.aspose.slides.Presentation;
import com.aspose.words.Document;

import aspose.pdf.Pdf;

public class  Main extends MultiActionController {
	
	String destiantion="/Users/ss/Documents/workspace/Testing/WebContent/resources/";
	String prev= "/Users/ss/Downloads/apache-tomcat-8.0.24/webapps/Testing/";
	
	public ModelAndView convert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String file = request.getParameter("file_name");
		
		

		String fileName= file.split("\\.")[0];
		String extension = file.split("\\.")[1];
		if(extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase(".docx")){
			
		
		
		}
		

        if(extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("docx")){
        	Document doc = new Document("/Users/ss/Desktop/"+file);
    		doc.save("/Users/ss/Downloads/apache-tomcat-8.0.24/webapps/Testing/"+fileName+".pdf");
        }
        if(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")){
            Workbook workbook = new Workbook("/Users/ss/Desktop/"+file);
            workbook.save("/Users/ss/Downloads/apache-tomcat-8.0.24/webapps/Testing/"+fileName+".pdf",SaveFormat.Pdf);
        }
        if(extension.equalsIgnoreCase("pdf")){
        	File source = new File("/Users/ss/Desktop/"+file);
        	File dest = new File("/Users/ss/Downloads/apache-tomcat-8.0.24/webapps/Testing/");
        	try {
        	    FileUtils.copyFileToDirectory(source, dest);
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
        }
        if(extension.equalsIgnoreCase("ppt") ||extension.equalsIgnoreCase("pptx")){
        	Presentation pres = new Presentation("/Users/ss/Desktop/"+file);

        	//Instantiate the PdfOptions class
        	PdfOptions opts = new PdfOptions();

        	//Set Jpeg Quality
        	opts.setJpegQuality ((byte) 90);

        	//Define behavior for metafiles
        	opts.setSaveMetafilesAsPng ( true);

        	//Set Text Compression level
        	opts.setTextCompression ( PdfTextCompression.Flate);

        	//Define the PDF standard
        	opts.setCompliance(PdfCompliance.Pdf15);

        	//Save the presentation to PDF with specified options
        	pres.save("/Users/ss/Downloads/apache-tomcat-8.0.24/webapps/Testing/"+fileName+".pdf", SaveFormat.Pdf,opts);
        }
		
		
		return null;
	}

}
