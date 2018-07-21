package cmsecomm.ecommerce.app.com.cmsecomm.ProductList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cmsecomm.ecommerce.app.com.cmsecomm.R;

/**
 * Created by Divakar on 6/14/2017.
 */

public class ProductViewHolderAdapter extends RecyclerView.Adapter<ProductViewHolderAdapter.ProdViewHolder> {

    Context mContext;
    int[] imageList;
    String[] title;
    String[] price;
    LayoutInflater layoutInflater;
    ProductViewHolderAdapter(Context mContext, int[] imageList, String[] title, String[] price)
    {
        this.mContext = mContext;
        this.imageList = imageList;
        this.title = title;
        this.price = price;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public static class ProdViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public TextView tvTitle, tvPrice;
        public ProdViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.idProdIV);
            tvTitle = (TextView)itemView.findViewById(R.id.idTitle);
            tvPrice = (TextView)itemView.findViewById(R.id.idProdPrice);
        }
    }

    @Override
    public ProdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View prodView = layoutInflater.inflate(R.layout.custom_product_layout, parent, false);
        ProdViewHolder pvh = new ProdViewHolder(prodView);
        return pvh;

    }

    @Override
    public void onBindViewHolder(ProdViewHolder holder, int position) {

        holder.mImageView.setImageResource(imageList[position]);
        holder.tvTitle.setText(title[position]);
        holder.tvPrice.setText(price[position]);
    }

    @Override
    public int getItemCount() {
        return price.length;
    }

}
