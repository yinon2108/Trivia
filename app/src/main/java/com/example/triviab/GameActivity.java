package com.example.triviab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1, btna2, btna3, btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber, tvPoints, tvGameOver;
    private Collection2 collection2;
    private Question currentQuestion;
    private int points = 0;
    private String backgroundColor = "";
    private LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ll = findViewById(R.id.activity_game);

        collection2 = new Collection2();
        Intent intent = getIntent();
        String color = intent.getStringExtra("color");
        this.backgroundColor = color;
        setBackgroundColor(color);

        tvQuestion = findViewById(R.id.tvQuestion);
        btna1 = findViewById(R.id.btna1);
        btna2 = findViewById(R.id.btna2);
        btna3 = findViewById(R.id.btna3);
        btna4 = findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvPoints = findViewById(R.id.tvPoints);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvGameOver = findViewById(R.id.tvGameOver);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection2.initQuestions();

        nextQuestion();
    }

    private void nextQuestion() {
        if (collection2.isNotLastQuestion())
        {
            currentQuestion = collection2.getNextQuestion();
            tvQuestion.setText(currentQuestion.getQuestion());

            btna1.setText(currentQuestion.getA1());
            btna2.setText(currentQuestion.getA2());
            btna3.setText(currentQuestion.getA3());
            btna4.setText(currentQuestion.getA4());
        }
        else
        {
            tvGameOver.setVisibility(View.VISIBLE);

            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();

        }
    }

    @Override
    public void onClick(View v) {
        if(v == btna1)
        {
            if(currentQuestion.getCorrect() == 1)
                points++;
        }
        if(v == btna2)
        {
            if(currentQuestion.getCorrect() == 2)
                points++;
        }
        if(v == btna3)
        {
            if(currentQuestion.getCorrect() == 3)
                points++;
        }
        if(v == btna4)
        {
            if(currentQuestion.getCorrect() == 4)
                points++;
        }

        tvPoints.setText("points: " + points);
        if(collection2.isNotLastQuestion())
        {
            tvQuestionNumber.setText("Question number: " + (collection2.getIndex()+1));
        }

        nextQuestion();
    }

    public void reset() {
        this.points = 0;
        collection2.initQuestions();
        tvPoints.setText("Points:" + 0);
        tvQuestionNumber.setText("Question number: " + 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }

    public void setBackgroundColor(String color)
    {
        switch (color)
        {
            case "Red":
            {
                ll.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue":
            {
                ll.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Pink":
            {
                ll.setBackgroundColor(Color.argb(255,255,105,180));
                break;
            }
            case "Yellow":
            {
                ll.setBackgroundColor(Color.YELLOW);
                break;
            }

            default:
                ll.setBackgroundColor(Color.WHITE);
        }
    }
}