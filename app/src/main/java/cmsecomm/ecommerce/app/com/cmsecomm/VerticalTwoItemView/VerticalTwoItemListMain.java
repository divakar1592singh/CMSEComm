package cmsecomm.ecommerce.app.com.cmsecomm.VerticalTwoItemView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cmsecomm.ecommerce.app.com.cmsecomm.R;
/**
 * Created by Divakar on 5/31/2017.
 */

public class VerticalTwoItemListMain extends Fragment {

        private RecyclerView mRecyclerView;
        private VerticalTwoItemListAdapter adapter;
        private List<VerticalTwoItemListModel> itemList;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View baseView = inflater.inflate(R.layout.fragment_vertical_twoitem_list_main, container, false);


            mRecyclerView = (RecyclerView) baseView.findViewById(R.id.recycler_view);

            itemList = new ArrayList<>();
            adapter = new VerticalTwoItemListAdapter(baseView.getContext(), itemList);

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(baseView.getContext(), 2);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(0), true));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(adapter);

            prepareItemData();

            return baseView;
        }

        /**
         * Adding few albums for testing
         */
        private void prepareItemData() {
            int[] covers = new int[]{
                    R.drawable.thumb1,
                    R.drawable.thumb2,
                    R.drawable.thumb3,
                    R.drawable.thumb4,
                    R.drawable.thumb5,
                    R.drawable.thumb6,
                    R.drawable.thumb7,
                    R.drawable.thumb8,
                    R.drawable.thumb9,
                    R.drawable.thumb10,
                    R.drawable.thumb11};

            VerticalTwoItemListModel a = new VerticalTwoItemListModel(covers[0], "Camera", "7500");
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[1], "T-Shirt", "9500" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[2], "Dry Fruit", "5000" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[3], "Philips Dryer", "4000" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[4], "Burger", "1000" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[5], "Hair Dryer", "2500" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[6], "Laptop", "2000" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[7], "Medicine", "4800" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[8], "Mobile", "3000" );
            itemList.add(a);

            a = new VerticalTwoItemListModel(covers[9], "Shoes", "5000" );
            itemList.add(a);

            adapter.notifyDataSetChanged();
        }

        /**
         * RecyclerView item decoration - give equal margin around grid item
         */
        public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

            private int spanCount;
            private int spacing;
            private boolean includeEdge;

            public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
                this.spanCount = spanCount;
                this.spacing = spacing;
                this.includeEdge = includeEdge;
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view); // item position
                int column = position % spanCount; // item column

                if (includeEdge) {
                    outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                    outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                    if (position < spanCount) { // top edge
                        outRect.top = spacing;
                    }
                    outRect.bottom = spacing; // item bottom
                } else {
                    outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                    outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                    if (position >= spanCount) {
                        outRect.top = spacing; // item top
                    }
                }
            }
        }

        /**
         * Converting dp to pixel
         */
        private int dpToPx(int dp) {
            Resources r = getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        }
    }
