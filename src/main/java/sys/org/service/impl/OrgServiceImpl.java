package sys.org.service.impl;

import org.springframework.stereotype.Service;
import sys.org.bo.OrgBo;
import sys.org.dao.IOrgDao;
import sys.org.dao.IPersonDao;
import sys.org.model.Org;
import sys.org.service.OrgService;
import sys.org.util.model.Pager;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 27267
 */
@Service("orgService")
public class OrgServiceImpl implements OrgService {
    @Resource
    private IOrgDao iOrgDao;
    @Resource
    private IPersonDao iPersonDao;

    @Override
    public void save(Org org) {
        // 保存机构
        iOrgDao.add(org);
    }

    @Override
    public void update(Org org) {
        iOrgDao.update(org);
    }

    @Override
    public Org findById(int id) {
        Org org = iOrgDao.load(id);
        return org;
    }

    @Override
    public List<Org> query(OrgBo bo) {
        return iOrgDao.query(bo);
    }

    @Override
    public Pager<Org> pageQuery(OrgBo bo) {
        Pager<Org> pager = new Pager<Org>();
        Long total = iOrgDao.getTotal(bo);
        pager.setTotal(total);
        if (total == null || total == 0) {
            return pager;
        }
        List<Org> orgList = iOrgDao.query(bo);
        pager.setDatas(orgList);
        return pager;
    }

    @Override
    public void deleteById(int id) {
        iOrgDao.delete(id);
    }
}
