package com.example.android.historyapp.data;

import android.content.Context;

import com.example.android.historyapp.R;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<Castles> generateAndReturnData(Context context) {
        ArrayList<Castles> result = new ArrayList<>();
        Castles warkworth;
        Castles dunstan;
        Castles rising;
        Castles berkhamsted;
        Castles warwick;
        Castles banbury;
        Castles alnwick;
        Castles dover;
        Castles raby;
        Castles caenarven;

        warkworth = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.warkworth_History), R.drawable.castle, R.raw.canon_in_d);
        dunstan = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.dunstan_History), R.drawable.castle, R.raw.canon_in_d);
        rising = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.rising_History), R.drawable.castle, R.raw.canon_in_d);
        berkhamsted = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.berk_History), R.drawable.castle, R.raw.canon_in_d);
        warwick = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.warwick_History), R.drawable.castle, R.raw.canon_in_d);
        banbury = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.banbury_History), R.drawable.castle, R.raw.canon_in_d);
        alnwick = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.alnwick_History), R.drawable.castle, R.raw.canon_in_d);
        dover = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.dover_History), R.drawable.castle, R.raw.canon_in_d);
        raby = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.raby_History), R.drawable.castle, R.raw.canon_in_d);
        caenarven = new Castles("Warkworth", "English Heritage", 4.2, context.getString(R.string.caen_History), R.drawable.castle, R.raw.canon_in_d);

        result.add(warkworth);
        result.add(dunstan);
        result.add(rising);
        result.add(berkhamsted);
        result.add(warwick);
        result.add(banbury);
        result.add(alnwick);
        result.add(dover);
        result.add(raby);
        result.add(caenarven);

        return result;
    }
}
