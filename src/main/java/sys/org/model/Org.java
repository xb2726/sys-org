package sys.org.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * @author 27267
 * 组织对象，该表可以生成完整的组织树。根据组织类型来具体储存实际中存在的组织。
 */
@Entity
@Table(name = "sys_org")
public class Org {
    //组织机构id
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 64,nullable = false)
    private String name;
    //排序号
    @Column
    private Integer orderNum;
    @Column
    private Integer parentId;
    @Column(length = 64)
    private String parentName;

    @Column(length = 200)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderNum=" + orderNum +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
