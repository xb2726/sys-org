package sys.org.service.impl;

import org.springframework.stereotype.Service;
import sys.org.bo.PppBo;
import sys.org.dao.IPpp;
import sys.org.model.Ppp;
import sys.org.service.PppService;
import sys.org.util.model.Pager;

import javax.inject.Inject;
import java.util.List;

/**
 * @author 27267
 */
@Service("pppService")
public class PppServiceImpl implements PppService {
    @Inject
    private IPpp pppDao;
    @Override
    public void save(Ppp ppp) {
        pppDao.add(ppp);
    }

    @Override
    public void update(Ppp ppp) {
        pppDao.update(ppp);
    }

    @Override
    public void deleteById(int id) {
        pppDao.delete(id);
    }

    @Override
    public void findById(int id) {
        pppDao.load(id);
    }

    @Override
    public List<Ppp> query(PppBo bo) {
        return pppDao.query(bo);
    }

    @Override
    public Pager<Ppp> pagerQuery(PppBo bo) {
        Pager<Ppp> p=new Pager<>();

        Long total = pppDao.getTotal(bo);
        p.setTotal(total);
        if (total==null) return p;
        List<Ppp> pppList = pppDao.query(bo);
        p.setDatas(pppList);
        return p;
    }
}
