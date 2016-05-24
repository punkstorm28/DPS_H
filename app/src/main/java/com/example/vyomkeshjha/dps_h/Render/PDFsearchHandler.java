package com.example.vyomkeshjha.dps_h.Render;

import android.content.Context;


import java.io.IOException;

/**
 * Created by vyomkeshjha on 22/05/16.
 */

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import android.app.Activity;
import android.util.Log;

public class PDFsearchHandler extends Activity {
    PdfReader reader;
    PdfReaderContentParser parser;
    TextExtractionStrategy strategy;
    static int currentPageIndex=0;
    
    PDFsearchHandler(Context context)
    {
        Log.i("apples","doing it");
        try {
            ReadPDF(context);
        } catch (IOException e) {
            Log.e("apples",e.getMessage());
            e.printStackTrace();
        }
    }
    public void ReadPDF(Context context) throws IOException {
        Log.i("pdf text","file opening");
        reader=new PdfReader(context.getAssets().open("DPS/dps.gif"));

        Log.i("pdf text","file open");
        parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());

            Log.i("pdf text",strategy.getResultantText());
        }
        reader.close();

    }

}