package medicine.db.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WaterMount {

    private long specId;

    private long recipeId;
    private long orderMount;
    private int setPouch;

    private double totalWaterMount;

    public void initData() {
        orderMount = 0;
        setPouch = 50;
    }

}
