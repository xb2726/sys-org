package sys.org.service.impl;

import org.springframework.stereotype.Service;
import sys.org.bo.PersonBo;
import sys.org.dao.IPersonDao;
import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.service.PersonService;
import sys.org.util.model.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 27267
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private IPersonDao iPersonDao;

    @Override
    public void save(Person person) {
        iPersonDao.add(person);
    }

    @Override
    public void update(Person person) {
        iPersonDao.update(person);
    }

    @Override
    public Person findById(int id) {
        return iPersonDao.load(id);
    }

    @Override
    public List<Person> query(PersonBo bo) {
        return iPersonDao.query(bo);
    }

    @Override
    public Pager<Person> pageQuery(PersonBo bo) {
        Pager<Person> pager = new Pager<>();
        Long total = iPersonDao.getTotal(bo);
        pager.setTotal(total);
        if (total == null || total == 0) {
            return pager;
        }
        List<Person> personList = iPersonDao.query(bo);
        pager.setDatas(personList);
        return pager;
    }

    @Override
    public void deleteById(int id) {
        iPersonDao.delete(id);
    }
}
