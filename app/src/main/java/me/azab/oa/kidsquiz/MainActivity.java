package me.azab.oa.kidsquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextViewQuestionNumber;
    TextView mTextViewQuestion;
    ImageView mImageViewQuestion;
    FrameLayout mFrameLayoutAnswersArea;
    Button mButtonSubmit;
    List<Question> mQuestions;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI
        mTextViewQuestionNumber = (TextView) findViewById(R.id.text_view_question_number);
        mTextViewQuestion = (TextView) findViewById(R.id.text_view_question);
        mImageViewQuestion = (ImageView) findViewById(R.id.image_view_question_image);
        mFrameLayoutAnswersArea = (FrameLayout) findViewById(R.id.frame_answer_area);
        mButtonSubmit = (Button) findViewById(R.id.btn_submit);

        //get questions
        mQuestions = Question.getQuestions();

        // update ui with first question
        updateUiWithQuestion(mQuestions.get(questionNumber));

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // grade current question
                gradeQuestion(mQuestions.get(questionNumber));

                if (questionNumber < mQuestions.size()) {
                    // update ui with next question
                    updateUiWithQuestion(mQuestions.get(questionNumber));
                } else {
                    Toast.makeText(MainActivity.this, "no more questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * This method update app ui with question information
     *
     * @param mQuestion the question to be displayed
     */
    public void updateUiWithQuestion(Question mQuestion) {
        // update UI with question name and image
        mTextViewQuestionNumber.setText((questionNumber+1) + "/9");
        mTextViewQuestion.setText(mQuestion.getString());
        mImageViewQuestion.setImageResource(mQuestion.getImage());


        //layout inflater
        LayoutInflater inflater = LayoutInflater.from(this);
        mFrameLayoutAnswersArea.removeAllViews();

        // Switch on question type to display the correct answers area
        switch (mQuestion.getType()) {
            case TEXT:
                View inflatedLayoutText = inflater.inflate(R.layout.answer_area_text, null, false);
                mFrameLayoutAnswersArea.addView(inflatedLayoutText);
                break;
            case RADIO:
                View inflatedLayoutRadio = inflater.inflate(R.layout.answer_area_radio, null, false);
                mFrameLayoutAnswersArea.addView(inflatedLayoutRadio);
                break;
            case CHECK:
                View inflatedLayoutCheck = inflater.inflate(R.layout.answer_area_check, null, false);
                mFrameLayoutAnswersArea.addView(inflatedLayoutCheck);
                break;
            default:
                break;
        }
    }

    /**
     * This method take user input and grade it's answer
     * if it's correct answer add points to user score
     *
     * @param mQuestion the question to be graded
     */
    public void gradeQuestion(Question mQuestion) {
        questionNumber++;
    }
}
