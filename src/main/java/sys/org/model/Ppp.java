package sys.org.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * @author 27267
 */
@Entity
@Table(name = "t_person")
public class Ppp {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Column(length = 20)
    private String name;
    private Integer age;
    @Column(length = 20)
    private String nickName;
    @NotNull
    private String password;
    private String intr;
    private String note;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
