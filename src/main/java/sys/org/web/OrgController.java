package sys.org.web;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.org.bo.OrgBo;
import sys.org.model.Org;
import sys.org.service.OrgService;
import org.springframework.ui.Model;
import sys.org.util.GsonUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 27267
 */
@Controller
@RequestMapping("/org")
public class OrgController {
    @Resource
    private OrgService orgService;

    // 返回组织机构树
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    @ResponseBody
    public void queryOrgTree(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Org> orgList = orgService.query(null);
        GsonUtils.printData(response, orgList);
    }

    // 根据组织机构的ID，查询组织机构
    @RequestMapping(value = "/find", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public void findById(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Org org = orgService.findById(id);
        GsonUtils.printData(response, org);
    }

    // 根据组织机构的ID，查询组织机构
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Org org = GsonUtils.wrapFromRequest(request, Org.class);
        orgService.update(org);
        GsonUtils.printData(response, true);
    }

    // 根据id删除组织机构
    @RequestMapping(value = "/delete", params = "id", method = RequestMethod.POST)
    @ResponseBody
    public void deleteById(int id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        orgService.deleteById(id);
        GsonUtils.printData(response, true);
    }

/*    @RequestMapping(value = "/orgs", method = RequestMethod.GET)
    public String list(Model model, OrgBo bo) {

        model.addAttribute("pagers", orgService.query(bo));
        return "org/list";

    }*/

/*    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Org());
        return "org/add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated Org bo, BindingResult br) {
        if (br.hasErrors()) {
            return "org/add";
        }
        orgService.save(bo);

        return "redirect:/org/orgs";

    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(orgService.findById(id));

        return "org/update";

    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated Org org, BindingResult br, Model model, OrgBo bo) {
        Org o = orgService.findById(id);
        if (br.hasErrors()) {
            return "org/update";
        }
        o.setName(org.getName());
        o.setDescription(org.getDescription());
        o.setParentName(org.getParentName());
        o.setOrderNum(org.getOrderNum());
        o.setParentId(org.getParentId());
        orgService.update(o);
        return "redirect:/org/orgs";

    }*/

}
