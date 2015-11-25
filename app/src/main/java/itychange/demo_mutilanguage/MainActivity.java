package itychange.demo_mutilanguage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // UI
    Spinner spinner;
    Toolbar toolbar;

    // data
    boolean savedBundle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!savedBundle) {
            super.onCreate(savedInstanceState);
            savedBundle = true;
        }

        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == 1) {
                    setLocale("en");
                } else if (arg2 == 2) {
                    setLocale("vi");
                } else if (arg2 == 3) {
                    setLocale("ja");
                } else if (arg2 == 4) {
                    setLocale("zh");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

//        Intent refresh = new Intent(this, MainActivity.class);
//        startActivity(refresh);

        this.onCreate(null);
    }

}
