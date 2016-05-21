package com.example.vyomkeshjha.dps_h.homeRender;

import android.content.Context;

import java.io.IOException;

/**
 * Created by vyomkeshjha on 21/05/16.
 */
public class AssetList {




    private boolean listAssetFiles(String path, Context context) {

        String [] list;
        try {
            list = context.getAssets().list(path);
            if (list.length > 0) {
                // This is a folder
                for (String file : list) {

                }
            } else {
                // This is a file
                // TODO: add file name to an array list
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
