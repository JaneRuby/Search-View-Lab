package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ShoppingSQLiteOpenHelper extends SQLiteOpenHelper{


    public Cursor showAllGroceries() {
               SQLiteDatabase db = getReadableDatabase();

                Cursor cursor = db.query(SHOPPING_LIST_TABLE_NAME,
                                new String[]{COL_ID,COL_ITEM_NAME},
                                null,
                                null,
                                null, null, null);

                        return cursor;
    }

                public Cursor searchGroceryNames(String query) {
                SQLiteDatabase db = getReadableDatabase();

                        Cursor cursor = db.query(SHOPPING_LIST_TABLE_NAME,
                                new String[]{COL_ID,COL_ITEM_NAME},
                                COL_ITEM_NAME + " LIKE + ?",
                                new String[]{"%"+query+"%"},
                                null, null, null);

                        return cursor;
            }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SHOPPING_LIST_TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
