package ca.com.toronto.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ca.com.toronto.R;
import ca.com.toronto.model.Places;

/**
 * Created by Royal_L on 22-Oct-17.
 */

public class MyPlacesAdapter extends ArrayAdapter<Places> {

    private List<Places> placesList;
    private Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyPlacesAdapter(Context context, List<Places> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        placesList = objects;
    }

    @Nullable
    @Override
    public Places getItem(int position) {
        return placesList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.row_layout_places, parent, false);
            viewHolder = ViewHolder.create((RelativeLayout) view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Places placesItem = getItem(position);
        viewHolder.textViewName.setText(placesItem.getId()+"\n"+placesItem.getName()+"\n"+
        "\n"+placesItem.getRating()+"\n"+placesItem.getGeometry().getLocation().getLng()+"\n"+
                placesItem.getGeometry().getLocation().getLat()+"\n--------");
        viewHolder.textViewId.setText(placesItem.getReference() + "\n" + placesItem.getScope() + "\n" );
        Picasso.with(context).load(placesItem.getIcon()).placeholder(R.drawable.app_icon).error(R.drawable.common_google_signin_btn_icon_dark).into(viewHolder.imageView);
        return viewHolder.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewId;

        public ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewId) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewId = textViewId;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = rootView.findViewById(R.id.imageView);
            TextView textViewName = rootView.findViewById(R.id.textViewName);
            TextView textViewEmail = rootView.findViewById(R.id.textViewId);

            return new ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}
