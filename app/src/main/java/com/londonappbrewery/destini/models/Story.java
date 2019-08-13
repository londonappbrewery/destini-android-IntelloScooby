package com.londonappbrewery.destini.models;

public class Story {

    private int mStoryId;
    private int mAnswerId1;
    private int mAnswerId2;
    private Story mNextStoryId1;
    private Story mNextStoryId2;

    public Story(int storyId, int answerId1, int answerId2, Story nextStory1, Story nextStory2) {
        mStoryId = storyId;
        mAnswerId1 = answerId1;
        mAnswerId2 = answerId2;
        mNextStoryId1 = nextStory1;
        mNextStoryId2 = nextStory2;
    }

    public Story(int storyId) {
        mStoryId = storyId;
    }

    public int getStoryId() {
        return mStoryId;
    }

    public int getAnswerId1() {
        return mAnswerId1;
    }

    public int getAnswerId2() {
        return mAnswerId2;
    }

    public Story getNextStoryId1() {
        return mNextStoryId1;
    }

    public Story getNextStoryId2() {
        return mNextStoryId2;
    }
}
