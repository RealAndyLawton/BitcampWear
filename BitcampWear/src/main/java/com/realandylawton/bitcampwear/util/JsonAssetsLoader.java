package com.realandylawton.bitcampwear.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by realandylawton on 10/9/13.
 */

public class JsonAssetsLoader {

    private Context mContext;
    private Gson mGson;

    public JsonAssetsLoader(Context context) {
        mContext = context;
        //mGson = gson;

        GsonBuilder builder = new GsonBuilder();
        mGson = builder.create();
    }

    public <T> T parseFromJsonFile(String fileName, Class<T> type) throws IOException {

        String json = parseAsString(fileName);

        T t = mGson.fromJson(json, type);

        return t;

    }

    public String parseAsString(String filename) throws IOException {

        AssetManager assetManager = mContext.getAssets();

        InputStream in = assetManager.open(filename);

        int size = in.available();
        byte[] buffer = new byte[size];

        in.read(buffer);
        in.close();

        String fileAsString = new String(buffer);

        return fileAsString;

    }

}
