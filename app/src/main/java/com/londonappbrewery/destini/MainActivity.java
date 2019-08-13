package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.models.Story;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private static final int NULL_ID = 0x00000000;

    private TextView mStoryText;
    private Button mAnswer1;
    private Button mAnswer2;
    private Story mCurrentStory, mNextStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStories();

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mAnswer1 = findViewById(R.id.buttonTop);
        mAnswer2 = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNextStory = mCurrentStory.getNextStoryId1();
                updateStory();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNextStory = mCurrentStory.getNextStoryId2();
                updateStory();
            }
        });
    }

    public void initStories() {
        Story mStory1, mStory2, mStory3, mStoryEnd4, mStoryEnd5, mStoryEnd6;

        mStoryEnd6 = new Story(R.string.T6_End);
        mStoryEnd5 = new Story(R.string.T5_End);
        mStoryEnd4 = new Story(R.string.T4_End);
        mStory3 = new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, mStoryEnd6, mStoryEnd5);
        mStory2 = new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2, mStory3, mStoryEnd4);
        mStory1 = new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2, mStory3, mStory2);

        mCurrentStory = mStory1;
    }

    private void updateStory(){
        if (mNextStory != null) {
            mStoryText.setText(mNextStory.getStoryId());
            if (mNextStory.getAnswerId1() != NULL_ID){
                mAnswer1.setText(mNextStory.getAnswerId1());
                mAnswer2.setText(mNextStory.getAnswerId2());
                mCurrentStory = mNextStory;
            } else {
                mAnswer1.setVisibility(View.GONE);
                mAnswer2.setVisibility(View.GONE);
            }
        }
    }
}
