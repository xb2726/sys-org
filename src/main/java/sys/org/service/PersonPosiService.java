package sys.org.service;

import sys.org.bo.PersonPosiBo;
import sys.org.model.Person;
import sys.org.model.PersonPosi;
import sys.org.util.model.Pager;

import java.util.List;

/**
 * @author 27267
 */
public interface PersonPosiService  {
    /**
     * 保存
     * @param pp
     */
    void save(PersonPosi pp);

    /**
     * 修改
     * @param pp
     */
    void update(PersonPosi pp);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    PersonPosi findById(int id);


    /**
     * query by conditions
     * @return
     */
    List<PersonPosi> query(PersonPosiBo bo);

    Pager<PersonPosi> pageQuery(PersonPosiBo bo);
}

