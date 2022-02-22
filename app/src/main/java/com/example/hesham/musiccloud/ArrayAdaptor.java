package com.example.hesham.musiccloud;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hesham on 01-Jul-18.
 */

public class ArrayAdaptor extends ArrayAdapter<MusicType> {
    private static final String LO_TAG = ArrayAdaptor.class.getSimpleName();

    public ArrayAdaptor(Activity context, ArrayList<MusicType> x) {
        super(context, 0, x);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        MusicType currentAndroidFlavor = getItem(position);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text1);
        nameTextView.setText(currentAndroidFlavor.getVersionName());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.text2);
        numberTextView.setText(currentAndroidFlavor.getVersionNumber());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image1);
        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return listItemView;
    }
}
