package malviya.com.studentregistration_customviews.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import malviya.com.studentregistration_customviews.R;
import malviya.com.studentregistration_customviews.adapter.DashboardAdapter;
import malviya.com.studentregistration_customviews.model.Student;
import malviya.com.studentregistration_customviews.utils.DataStore;
import malviya.com.studentregistration_customviews.utils.NavigateClass;

/**
 * Created by Mridul Malviya on 12/22/2016.
 */

public class Dashboard extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {
    public boolean isContextMode = false;
    TextView counterText;
    TextView dashboardTitle;
    Toolbar mToolbar;
    RecyclerView mRV;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<Student> selection_list = new ArrayList<>();
    int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        mToolbar = (Toolbar) findViewById(R.id.dashboard_toolbar_id);
        setSupportActionBar(mToolbar);

        counterText = (TextView) findViewById(R.id.txt_dashboard_Item_Count);
        assert counterText != null;
        counterText.setVisibility(View.GONE);

        dashboardTitle = (TextView) findViewById(R.id.txt_dashboardTitle);
        assert dashboardTitle != null;
        dashboardTitle.setVisibility(View.VISIBLE);

        mRV = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRV.setLayoutManager(mLayoutManager);
        mRV.setHasFixedSize(true);
        mAdapter = new DashboardAdapter(DataStore.returnListInstance(), Dashboard.this);
        mRV.setAdapter(mAdapter);

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resId = item.getItemId();
        switch (resId) {
            case R.id.delete:
                isContextMode = false;
                DashboardAdapter dashboardAdapter = (DashboardAdapter) mAdapter;
                dashboardAdapter.updateAdapter(selection_list);
                clearActionMode();
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.settings:
                clearActionMode();
                mAdapter.notifyDataSetChanged();
                NavigateClass.navigateTo(this,RegistrationActivity.class);
                break;
        }
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        //   Toast.makeText(this, "onLongClickpress", Toast.LENGTH_SHORT).show();
        clearActionMode();
        mToolbar.getMenu().clear();
        isContextMode = true;
        mToolbar.inflateMenu(R.menu.menu_delete);
        dashboardTitle.setVisibility(View.INVISIBLE);
        counterText.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        return false;
    }

    @Override
    public void onClick(View v) {
        //  Toast.makeText(this, "Hello Click", Toast.LENGTH_SHORT).show();
    }

    public void prepareSelection(View view, int position) {
        selection_list.add(DataStore.returnListInstance().get(position));
        if (((CheckBox) view).isChecked()) {
            counter = counter + 1;

        } else {
            counter = counter - 1;
        }
        updateCounter(counter);
    }

    public void updateCounter(int counter) {
        if (counter == 0) {
            counterText.setText(R.string.item_counter);
        } else {
            counterText.setText(counter + " item selected");
        }
    }

    public void clearActionMode() {
        isContextMode = false;
        mToolbar.getMenu().clear();
        mToolbar.inflateMenu(R.menu.menu_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        counterText.setVisibility(View.VISIBLE);
        counterText.setText(R.string.app_name);
        counter = 0;
        selection_list.clear();
    }


}
