package sys.org.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.org.bo.PersonBo;
import sys.org.model.Org;
import sys.org.model.Person;
import sys.org.service.PersonService;
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
@RequestMapping("/person")
public class PersonCtrl {
    @Resource
    private PersonService personService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public void queryPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PersonBo bo = GsonUtils.wrapFromRequest(request, PersonBo.class);
        List<Person> personList = personService.query(bo);
        GsonUtils.printData(response, personList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "person_edit";
        /*dsf*/
    }
    @RequestMapping(value = "/modify", params = "id", method = RequestMethod.GET)
    public String toModify(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = personService.findById(id);
        request.setAttribute("person", person);
        return "person_edit";
    }
    // 根据用户ID查询用户
    @RequestMapping(value = "/find", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public void findById(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = personService.findById(id);
        GsonUtils.printData(response, person);
    }

    // 新增用户
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = GsonUtils.wrapFromRequest(request, Person.class);
        personService.save(person);
        GsonUtils.printData(response, true);
    }

    // 更新用户
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = GsonUtils.wrapFromRequest(request, Person.class);
        personService.update(person);
        GsonUtils.printData(response, true);
    }

    // 根据id删除用户
    @RequestMapping(value = "/delete", params = "id", method = RequestMethod.POST)
    @ResponseBody
    public void deleteById(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        personService.deleteById(id);
        GsonUtils.printData(response, true);
    }

}
