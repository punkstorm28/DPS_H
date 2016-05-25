package com.example.vyomkeshjha.dps_h.Render;

import android.content.Context;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

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
    ArrayList<String> PageList;
    PDFsearchHandler(Context context)
    {
        PageList = new ArrayList<String>();
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
            String Page = strategy.getResultantText();
            PageList.add(Page);
            Log.i("pdf text",Page);
        }
        search("agai");
        reader.close();

    }
    public ArrayList search(String searchString)
    {
        ArrayList<String> outList= new ArrayList<String>();
        for(String page:PageList)
        {
           
            if(page.contains(searchString))
            {

                String[] breakups = page.split(".");
                ArrayList<String> tempList = new ArrayList<String >();
                tempList = (ArrayList) Arrays.asList(tempList);
                for(String iterator:tempList)
                {
                    if (iterator.contains(searchString))
                    {
                        outList.add(iterator);
                    }
                }

            }
        }
        Log.i("outlist"," "+outList);
        return outList;
    }
}