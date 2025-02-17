package com.example.triviab;


import java.util.ArrayList;

public class Collection {
    private ArrayList<Question> arr;
    private int index; // מספר השאלה הבאה בתור

   public Collection()
   {
       arr = new ArrayList<>();

       Question q1 = new Question("1+10","7", "11", "3","110", 2);
       Question q2 = new Question("1+2", "8", "2", "3","9", 3);
       Question q3 = new Question("1+3", "6", "2", "4","100", 3);
       Question q4 = new Question("1+4", "5", "2", "3","17", 1);
       Question q5 = new Question("1+0", "10", "2", "3","1", 4);

       arr.add (q1);
       arr.add (q2);
       arr.add (q3);
       arr.add (q4);
       arr.add (q5);
   }

    public void initQuestions()
    {
        index = 0;
    }

    public Question getNextQuestion()
    {
        // הפעולה מחזירה הפניה לשאלה הבאה
        Question q = arr.get(index);
        index++;
        return q;
    }
    public boolean isNotLastQuestion() {
        // הפעולה מחזירה אמת אם אנו בשאלה האחרונה
        return (index < arr.size()); // if not at the end of the ArrayList
        // }
    }

    public int getIndex() {
        return index;
    }
}
