package com.Pdf;

import com.Base.TestBase;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class generatePdf extends TestBase {
    public static void main(String[] args) throws DocumentException, IOException {
    chrome_launch();
    openUrl("https://github.com/SharifMahin");
    CreatePdf("NewPdfcreate");
    chrome_close();
    }

}
