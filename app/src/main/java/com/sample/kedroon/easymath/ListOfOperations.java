package com.sample.kedroon.easymath;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListOfOperations extends ArrayAdapter<String> {
    static class ViewHolderItem {
        TextView textViewItem;
        ImageView imageViewItem;

    }

    private final Activity context;
    private final String[] text;
    private final Integer[] imageId;

    public ListOfOperations(Activity context, String[] text, Integer[] imageId) {
        super(context, R.layout.operations, text);
        this.context = context;
        this.text = text;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.operations, parent, false);
            // well set up the ViewHolder
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.textViewItem = (TextView) convertView.findViewById(R.id.txt);
            viewHolderItem.imageViewItem = (ImageView) convertView.findViewById(R.id.img);
            // store the holder with the view.

            convertView.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }

        if (text[position] != null && imageId[position] != null) {
            viewHolderItem.textViewItem.setText(text[position]);
            viewHolderItem.imageViewItem.setImageResource(imageId[position]);
        }

        return convertView;

    }
}

/*public class ListOfOperations extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public ListOfOperations(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.operations, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.operations, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
} */


