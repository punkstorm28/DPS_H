package com.example.vyomkeshjha.dps_h.homeRender;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by vyomkeshjha on 21/05/16.
 */
public class AssetList {


    public List listAssetFiles(Context context) {

        AssetManager assetManager = context.getAssets();
        String[] files = new String[0];
        try {
            files = assetManager.list("");


        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> FileNameList = Arrays.asList(files);
        ArrayList<String> outList = new ArrayList<String>();
        for (int i = 0; i < FileNameList.size(); i++) {
            String name = FileNameList.get(i);
            if (name.contains("gif")) {
                outList.add(name);
            }


        }
        Log.i("files list ", "" + outList);

        return FileNameList;

    }
}

