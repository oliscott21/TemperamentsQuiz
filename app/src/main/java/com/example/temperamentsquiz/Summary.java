/*
 * @author: Oliver Lester
 * @description: This program is responsible for giving text fields in the summary activity the
 *      information needed to provide the user with the correct temperament. Though, no deciding
 *      code occurs here. Instead, information given by Quiz.java through extra data will sent to
 *      the correct text field using an ID find.
 */

package com.example.temperamentsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Summary extends AppCompatActivity {

    HashMap<String, Integer> results;

    /**
     * This method is called on the creation of the Summary activity, it mainly uses the given data
     *      to display the information discovered by the quiz. And, setting up the page of course.
     * It takes in one Bundle parameter and returns nothing.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();
        results = (HashMap<String, Integer>) intent.getSerializableExtra("results");
        String temper = (String) intent.getStringExtra("temper");
        TextView t = (TextView) findViewById(R.id.temp);
        t.setText(temper);
        TextView td = (TextView) findViewById(R.id.temp_des);
        if (temper.equals("choleric")) {
            td.setText(R.string.ch);
        } else if (temper.equals("sanguine")) {
            td.setText(R.string.sg);
        } else if (temper.equals("melancholic")) {
            td.setText(R.string.me);
        } else {
            td.setText(R.string.ph);
        }
        TextView c = (TextView) findViewById(R.id.ch_score);
        Integer c_score = results.get("choleric");
        if (c_score == null) {
            c_score = 0;
        }
        String cs = "Choleric: " + c_score;
        c.setText(cs);
        TextView s = (TextView) findViewById(R.id.sa_score);
        Integer s_score = results.get("sanguine");
        if (s_score == null) {
            s_score = 0;
        }
        String st = "Sanguine: " + s_score;
        s.setText(st);
        TextView m = (TextView) findViewById(R.id.me_score);
        Integer m_score = results.get("melancholic");
        if (m_score == null) {
            m_score = 0;
        }
        String ms = "Melancholic: " + m_score;
        m.setText(ms);
        TextView p = (TextView) findViewById(R.id.ph_score);
        Integer p_score = results.get("phlegmatic");
        if (p_score == null) {
            p_score = 0;
        }
        String ps = "Phlegmatic: " + p_score;
        p.setText(ps);
    }
}