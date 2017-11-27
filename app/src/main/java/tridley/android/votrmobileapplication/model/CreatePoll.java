package tridley.android.votrmobileapplication.model;

/**
 * Created by King Chessley on 11/14/2017.
 */

public class CreatePoll {
    public  int id;
    private String title;
    private int code;
    private String options;

    public CreatePoll(int id, String title, int code, String options, String category){
        this.id = id;
        this.title = title;
        this.code = code;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }

    public String getOptions() {
        return options;
    }

}
