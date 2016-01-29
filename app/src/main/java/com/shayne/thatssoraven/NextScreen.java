package com.shayne.thatssoraven;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

/**
 * Created by Shayne on 2015-02-17.
 */
public class NextScreen extends ActionBarActivity {

    private android.support.v7.widget.Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raven_screen);

        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.tool_bar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String input = extras.getString("input");

        TextView soRavenText = (TextView)findViewById(R.id.soRavenText);
        TextView userInput = (TextView) findViewById(R.id.userInput);
        TextView disappointText = (TextView) findViewById(R.id.disappointText);
        ImageView soRavenImage = (ImageView)findViewById(R.id.soRavenImage);

        userInput.setText(input + "?");

        if (((input.length() + (int)input.charAt(0)) % 2) == 1) {
            soRavenText.setText("That's So Raven!");
            disappointText.setText("Wow! You've managed to impress Raven!\n" +
            "That's probably the greatest achievement of your life.\n" +
            "Your life is now fulfilled.");
            soRavenImage.setImageResource(R.drawable.thatssoraven);
        }
        else {
            soRavenText.setText("That is so not Raven...");
            disappointText.setText("Wow! You've managed to terribly disappoint Raven.\n" +
                            "Live life in shame, knowing that was so not Raven.\n" +
                            "Actually, I'm not sure how you could live after that...");
            soRavenImage.setImageResource(R.drawable.notraven);
        }
    }
}
