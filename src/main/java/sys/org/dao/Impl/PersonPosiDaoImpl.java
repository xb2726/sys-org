package sys.org.dao.Impl;

import org.springframework.stereotype.Repository;
import sys.org.dao.IPersonPosiDao;
import sys.org.model.PersonPosi;
import sys.org.util.dao.BaseDao;

import javax.annotation.Resource;

/**
 * @author 27267
 */
@Repository("personPosiDao")
public class PersonPosiDaoImpl extends BaseDao<PersonPosi> implements IPersonPosiDao {
}
