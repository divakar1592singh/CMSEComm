package cmsecomm.ecommerce.app.com.cmsecomm.VerticalTwoItemView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

import cmsecomm.ecommerce.app.com.cmsecomm.R;

/**
 * Created by Divakar on 5/31/2017.
 */

    public class VerticalTwoItemListAdapter extends RecyclerView.Adapter<VerticalTwoItemListAdapter.MyViewHolder> {

        private Context mContext;
        private List<VerticalTwoItemListModel> twoItemList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView mTitle, mSubTitle;
            public ImageView mImage;

            public MyViewHolder(View view) {
                super(view);
                mTitle = (TextView) view.findViewById(R.id.title);
                mSubTitle = (TextView) view.findViewById(R.id.count);
                mImage = (ImageView) view.findViewById(R.id.thumbnail);
            }
        }


        public VerticalTwoItemListAdapter(Context mContext, List<VerticalTwoItemListModel> twoItemList) {
            this.mContext = mContext;
            this.twoItemList = twoItemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_vertical_twoitem_list, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            VerticalTwoItemListModel album = twoItemList.get(position);
            holder.mTitle.setText(album.getTitle());
            holder.mSubTitle.setText(album.getSubTitle() + " Rs.");

            // loading album cover using Glide library
            Glide.with(mContext).load(album.getThumbnail()).into(holder.mImage);

        }

        @Override
        public int getItemCount() {
            return twoItemList.size();
        }
    }