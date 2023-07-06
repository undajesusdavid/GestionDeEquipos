
import com.undabits.models.Component;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args){
        JSONObject data = new JSONObject();
        data.put("code","4GRR6G");
        data.put("name","laptop DELL");
        data.put("asset_code","FGR4G");
        data.put("serial","SDASDHHRWW");
        data.put("color","NEGRO");
        data.put("brand","DELL");
        data.put("model","OPTIPLEX 990");
        data.put("is_operative",true);
        data.put("in_use",true);

        Component c = Component.create(data);


    }


}
