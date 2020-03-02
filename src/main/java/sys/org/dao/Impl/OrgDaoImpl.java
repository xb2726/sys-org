package sys.org.dao.Impl;

import org.springframework.stereotype.Repository;
import sys.org.dao.IOrgDao;
import sys.org.dto.TreeDto;
import sys.org.model.Org;
import sys.org.util.dao.BaseDao;
import sys.org.util.model.Pager;

import java.util.List;

/**
 * @author 27267
 */
@Repository("orgDao")
public class OrgDaoImpl extends BaseDao<Org> implements IOrgDao {
    @Override
    public Pager<Org> findByParent(Integer pid) {
        String hql="select o from Org o ";
        if(pid==null){
            hql+=" where o.parent is null";
        }else {
            hql+=" where o.parent.id="+pid;
        }
        return super.find(hql);
    }

    @Override
    public List<TreeDto> tree(Integer tid) {
        String sql="select id,name,pid from org";
        List<TreeDto> tds=super.listBySql(sql,TreeDto.class,false);
        if(tid==null) return tds;

        return null;
    }

    @Override
    public int loadNumByType(Integer pid, int type) {
        String hql="select count(*) from Org where typeId=?";
        return ((Integer)super.queryObject(hql,type)).intValue();
    }

    @Override
    public void addRule(int orgId, int id) {

    }

    @Override
    public void deleteRule(int orgId, int id) {

    }

    @Override
    public List<Integer> listChildByOrg(int id) {
        return null;
    }

    @Override
    public List<TreeDto> listChildTreeByOrg(int id) {
        return null;
    }
}
