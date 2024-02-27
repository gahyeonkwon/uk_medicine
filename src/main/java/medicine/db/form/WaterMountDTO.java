package medicine.db.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
@NoArgsConstructor
public class WaterMountDTO {

    private long specId;

    private long recipeId;
    private long orderMount;
    private int setPouch;

    private double totalWaterMount;

    public void initData() {
        log.info(" waterMount init !");
        orderMount = 0;
        setPouch = 50;
    }

    public void updateTotalWaterMount(double totalWaterMount) {
        log.info(" update TotalWaterMount");
        this.totalWaterMount = totalWaterMount;
    }

}
