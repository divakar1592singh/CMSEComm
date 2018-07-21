package cmsecomm.ecommerce.app.com.cmsecomm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import cmsecomm.ecommerce.app.com.cmsecomm.Utils.Navigator;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home )
        {
            Navigator.getClassInstance().navigateToActivity(ProductActivity.this, MainActivity.class);
        }
        return super.onOptionsItemSelected(item);
    }

}
