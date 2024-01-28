package ca.com.toronto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import ca.com.testtutorials.R
import ca.com.toronto.model.Places
import com.squareup.picasso.Picasso

/**
 * Created by Royal_L on 22-Oct-17.
 */
class MyPlacesAdapter(private val context: Context, private val placesList: List<Places>) :
    ArrayAdapter<Places?>(context, 0, placesList) {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Places {
        return placesList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        if (convertView == null) {
            val view = mInflater.inflate(R.layout.row_layout_places, parent, false)
            viewHolder = ViewHolder.create(view as RelativeLayout)
            view.setTag(viewHolder)
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        val placesItem = getItem(position)
        """
                ${placesItem.id}
                ${placesItem.name}
                
                ${placesItem.rating}
                ${placesItem.geometry?.location?.lng}
                ${placesItem.geometry?.location?.lat}
                --------
                """.trimIndent().also { viewHolder.textViewName.text = it }
        """
                ${placesItem.reference}
                ${placesItem.scope}
                
                """.trimIndent().also { viewHolder.textViewId.text = it }
        Picasso.get().load(placesItem.icon).placeholder(R.drawable.app_icon)
            .error(com.google.android.gms.auth.api.R.drawable.common_google_signin_btn_icon_dark)
            .into(viewHolder.imageView)
        return viewHolder.rootView
    }

    private class ViewHolder(
        val rootView: RelativeLayout,
        val imageView: ImageView,
        val textViewName: TextView,
        val textViewId: TextView
    ) {
        companion object {
            fun create(rootView: RelativeLayout): ViewHolder {
                val imageView = rootView.findViewById<ImageView>(R.id.imageView)
                val textViewName = rootView.findViewById<TextView>(R.id.textViewName)
                val textViewEmail = rootView.findViewById<TextView>(R.id.textViewId)
                return ViewHolder(rootView, imageView, textViewName, textViewEmail)
            }
        }
    }
}
