package sys.org.service.impl;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import sys.org.bo.PersonBo;
import sys.org.dao.IPersonDao;

import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.model.Position;
import sys.org.service.PersonService;
import sys.org.util.model.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 27267
 */
@Service("personService")
public class PersonServiceImpl  implements PersonService {
    @Resource
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
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
        Pager<Person> pager = new Pager<Person>();
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

    @Override
    public List personList(){
        String sql="select pe.id as pid,pe.name as pname,pe.sex,org.name as oname,org.parentName,pos.name as posname,pos.sn from" +
                "  org.sys_personposi pp right join  org.sys_person pe on pe.id=pp.perId left  join org.sys_org org on pe.orgId=org.id" +
                "  left join org.position pos on pp.posId=pos.id";
        List list = getSession().createSQLQuery(sql)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();

        return list;




    }
}
