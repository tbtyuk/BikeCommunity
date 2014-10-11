package com.morimoritabata.bikecommunity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//Tab mode ni settei

        ActionBar.Tab tab1=getActionBar().newTab();
        tab1.setText("SURETIGAI");
        tab1.setTabListener(new TabSampleListener(new passedFragment()));

        ActionBar.Tab tab2=getActionBar().newTab();
        tab2.setText("MATCHING");
        tab2.setTabListener(new TabSampleListener(new matchingFragment()));

        getActionBar().addTab(tab1);
        getActionBar().addTab(tab2);
    }

    //Listener teigi
    private class TabSampleListener implements ActionBar.TabListener{
        private Fragment fragment;

        public TabSampleListener(Fragment fragment){
            this.fragment=fragment;
        }

        public void onTabReselected(Tab tab,FragmentTransaction ft){

        }
        public void onTabSelected(Tab tab,FragmentTransaction ft){
//          ft.add(R.id.mytabactivity,fragment);
        }
        public void onTabUnselected(Tab tab,FragmentTransaction ft){
            ft.remove(fragment);
        }

        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
