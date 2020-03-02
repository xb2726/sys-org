package sys.org.dao;
import sys.org.dto.TreeDto;
import sys.org.model.Org;
import sys.org.util.dao.IBaseDao;
import sys.org.util.model.Pager;

import java.util.List;

/**
 * @author 27267
 */
public interface IOrgDao extends IBaseDao<Org> {
    public Pager<Org> findByParent(Integer pid);
    //根据组织类型来生成这棵树，如果tid为null，那么就获取所有组织
    public List<TreeDto> tree(Integer tid);
//根据组织类型，获取该父节点下究竟有多少个子组织，再添加组织的时候确定是否可以添加
    public int loadNumByType(Integer pid,int type);
    //添加某个组织机构可以管理的子组织id
    public  void addRule(int orgId,int id);
    //删除子组织
    public void deleteRule(int orgId,int id);
    //获取某个组织下面的所有子组织。如果组织类型是no_type  返回null;
    //如果类型是DEFAULT_TYPE，返回该组织的所有子节点。如果组织类型是ALL_TYPE  返回所有组织
    //如果类型是DEF_TYPE ，获取所有子组织下的子节点
    public List<Integer> listChildByOrg(int id);
    //获取某个子组织下的节点数
    public  List<TreeDto> listChildTreeByOrg(int id);
}
