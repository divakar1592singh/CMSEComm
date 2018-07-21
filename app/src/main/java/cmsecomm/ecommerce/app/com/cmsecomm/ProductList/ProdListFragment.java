package cmsecomm.ecommerce.app.com.cmsecomm.ProductList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.text.StringCharacterIterator;

import cmsecomm.ecommerce.app.com.cmsecomm.R;

/**
 * Created by Divakar on 6/14/2017.
 */

public class ProdListFragment extends Fragment{


    RecyclerView rcViewProduct;
    RecyclerView.LayoutManager mLayoutManager;
    LinearLayout ll1;
    View itemProdView;
    int[] imageList = {R.drawable.album1, R.drawable.sennheiser, R.drawable.phone, R.drawable.diary, R.drawable.wall};
    String[] title = {"Samsung Camera-XB450", "Sennheiser CX213 ", "MicroMax Canvas C7", "COI A4 Diary (Designer, Black)", "SAF BUDDHA PREMIUM"};
    String[] price = {"12500","20000","13345","55400","2500"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemProdView = inflater.inflate(R.layout.fragment_product_list_main, container, false);

        ll1 = (LinearLayout)itemProdView.findViewById(R.id.ll1);
        rcViewProduct = (RecyclerView)itemProdView.findViewById(R.id.idProdRcView) ;

        mLayoutManager = new LinearLayoutManager(itemProdView.getContext(), LinearLayoutManager.VERTICAL, false);
        /*mLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );*/
        rcViewProduct.setLayoutManager(mLayoutManager);

        ProductViewHolderAdapter productViewHolderAdapter = new ProductViewHolderAdapter(itemProdView.getContext(), imageList, title, price);
        rcViewProduct.setLayoutManager(mLayoutManager);
        rcViewProduct.setAdapter(productViewHolderAdapter);

        return itemProdView;
    }


}
