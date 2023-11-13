/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gazi
 */
public class Quiz {
    private Long quizID;
    private String quizName;
    private String topic;

    public Quiz(String quizName, String topic) {
        this.quizName = quizName;
        this.topic = topic;
    }

    public Quiz() {
    }

    public Long getQuizID() {
        return quizID;
    }

    public void setQuizID(Long quizID) {
        this.quizID = quizID;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
}
