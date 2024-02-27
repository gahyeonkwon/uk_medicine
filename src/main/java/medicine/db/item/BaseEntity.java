package medicine.db.item;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    private String comment;
    private LocalDateTime update_date;
    private LocalDateTime regist_date;

    @PrePersist // 데이터 생성이 이루어질때 사전 작업
    public void prePersist() {
        this.regist_date = LocalDateTime.now();
        this.update_date = this.regist_date;
    }

    @PreUpdate // 데이터 수정이 이루어질때 사전 작업
    public void preUpdate() {
        this.update_date = LocalDateTime.now();
    }

}
