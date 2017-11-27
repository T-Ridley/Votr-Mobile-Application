package tridley.android.votrmobileapplication.model;

/**
 * Created by King Chessley on 11/15/2017.
 */

public class Poll {
    private String PollTitle;
    private String PollAnswer;
    private String PollQuestion;

    public Poll(String pollTitle, String pollAnswer,String pollQuestion){
        this.PollTitle = pollTitle;
        this.PollAnswer = pollAnswer;
        this.PollQuestion = pollQuestion;
    }

    public String getPollTitle() {
        return PollTitle;
    }

    public String getPollAnswer() {
        return PollAnswer;
    }

    public String getPollQuestion() {
        return PollQuestion;
    }
}
