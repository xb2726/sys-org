package sys.org.model;

import javax.persistence.*;

/**
 * @author 27267
 */
@Entity
@Table(name = "sys_personposi")
public class PersonPosi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer perId;
    private Integer posId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Integer getPosId() {
        return posId;
    }

    @Override
    public String toString() {
        return "PersonPosi{" +
                "id=" + id +
                ", perId=" + perId +
                ", posId=" + posId +
                '}';
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }
}
