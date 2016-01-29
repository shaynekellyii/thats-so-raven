package com.shayne.thatssoraven;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private EditText input;
    private Button button;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this.getApplicationContext();

        input = (EditText)findViewById(R.id.ravenText);
        button = (Button)findViewById(R.id.ravenButton);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        /* button listener for toast
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayString = input.getText().toString() + "? That is so not Raven!";
                Toast toast = Toast.makeText(getBaseContext(), displayString, Toast.LENGTH_LONG);
                toast.show();
            }
        });*/

        Toast toast = Toast.makeText(getBaseContext(),
                "Please type something so its Ravenability can be analyzed.",
                Toast.LENGTH_LONG);
        toast.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (input.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(getBaseContext(),
                            "Please type something so its Ravenability can be analyzed.",
                            Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(context, NextScreen.class);
                    intent.putExtra("input", input.getText().toString());
                    startActivity(intent);
                }
            }
        });

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Check out this incredible app that tells you how Raven something is! Will " +
                    "Raven give her approval? Or is it so not Raven...\n" +
                    "Download it here! http://placeholder/");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share this app using..."));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
