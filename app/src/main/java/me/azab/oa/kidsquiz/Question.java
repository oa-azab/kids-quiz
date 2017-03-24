package me.azab.oa.kidsquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 18/03/2017.
 */

public class Question {

    public enum Type {TEXT, RADIO, CHECK}

    private Type type;
    private String string;
    private int image;
    private String[] answers;
    private String[] correctAnswers;

    public Question(Type type, String string, int image, String[] answers, String[] correctAnswers) {
        this.type = type;
        this.string = string;
        this.image = image;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    /**
     * This method generate statics question
     *
     * @return list of Questions
     */
    public static List<Question> getQuestions(){
        List<Question> mList = new ArrayList<>();

        mList.add(new Question(Type.TEXT,"Type name of the animal",R.drawable.lion,new String[]{""},new String[]{"lion"}));
        mList.add(new Question(Type.RADIO,"What is the name of the animal",R.drawable.lion,new String[]{"lion","monkey","whale","bird"},new String[]{"lion"}));
        mList.add(new Question(Type.CHECK,"Choose the animals in the picture",R.drawable.catanddog,new String[]{"dog","monkey","lion","cat"},new String[]{"cat","dog"}));
        mList.add(new Question(Type.TEXT,"Type name of the animal",R.drawable.giraffe,new String[]{""},new String[]{"giraffe"}));
        mList.add(new Question(Type.RADIO,"What is the name of the animal",R.drawable.dog,new String[]{"lion","monkey","giraffe","dog"},new String[]{"dog"}));
        mList.add(new Question(Type.CHECK,"Choose the animals in the picture",R.drawable.giraffeandelephant,new String[]{"dog","giraffe","lion","elephant"},new String[]{"giraffe","elephant"}));
        mList.add(new Question(Type.TEXT,"Type name of the animal",R.drawable.dog,new String[]{""},new String[]{"dog"}));
        mList.add(new Question(Type.RADIO,"What is the name of the animal",R.drawable.elephant,new String[]{"elephant","monkey","giraffe","dog"},new String[]{"elephant"}));
        mList.add(new Question(Type.CHECK,"Choose the animals in the picture",R.drawable.monkeyandlion,new String[]{"dog","monkey","lion","elephant"},new String[]{"monkey","lion"}));

        return mList;
    }
}
