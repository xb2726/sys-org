package sys.org.service.impl;

import org.springframework.stereotype.Service;
import sys.org.bo.PersonPosiBo;
import sys.org.dao.IPersonPosiDao;
import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.model.PersonPosi;
import sys.org.service.PersonPosiService;
import sys.org.util.model.Pager;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;

/**
 * @author 27267
 */
@Service("personPosiService")
public class PersonPosiServiceImpl implements PersonPosiService {
    @Resource
    private IPersonPosiDao personPosiDao;
    @Override
    public void save(PersonPosi pp) {
        personPosiDao.add(pp);
    }

    @Override
    public void update(PersonPosi pp) {
        personPosiDao.update(pp);
    }

    @Override
    public PersonPosi findById(int id) {
        PersonPosi psp = personPosiDao.load(id);
        return psp;
    }

    @Override
    public List<PersonPosi> query(PersonPosiBo bo) {
        return personPosiDao.query(bo);
    }

    @Override
    public Pager<PersonPosi> pageQuery(PersonPosiBo bo) {
        Pager<PersonPosi> pager = new Pager<PersonPosi>();
        Long total = personPosiDao.getTotal(bo);
        pager.setTotal(total);
        if (total == null || total == 0) {
            return pager;
        }
        List<PersonPosi> ppsList = personPosiDao.query(bo);
        pager.setDatas(ppsList);
        return pager;

    }
}
