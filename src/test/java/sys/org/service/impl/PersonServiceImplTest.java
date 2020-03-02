package sys.org.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import sys.org.bo.OrgBo;
import sys.org.bo.PersonBo;
import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.service.PersonService;
import sys.org.util.StringUtils;
import sys.org.util.model.SystemContext;

import javax.annotation.Resource;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author 27267
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class PersonServiceImplTest {

    @Resource
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void save() {
        Random random = new Random();
        String[] names = new String[]{"赵", "钱", "孙", "李", "周", "吴", "郑", "王"};
        String[] keys = new String[]{"小鹏", "大傻", "愿望","老大","道儿","老二","钉钉"};
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setName(names[random.nextInt(8)] + keys[random.nextInt(keys.length)]);
            person.setSex(random.nextInt(10) > 5 ? "男" : "女");
            personService.save(person);
        }

    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
        Person person = personService.findById(1);
        System.out.println(person.getName());
    }

    @Test
    public void query() {
        // 1. 查询出系统各种所有包含a的组织机构
        SystemContext.setOrder("-name");
        PersonBo bo = new PersonBo();
        bo.setSex("男");
        List<Person> orgList = personService.query(bo);
        Assert.notEmpty(orgList, "查询结果错误，应该包含数据！");
        for (Person person : orgList) {
            System.out.println(String.format("姓名:%s,性别:%s", person.getName(), person.getSex()));
        }
    }

    @Test
    public void pageQuery() {
    }
}