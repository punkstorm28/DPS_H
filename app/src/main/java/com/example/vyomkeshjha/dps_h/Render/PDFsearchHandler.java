package com.example.vyomkeshjha.dps_h.Render;

import android.content.Context;
import android.os.ParcelFileDescriptor;


import java.io.IOException;

/**
 * Created by vyomkeshjha on 22/05/16.
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.example.vyomkeshjha.dps_h.R;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;

public class PDFsearchHandler extends Activity {
    PdfReader reader;
    PdfReaderContentParser parser;
    TextExtractionStrategy strategy;

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
        reader=new PdfReader(context.getAssets().open("dps.gif"));

        Log.i("pdf text","file open");
        parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            Log.i("pdf text",strategy.getResultantText());
        }
        reader.close();

    }

}