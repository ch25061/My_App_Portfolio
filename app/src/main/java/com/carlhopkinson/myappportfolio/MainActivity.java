package com.carlhopkinson.myappportfolio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button[] mButtons;

    private static final int APP_NUMBER = 6;    // number of apps displayed as buttons


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Setup onClickHandlers for buttons
        mButtons = new Button[APP_NUMBER];
        mButtons[0] = (Button) findViewById(R.id.button1);
        mButtons[1] = (Button) findViewById(R.id.button2);
        mButtons[2] = (Button) findViewById(R.id.button3);
        mButtons[3] = (Button) findViewById(R.id.button4);
        mButtons[4] = (Button) findViewById(R.id.button5);
        mButtons[5] = (Button) findViewById(R.id.button6);

        //One onClickListener for all buttons!!
        View.OnClickListener buttonListener = new View.OnClickListener() {
            public void
            onClick(View v) {
                Button inButton = (Button) v;

                //Display Button Text in a Toast
                displayToast(inButton.getText().toString());

              // Log.d("MyAppPortfolio:", " onCreate(): Button clicked: text is: " + inButton.getText());
            }

        };

        for (Button button : mButtons) {
            button.setOnClickListener(buttonListener);

        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
                               {
                                   @Override
                                   public void onClick(View view)
                                   {
                                       Snackbar.make(view, "Replace with your own action",
                                                     Snackbar.LENGTH_LONG
                                       )
                                               .setAction("Action", null)
                                               .show();
                                   }
                               }
        );
    }

    private static String TOAST_PREFIX = "This button will launch my ";
    private static String TOAST_SUFFIX = " app!";

    private void
    displayToast(String inText)
    {

        Toast toast = Toast.makeText(getApplicationContext(),TOAST_PREFIX +  inText + TOAST_SUFFIX, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
