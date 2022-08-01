/*
 * @author: Oliver Lester
 * @description: This program is responsible for implementing the mechanics of the quiz. It holds
 *      all the data structures needed for this. It provides the code that changes the question
 *      and holds the scores, updating it as it goes. It decides the temperament based on the scores
 *      and passes all the necessary information to the Summary activity, to where the user will
 *      get the correct information from their quiz.
 */

package com.example.temperamentsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    HashMap<String, Integer> scores;
    ArrayList<String> choleric;
    ArrayList<String> melancholic;
    ArrayList<String> phlegmatic;
    ArrayList<String> sanguine;
    ArrayList<String> questions;
    Random rand;
    int questionNum;

    /**
     * This method is called on the creation of the Quiz activity, mainly creating important data
     * structures that will be used in other methods. And, setting up the page of course.
     * It takes in one Bundle parameter and returns nothing.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        scores = new HashMap<>();
        scores.put("choleric", 0);
        scores.put("melancholic", 0);
        scores.put("phlegmatic", 0);
        scores.put("sanguine", 0);
        questionNum = 0;
        questions = new ArrayList<>();
        choleric = new ArrayList<>();
        melancholic = new ArrayList<>();
        phlegmatic = new ArrayList<>();
        sanguine = new ArrayList<>();
        rand = new Random();
        try {
            fillLists();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildQuiz();
        TextView temp = (TextView) findViewById(R.id.question);
        temp.setText(questions.get(questionNum));
    }

    /**
     * This method sets up the quiz by filling the questions ArrayList.
     * It takes in no parameters and returns nothing.
     */
    private void buildQuiz() {
        for (int i = 0; i < 3; i++) {
            getCholericQuestion();
            getSanguineQuestion();
            getMelancholicQuestion();
            getPhlegmaticQuestion();
        }
    }

    /**
     * This method picks a random question from the choleric ArrayList. It loops until a unique
     * question is found, or an underlying counter is reached. It then adds the question to
     * questions ArrayList
     * It takes in no parameters and returns nothing.
     */
    private void getCholericQuestion() {
        int i = 0;
        String temp;

        while (true) {
            temp = choleric.get(rand.nextInt(choleric.size()));
            if (i > choleric.size() || !questions.contains(temp)) {
                break;
            }
            i++;
        }
        questions.add(temp);
    }

    /**
     * This method picks a random question from the melancholic ArrayList. It loops until a unique
     * question is found, or an underlying counter is reached. It then adds the question to
     * questions ArrayList
     * It takes in no parameters and returns nothing.
     */
    private void getMelancholicQuestion() {
        int i = 0;
        String temp;

        while (true) {
            temp = melancholic.get(rand.nextInt(melancholic.size()));
            if (i > melancholic.size() || !questions.contains(temp)) {
                break;
            }
            i++;
        }
        questions.add(temp);
    }

    /**
     * This method picks a random question from the phlegmatic ArrayList. It loops until a unique
     * question is found, or an underlying counter is reached. It then adds the question to
     * questions ArrayList
     * It takes in no parameters and returns nothing.
     */
    private void getPhlegmaticQuestion() {
        int i = 0;
        String temp;

        while (true) {
            temp = phlegmatic.get(rand.nextInt(phlegmatic.size()));
            if (i > phlegmatic.size() || !questions.contains(temp)) {
                break;
            }
            i++;
        }
        questions.add(temp);
    }

    /**
     * This method picks a random question from the sanguine ArrayList. It loops until a unique
     * question is found, or an underlying counter is reached. It then adds the question to
     * questions ArrayList
     * It takes in no parameters and returns nothing.
     */
    private void getSanguineQuestion() {
        int i = 0;
        String temp;

        while (true) {
            temp = sanguine.get(rand.nextInt(sanguine.size()));
            if (i > sanguine.size() || !questions.contains(temp)) {
                break;
            }
            i++;
        }
        questions.add(temp);
    }

    /**
     * This method sets up the question ArrayLists of the respective temperament name.
     * It takes in no parameters and returns nothing.
     */
    private void fillLists() throws IOException {
        getCholericList();
        getMelancholicList();
        getPhlegmaticList();
        getSanguineList();
    }

    /**
     * This method opens the choleric.txt file and places all the lines, as strings, into the
     * choleric ArrayList. The file is closed on completion.
     * It takes in no parameters and returns nothing.
     */
    private void getCholericList() throws IOException {
        InputStream input = getResources().openRawResource(R.raw.choleric);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buf = new BufferedReader(reader);

        String temp = buf.readLine();
        while (temp != null) {
            choleric.add(temp);
            temp = buf.readLine();
        }

        input.close();
    }

    /**
     * This method opens the melancholic.txt file and places all the lines, as strings, into the
     * melancholic ArrayList. The file is closed on completion.
     * It takes in no parameters and returns nothing.
     */
    private void getMelancholicList() throws IOException {
        InputStream input = getResources().openRawResource(R.raw.melancholic);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buf = new BufferedReader(reader);

        String temp = buf.readLine();
        while (temp != null) {
            melancholic.add(temp);
            temp = buf.readLine();
        }

        input.close();
    }

    /**
     * This method opens the phlegmatic.txt file and places all the lines, as strings, into the
     * phlegmatic ArrayList. The file is closed on completion.
     * It takes in no parameters and returns nothing.
     */
    private void getPhlegmaticList() throws IOException {
        InputStream input = getResources().openRawResource(R.raw.phlegmatic);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buf = new BufferedReader(reader);

        String temp = buf.readLine();
        while (temp != null) {
            phlegmatic.add(temp);
            temp = buf.readLine();
        }

        input.close();
    }

    /**
     * This method opens the sanguine.txt file and places all the lines, as strings, into the
     * sanguine ArrayList. The file is closed on completion.
     * It takes in no parameters and returns nothing.
     */
    private void getSanguineList() throws IOException {
        InputStream input = getResources().openRawResource(R.raw.sanguine);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buf = new BufferedReader(reader);

        String temp = buf.readLine();
        while (temp != null) {
            sanguine.add(temp);
            temp = buf.readLine();
        }

        input.close();
    }

    /**
     * This method is responsible for keeping the score updated. Along with incrementing
     * questionNum and changing the question TextField to a new string representing a new
     * question. Finally, it also creates and Intent of the Summary activity and gives it the
     * scores HashMap and the decided temperament string using extra data.Then starting that
     * activity, this happening when the quiz is finished. This method is used on the click of
     * the button on the Quiz page.
     * It takes in one View parameter and returns nothing.
     */
    public void changeText(View view) {
        scoreChange();
        questionNum += 1;
        if (questionNum >= 12) {
            if (questionNum == 12) {
                String temper = determineTemper();
                Intent jump = new Intent(this, Summary.class);
                jump.putExtra("temper", temper);
                jump.putExtra("results", scores);
                startActivity(jump);
            }
        } else {
            TextView temp = (TextView) findViewById(R.id.question);
            temp.setText(questions.get(questionNum));
        }
    }

    /**
     * This method is called on the completion of the quiz. It loops through the keys of the scores
     * HashMap. Where it determines the temperament with the highest score and returns it. If
     * there are any ties in scores, then the method will randomly select on the of the top
     * temperaments.
     * It takes in no parameters and returns on string, which represents the temperament with the
     * highest score.
     */
    private String determineTemper() {
        int max = 0;
        Integer cur;
        ArrayList<String> temp = new ArrayList<>();

        for (String key : scores.keySet()) {
            cur = scores.get(key);
            if (cur == null) {
                cur = 0;
            }
            if (cur > max) {
                temp.clear();
                temp.add(key);
                max = cur;
                continue;
            }
            if (cur == max) {
                temp.add(key);
            }
        }

        if (temp.size() > 1) {
            return temp.get(rand.nextInt(temp.size()));
        }
        return temp.get(0);
    }

    /**
     * This method finds the radio button that is currently checked and calls the updateScores
     * method with a Integer 0-4 that corresponds with the radio button pressed. It only runs
     * when questionNum is less than 12, to ensure extra points aren't given in case of a
     * double press of the button on the final question.
     * It takes in no parameters and returns nothing.
     */
    private void scoreChange() {
        if (questionNum < 12) {
            int point;
            RadioGroup rg = (RadioGroup) findViewById(R.id.radio);
            if (rg.getCheckedRadioButtonId() == R.id.sa) {
                point = 4;
            } else if (rg.getCheckedRadioButtonId() == R.id.pa) {
                point = 3;
            } else if (rg.getCheckedRadioButtonId() == R.id.n) {
                point = 2;
            } else if (rg.getCheckedRadioButtonId() == R.id.pd) {
                point = 1;
            } else {
                point = 0;
            }
            updateScores(point);
        }
    }

    /**
     * This method changes the scores HashMap. All four temperaments are mapped to a value that is
     * changed if questionNum corresponds with a number that will be a question of one the
     * temperaments.
     * It takes in one Integer parameter and returns nothing.
     */
    private void updateScores(Integer point) {
        Integer count;

        if (questionNum % 4 == 0) {
            count = scores.get("choleric");
            if (count == null) {
                count = 0;
            }
            scores.put("choleric", count + point);
        } else if (questionNum % 4 == 1) {
            count = scores.get("sanguine");
            if (count == null) {
                count = 0;
            }
            scores.put("sanguine", count + point);
        } else if (questionNum % 4 == 2) {
            count = scores.get("melancholic");
            if (count == null) {
                count = 0;
            }
            scores.put("melancholic", count + point);
        } else {
            count = scores.get("phlegmatic");
            if (count == null) {
                count = 0;
            }
            scores.put("phlegmatic", count + point);
        }
    }
}