package com.example.android.popularmoviesbrynn;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();



    static final List<String> postersList = Arrays.asList(
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

        //ImageAdapter adapter = new ImageAdapter(getActivity());
        ImageAdapter adapter = new ImageAdapter(getActivity(), 0, postersList);
        gridView.setAdapter(adapter);

        return rootView;
    }


    private class ImageAdapter extends ArrayAdapter<String> {
        private Context mContext;
        private List<String> objects;

        public ImageAdapter(Context c, int resource, List<String> o) {
            super(c, resource, o);
            mContext = c;
            objects = o;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public String getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg").into(imageView);
            //imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }


    }
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_5, R.drawable.sample_5,
            R.drawable.sample_5, R.drawable.sample_5,
            R.drawable.sample_5, R.drawable.sample_5,
            R.drawable.sample_5, R.drawable.sample_5,
            R.drawable.sample_5, R.drawable.sample_5,
            R.drawable.sample_5, R.drawable.sample_5
    };
}
