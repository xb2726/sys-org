package sys.org.service;

import sys.org.bo.OrgBo;
import sys.org.bo.PersonBo;
import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.util.model.Pager;

import java.util.List;

/**
 * @author 27267
 */
public interface PersonService {

    /**
     * 保存
     * @param org
     */
    void save(Person org);

    /**
     * 修改
     * @param org
     */
    void update(Person org);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Person findById(int id);


    /**
     * query by conditions
     * @return
     */
    List<Person> query(PersonBo bo);

    Pager<Person> pageQuery(PersonBo bo);

    void deleteById(int id);
     List personList();
}
