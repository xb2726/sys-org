package sys.org.service;

import sys.org.bo.OrgBo;
import sys.org.model.Org;
import sys.org.util.model.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author 27267
 */
public interface OrgService {

    /**
     * 保存
     * @param org
     */
    void save(Org org);

    /**
     * 修改
     * @param org
     */
    void update(Org org);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Org findById(int id);


    /**
     * query by conditions
     * @return
     */
    List<Org> query(OrgBo bo);

    Pager<Org> pageQuery(OrgBo bo);

    void deleteById(int id);
}
