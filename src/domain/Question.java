/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gazi
 */
public class Question {
    private int ordinalNumber;
    private String text;
    private String answer;
    private Enum difficulty;

    public Question(int ordinalNumber, String text, String answer, Enum difficulty) {
        this.ordinalNumber = ordinalNumber;
        this.text = text;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public Question() {
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Enum getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Enum difficulty) {
        this.difficulty = difficulty;
    }
    
    
}
