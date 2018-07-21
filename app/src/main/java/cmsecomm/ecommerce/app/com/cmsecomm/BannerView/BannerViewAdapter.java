package cmsecomm.ecommerce.app.com.cmsecomm.BannerView;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cmsecomm.ecommerce.app.com.cmsecomm.R;

public class BannerViewAdapter extends PagerAdapter {

    Context mContext;
    int[] pageCount;
    LayoutInflater mInflater;
    View viewPage;
    BannerViewAdapter(Context mContext, int[] pageCount)
    {
        this.mContext = mContext;
        this.pageCount = pageCount;
    }
    @Override
    public int getCount() {
        return pageCount.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewPage = mInflater.inflate(R.layout.fragment_banner_view, container, false);

        ImageView ivPage = (ImageView)viewPage.findViewById(R.id.idPageIV) ;

        // Bitmap bmPage = BitmapFactory.decodeFile(pageCount[position]);
        //  ivPage.setImageBitmap(bmPage);
        ivPage.setImageResource(pageCount[position]);

        container.addView(viewPage);
        return viewPage;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //  super.destroyItem(container, position, object);
        container.removeView((ConstraintLayout) object);
    }
}
