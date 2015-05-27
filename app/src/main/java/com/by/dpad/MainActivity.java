package com.by.dpad;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
    private ImageView oval;
    private Button up, down, left, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oval = (ImageView) findViewById(R.id.oval);
        oval.setScaleType(ImageView.ScaleType.MATRIX);

        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);

        up.setOnClickListener(new DpadListener());
        down.setOnClickListener(new DpadListener());
        left.setOnClickListener(new DpadListener());
        right.setOnClickListener(new DpadListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DpadListener implements View.OnClickListener {
        public void onClick(View v) {
            RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) oval.getLayoutParams();
            switch (v.getId()) {
                case R.id.up: {
                    mParams.topMargin -= 50;
                    oval.setLayoutParams(mParams);
                    break;
                }
                case R.id.down: {
                    mParams.topMargin += 50;
                    oval.setLayoutParams(mParams);
                    break;
                }
                case R.id.left: {

                    mParams.leftMargin -= 50;
                    oval.setLayoutParams(mParams);
                    break;
                }
                case R.id.right: {
                    mParams.leftMargin += 50;
                    oval.setLayoutParams(mParams);
                    break;
                }
            }
        }
    }
}


