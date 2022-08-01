/*
 * @author: Oliver Lester
 * @description: This program is responsible for setting up the welcome page and providing the
 *      app a way to get to the quiz page, with a button click.
 */

package com.example.temperamentsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Integer> scores;

    /**
     * This method is called on the creation of the Quiz activity, it sets up the page.
     * It takes in one Bundle parameter and returns nothing.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method will be used to get to start the Quiz activity using an intent.
     * It accepts one view parameter and returns nothing.
     */
    public void toQuiz(View view) {
        Intent jump = new Intent(this, Quiz.class);
        startActivity(jump);
    }
}