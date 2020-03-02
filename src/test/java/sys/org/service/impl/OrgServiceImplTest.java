package sys.org.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import sys.org.bo.OrgBo;
import sys.org.model.Org;
import sys.org.service.OrgService;
import sys.org.util.model.Pager;
import sys.org.util.model.SystemContext;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author 27267
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class OrgServiceImplTest {

    @Resource
    private OrgService orgService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void save() {
        String arr = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Org org = new Org();
            String name = "";
            for (int j = 0; j < 6; j++) {
                name += arr.charAt(random.nextInt(36));
            }
            org.setName(name);
            org.setOrderNum(i);
            orgService.save(org);
        }
    }

    @Test
    public void update() {
        Org org = orgService.findById(2);
        org.setDescription("我是描述....");
        orgService.update(org);
    }

    @Test
    public void findById() {
        Org org = orgService.findById(1);
        Assert.notNull(org, "组织机构不存在！" + 1);
        Assert.isTrue(org.getName().equals("利锐科技"));
    }

    @Test
    public void query() {
        // 1. 查询出系统各种所有包含a的组织机构
        SystemContext.setOrder("-name");
        SystemContext.setPageOffset(5);
        SystemContext.setPageSize(5);
        OrgBo bo = new OrgBo();
        bo.setName("a");
        List<Org> orgList = orgService.query(bo);
        Assert.notEmpty(orgList, "查询结果错误，应该包含18条数据！");
        for (Org org : orgList) {
            System.out.println(org.getName());
        }
    }

    @Test
    public void pageQuery() {
        SystemContext.setOrder("-name");
        SystemContext.setPageOffset(5);
        SystemContext.setPageSize(5);
        OrgBo bo = new OrgBo();
        bo.setName("a");
        Pager<Org> pager = orgService.pageQuery(bo);
        Assert.notNull(pager, "结果不可能为空");
        System.out.println("总条数:"+pager.getTotal());
        for (Org org : pager.getDatas()) {
            System.out.println(org.getName());
        }
    }
}
