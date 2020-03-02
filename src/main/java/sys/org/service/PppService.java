package sys.org.service;

import sys.org.bo.PppBo;
import sys.org.model.Ppp;
import sys.org.util.model.Pager;

import java.util.List;

/**
 * @author 27267
 */
public interface PppService {
    void save(Ppp ppp);
    void update(Ppp ppp);
    void deleteById(int id);
    void findById(int id);

    List<Ppp> query(PppBo bo);
    Pager<Ppp> pagerQuery(PppBo bo);
}
