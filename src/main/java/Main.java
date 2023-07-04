
import com.undabits.models.Component;
import java.util.List;


public class Main {

    public static void main(String[] args){

        List<Component> components = Component.get();
        for (Component component: components){
            component.print();
        }

    }


}
