package sys.org.model;

import javax.persistence.*;

/**
 * @author 27267
 * 人员对象,对于人员而言，某些项目，可能person中有一些特殊的属性，并不能在人员对象中一一展示，
 * 如 教师和学生要储存的信息完全不一致。此时就创建两个关联类来和person进行关联。然后根据实际情况来
 * 判断是否有必要提供人员添加的功能，如果都是使用其他对象关联，如果所有的对象要么是教师，要么是学生，
 * 此时可以提供相应的教师和学生的添加功能在添加学生和教师的时候直接添加person对象。
 *
 * 所以此处就把人员公共的属性抽取出来
 */
@Entity
@Table(name = "sys_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20,nullable = false)
    private String name;
    @Column(length = 2)
    private String sex;
    @Column
    private Integer orgId;
    @Column(length = 64)
    private String orgName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
