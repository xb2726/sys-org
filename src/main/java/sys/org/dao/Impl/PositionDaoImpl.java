package sys.org.dao.Impl;

import org.springframework.stereotype.Repository;
import sys.org.dao.IPositionDao;
import sys.org.model.Position;
import sys.org.util.dao.BaseDao;
import java.util.List;

/**
 * @author 27267
 */
@Repository("positionDao")
public class PositionDaoImpl extends BaseDao<Position> implements IPositionDao {
}
