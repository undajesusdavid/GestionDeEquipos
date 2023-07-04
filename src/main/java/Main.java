import com.undabits.User;
import org.json.JSONObject;

import java.util.List;

public class Main {

    public static void main(String[] args){
        List<JSONObject> users = User.all();

        for (JSONObject data : users){
            System.out.println(data);
        }
    }


}
