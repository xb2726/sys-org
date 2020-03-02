package sys.org.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import sys.org.dao.IPersonPosiDao;
import sys.org.model.PersonPosi;
import sys.org.service.PersonPosiService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author 27267
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class PersonPosiServiceImplTest {
    @Resource
    private PersonPosiService personPosiService;

    @Test
    public void save() {
        PersonPosi ps=new PersonPosi();
        ps.setPerId(1);
        ps.setPosId(2);
        personPosiService.save(ps);
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void query() {
    }

    @Test
    public void pageQuery() {
    }
}