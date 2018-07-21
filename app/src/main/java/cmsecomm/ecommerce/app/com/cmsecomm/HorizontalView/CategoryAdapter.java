package cmsecomm.ecommerce.app.com.cmsecomm.HorizontalView;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cmsecomm.ecommerce.app.com.cmsecomm.R;


/**
 * Created by Divakar on 5/27/2017.
 */

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
        private Context mContext;
        private String color;
        int[] imgIV;
        String[] nameTV;
        public CategoryAdapter(Context context, String color, int[] imgIV, String[] nameTV){
            mContext = context;
            this.color = color;
            this.imgIV = imgIV;
            this.nameTV = nameTV;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public CardView mCardView;
            public ImageView mImageView;
            public TextView mTextView;
            public View mView;

            public ViewHolder(View v){
                super(v);
                // Get the widget reference from the custom layout
                mCardView = (CardView) v.findViewById(R.id.card_view);
                mImageView = (ImageView)v.findViewById(R.id.imageView);
                mTextView = (TextView) v.findViewById(R.id.tv);
                mView = v.findViewById(R.id.idView);
            }
        }

        @Override
        public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(mContext).inflate(R.layout.fragment_custom_category,parent,false);
            ViewHolder vh = new ViewHolder(v);

            // Return the ViewHolder
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position){

            // Set the CardVIew background color
            holder.mCardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            //holder.mCardView.setCardBackgroundColor(colorValue);

            // Set the ImageView
            holder.mImageView.setImageResource(imgIV[position]);

            // Set the TextView
            holder.mTextView.setText(nameTV[position]);
            // Set the TextView Color
            holder.mTextView.setTextColor(Color.parseColor(color));

            // Set the View Color
            holder.mView.setBackgroundColor(Color.parseColor(color));

            // Set a click listener for CardView
      /*  holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new Intent
                Intent intent = new Intent("BROADCAST_COLOR");
                intent.putExtra("Color",colorValue);

                // Broadcast the selected color value
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            }
        });*/
        }

        @Override
        public int getItemCount(){
            // Count the items
            return imgIV.length;
        }
    }