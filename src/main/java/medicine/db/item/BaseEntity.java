package medicine.db.item;


import org.apache.tomcat.jni.Local;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private String comment;
    private LocalDateTime update_date;
    private LocalDateTime regist_date;

}
