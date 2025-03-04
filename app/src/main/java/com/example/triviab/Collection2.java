package com.example.triviab;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Collection2 {
    private Queue<Question> queue; // שימוש ב-Queue במקום ArrayList
    private int index; // מספר השאלה הבאה בתור

    public Collection2() {
        queue = new LinkedList<>(); // אתחול של ה-Queue

        // יצירת השאלות
        Question q1 = new Question("1+11", "7", "12", "3", "110", 2);
        Question q2 = new Question("1+2", "8", "2", "3", "9", 3);
        Question q3 = new Question("1+3", "6", "2", "4", "100", 3);
        Question q4 = new Question("1+4", "5", "2", "3", "17", 1);
        Question q5 = new Question("1+0", "10", "2", "3", "1", 4);

        // הוספת השאלות ל-Queue
        queue.add(q1);
        queue.add(q2);
        queue.add(q3);
        queue.add(q4);
        queue.add(q5);
    }

    public void initQuestions() {
        // אתחול ה-Queue עם כל השאלות
        index = 0;
    }

    public Question getNextQuestion() {
        // פעולה שמחזירה את השאלה הבאה
        if (!queue.isEmpty()) {
            Question q = queue.poll(); // שולפים את השאלה הראשונה
            index++;
            return q;
        }
        return null; // אם אין שאלות, מחזירים null
    }

    public boolean isNotLastQuestion() {
        // אם יש שאלות נוספות ב-Queue
        return !queue.isEmpty();
    }

    public int getIndex() {
        return index;
    }
}