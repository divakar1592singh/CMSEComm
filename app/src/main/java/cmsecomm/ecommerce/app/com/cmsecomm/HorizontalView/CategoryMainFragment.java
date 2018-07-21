package cmsecomm.ecommerce.app.com.cmsecomm.HorizontalView;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cmsecomm.ecommerce.app.com.cmsecomm.MainActivity;
import cmsecomm.ecommerce.app.com.cmsecomm.ProductActivity;
import cmsecomm.ecommerce.app.com.cmsecomm.R;
import cmsecomm.ecommerce.app.com.cmsecomm.Utils.Navigator;

/**
 * Created by Divakar on 5/27/2017.
 */

public class CategoryMainFragment extends Fragment{
    private Context mContext;
    //  private Activity mActivity;

    private LinearLayout mLinearLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private Random mRandom = new Random();

    // Initialize a new BroadcastReceiver instance
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Receive the broadcast message
            int receivedColor = intent.getIntExtra("Color", Color.WHITE);
            mLinearLayout.setBackgroundColor(receivedColor);
        }
    };

    //ArrayList
    int[] imgList = {
            R.drawable.ic_camera,
            R.drawable.ic_cloth,
            R.drawable.ic_coffee,
            R.drawable.ic_game,
            R.drawable.ic_grocerry,
            R.drawable.ic_icecream,
            R.drawable.ic_jeweller,
            R.drawable.ic_mobile,
            R.drawable.ic_music,
            R.drawable.ic_pizza

    };

    String[] nameList = {"Camera", "Cloth", "Coffee", "Game", "Grocery", "Icecream", "Jeweller", "Mobile", "Music", "Pizza" };


    // VIEW
    View itemView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_category_main, container, false);

        // Get the application context
        mContext = itemView.getContext();

        // Register the Local Broadcast
        LocalBroadcastManager.getInstance(mContext).registerReceiver(
                mBroadcastReceiver,
                new IntentFilter("BROADCAST_COLOR")
        );

        // Get the widgets reference from XML layout
        mLinearLayout = (LinearLayout) itemView.findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view);

        // Specify a layout for RecyclerView
        // Create a horizontal RecyclerView
        mLayoutManager = new LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false
        );
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new colors list
        List<String> colors = new ArrayList<>();

        // Put some colors on the list
        for (int i=0;i<imgList.length;i++){
            // Add a random color to the list
            colors.add(getRandomHSVColor() + "");
        }
        // Initialize a new Adapter for RecyclerView
        String color = "#000000";
        mAdapter = new CategoryAdapter(mContext,color, imgList, nameList);

        // Set an adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Navigator.getClassInstance().navigateToActivity((Activity) mContext, ProductActivity.class);
                return true;
            }
        });
        return itemView;
    }

    // Custom method to generate random HSV color
    public int getRandomHSVColor(){
       /* // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);
        // We make the color depth full
        float saturation = 1.0f;
        // We make a full bright color
        float value = 1.0f;
        // We avoid color transparency
        int alpha = 255;
        // Finally, generate the color
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color*/
        return R.color.white;
    }
}
