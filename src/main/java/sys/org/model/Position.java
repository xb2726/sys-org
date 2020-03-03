package sys.org.model;

import javax.persistence.*;

/**
 * @author 27267
 * 岗位的对象，用来确定某个人员所属的岗位，存储的是岗位名称,如：校长、副校长、普通员工、、、
 */
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //岗位的名称
    private String name;
    //岗位编号
    private String sn;
    //岗位是否具有管理功能
    private int manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", manager=" + manager +
                '}';
    }
}
