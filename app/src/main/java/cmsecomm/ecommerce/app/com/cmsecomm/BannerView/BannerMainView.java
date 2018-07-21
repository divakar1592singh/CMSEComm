package cmsecomm.ecommerce.app.com.cmsecomm.BannerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cmsecomm.ecommerce.app.com.cmsecomm.R;


    public class BannerMainView extends Fragment {

        private View itemView;
        int[] imgList = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5
        };
        private ViewPager mViewPager;
        private LinearLayout mDotLayout;
        private ImageView[] dotImageIndicator;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            itemView = inflater.inflate(R.layout.fragment_banner_main, container, false);

            mViewPager = (ViewPager)itemView.findViewById(R.id.idVPager);
            mDotLayout = (LinearLayout)itemView.findViewById(R.id.idDotLayout);

            PagerAdapter mPagerAdapter = new BannerViewAdapter(itemView.getContext(), imgList);
            mViewPager.setAdapter(mPagerAdapter);

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    for(int i = 0; i<imgList.length;i++) {
                        dotImageIndicator[i].setImageResource(R.drawable.ic_dot_white); }
                    dotImageIndicator[position].setImageResource(R.drawable.ic_dot_black);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            // ADDING DOT
            dotImageIndicator=new ImageView[imgList.length];
            try {
                for (int i = 0; i < imgList.length; i++) {
                    //  String test = files[i];
                    dotImageIndicator[i] = new ImageView(itemView.getContext());
                    dotImageIndicator[i].setImageResource(R.drawable.ic_dot_white);
                    dotImageIndicator[i].setPadding(10, 0, 10, 0);
                    mDotLayout.addView(dotImageIndicator[i]);
                }
                dotImageIndicator[0].setImageResource(R.drawable.ic_dot_black);
            }catch (ArrayIndexOutOfBoundsException aioe)
            {
                Log.e("TAG", "Err : "+aioe, aioe);
            }

            //  container.addView(itemView);
            return itemView;
        }
    }
