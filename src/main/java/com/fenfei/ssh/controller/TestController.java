package com.fenfei.ssh.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fenfei.ssh.aop.aop02.ISleepAble;
import com.fenfei.ssh.pojos.Teacher;
import com.fenfei.ssh.pojos.User;
import com.fenfei.ssh.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by shefenfei on 2017/8/29.
 */
public class TestController {

    private Logger logger = Logger.getLogger(UserController.class);

    //    @Autowired
    private Teacher teacher;


    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(Model model) {
        model.addAttribute("username", "aaaa");
        String value = (String) model.asMap().get("username");
        System.out.println(value);
        String resp = " {\n" +
                "        \"student\": null,\n" +
                "        \"baseBodyConstitutionItem\": {\n" +
                "          \"itemName\": \"跳绳\",\n" +
                "          \"icon\": \"http://oq6t96i6t.bkt.clouddn.com/image/body/ROPE-SKIPPING.png\"\n" +
                "        }}";

//        RequestContextUtils.findWebApplicationContext();
        return resp;
    }

    @ResponseBody
    @RequestMapping(path = "/user/{uid}", method = RequestMethod.POST)
    public Map<String, Object> user(@PathVariable("uid") String userId) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", userId);
        return resp;
    }



    @ResponseBody
    @GetMapping("/user/{uId}/{petId}")
    public Map<String, Object> pathVariableDemo(@PathVariable String uId, @PathVariable String petId, @PathVariable int count) {
        System.out.println(uId + "..." + petId + "..." + count);
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", uId);
        return resp;
    }


    /* 矩阵式变量
    @ResponseBody
    @GetMapping("/path/{uId}")
    public Map<String , Object> pathVariableAndDemo(@PathVariable String uId ,@MatrixVariable int type , @MatrixVariable int year) {
        System.out.println(uId + "..." + type + "...." + year);
        Map<String , Object> resp = new HashMap<String, Object>();
        resp.put("UID " , uId);
        return resp;
    }
    */

    @ResponseBody
    @GetMapping("/path/{uId}")
    public Map<String, Object> pathVariableAndDemo(@MatrixVariable(name = "type", pathVar = "uId") int type,
                                                   @PathVariable String uId) {
        System.out.println(uId + "..." + type + "....");
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", uId);
        return resp;
    }


    /**
     * consumes = "application/json" 指传参的时候就要以json的形式 Content-Type=application/json
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/pets", consumes = "application/json")
    public Map<String, Object> testMediaType(@RequestBody User user) {
        System.out.println(user.toString());
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", user.getUsername());
        return resp;
    }


    /**
     * 如果请求中header 中的值不匹配就会404
     *
     * @param headers
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/testHeader",
            headers = "username=shefenfei", //请求头要带有这个消息
            params = "age=1") //并在url上要带有这个参数
    public Map<String, Object> testHeader(@RequestHeader HttpHeaders headers) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", headers);
        return resp;
    }


    /**
     * 测试请求参数 （是获取url上的参数）
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/testReqParams")
    public Map<String, Object> testRequestParams(@RequestParam("userId") String userId, @RequestBody String userId1) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", userId1);
        return resp;
    }


    /**
     * 测试POST请求参数   默认情况下 使用 Content-Type=application/x-www-form-urlencoded
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/testPostReqParams", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, Object> testPostRequestParams(User user, @RequestParam("uid") String uid, String age) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("UID ", user.getUsername());
        resp.put("uid ", uid);
        resp.put("age", age);
        return resp;
    }


    /**
     * 测试POST请求参数   默认情况下 使用 Content-Type=application/x-www-form-urlencoded
     *
     * @param
     * @return
     */
    @PostMapping(path = "/testRest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, Object> testRest(String age, Model model) {
        System.out.println(model.asMap().keySet());
        System.out.println(age);
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("age", age);
        return resp;
    }


    /**
     * 测试 @ModelAttribute 注解
     *
     * @param number
     * @return
     */
    @GetMapping(params = "/testModelAttrbute")
    public Map<String, Object> testAttr(@RequestParam String number) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("age", number);
        return resp;
    }


    /**
     * 会在此controller 中所有的方法执行前执行
     */
//    @ModelAttribute
    public void addUserPro(Model model) {
        System.out.println("addUserPro ..我先执行了...");
        model.addAttribute("username", "zhangwentao");
    }


    //    @ModelAttribute
    public User findUser(@RequestParam(name = "num", required = false) int num) {
        System.out.println("findUser 执行了...");
        User user = new User();
        user.setId(String.valueOf(num));
        return user;
    }


    @GetMapping(path = "/getUserInfo")
    public User getUserInfo(User user) {
        System.out.println(user);
        return user;
    }


    @GetMapping(path = "/findUser/{uId}/{username}")
    public User find(@ModelAttribute User user) {
        System.out.println(user);
        return user;
    }

    //=========================================
    // TODO: 2017/7/27  @SessionAttributes这个注解还有疑问
    @PostMapping(path = "/saveUser")
    public User saveUser(String uId, String username, Model model) {
        User user = new User();
        user.setId(uId);
        user.setUsername(username);
        model.addAttribute("user", user);
        return user;
    }


    @GetMapping(path = "/getUser")
    public User getUser(@SessionAttribute User user) {
        return user;
    }

    //=========================================

    //=================Jackson Serialization View Support========================

    @GetMapping(path = "/testJsonView")
    @JsonView(User.WithoutPasswordView.class)
    public User getUser() {
        User user = new User();
        user.setId("uid1212");
        user.setUsername("shefenfei");
        user.setPassword("!dad");
        user.setSex("man");
        return user;
    }

    //============================================================================


    //============================================================================
    //Asynchronous Request Processing
    @PostMapping(path = "/upload_")
    public Callable<String> processUpload() {
        return new Callable<String>() {
            public String call() throws Exception {

                return "upload_success";
            }
        };
    }

    //============================================================================


    //==============================Intercetor======================================
    @GetMapping(path = "/testIntercept")
    public User testIntercetor() {
        return new User();
    }
    //============================================================================


    //=============================视图解析===============================================
    @GetMapping(path = "/getUserDetail")
    public ModelAndView getUserDetail(Model model) {
        User user = new User();
        user.setId("uid1212");
        user.setUsername("shefenfei");
        user.setPassword("!dad");
        user.setSex("man");
        ModelAndView modelAndView = new ModelAndView("userInfo");
        model.addAttribute("user", user);
        return modelAndView;
    }
    //============================================================================


    @GetMapping(path = "/findPass")
    public String forgetPass(Model model) {

        User user = new User();
        user.setUsername("shefenfei");
        user.setPassword("ASASAS");
        model.addAttribute("user", user);
        return "findPass";
    }


    @GetMapping(path = "/testRedirect")
    public String testRedirect() {
        return "redirect:user/findPass";
    }


    @GetMapping(path = "/getUserBy/{uid}")
    public String testUU(@PathVariable int uid) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/configs/spring/spring.xml");

        Teacher bean = context.getBean("teacher", Teacher.class);
        //由spring的IOC容器来帮你生成你所需要的bean
        IUserService userService = context.getBean("userService", IUserService.class);

        teacher = bean;

        logger.info("This is an info log entry");
        logger.error(uid);
        User user = userService.getUser("" + uid);
        System.out.println(user);
        logger.info(teacher);

        ApplicationContext aopContext = new ClassPathXmlApplicationContext("/configs/spring/spring-aop.xml");
        ISleepAble sleepAble = (ISleepAble) aopContext.getBean("human");
        sleepAble.sleep();

        return "userInfo";
    }


    @GetMapping("/testMessage")
    public String testI18n() {
        List<String> strings = null;
        return "user_message";
    }


    /**
     * spring 文件上传 todo 待完善
     */
    @PostMapping(path = "/upload")
    public String fileUpload(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "file", required = false) MultipartFile file,
                             HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            logger.info("上传文件");
            logger.info(file.getContentType());
            logger.info(file.getSize());
            logger.info(file.getName());
            String path = "/Users/shefenfei/Desktop/" + file.getOriginalFilename();
            File file1 = new File(path);
            file.transferTo(file1);
            return "upload_success";
        }
        return "redirect:";
    }

    //spring mvc 异常处理
    @ExceptionHandler(IOException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String uploadError() {
        return "error";
    }


    @GetMapping(path = "/testAspectJ")
//    @Cacheable("testAspectJ")
    public String testAspectJ() {
        User user = userService.getUser("1");
//        userService.testMethod("shefenfei");
        logger.info(user);
        return "userInfo";
    }


    /**
     * 测试redis
     *
     * @return
     */
    @GetMapping(path = "/testRedis")
    @ResponseBody
    public Map<String, Object> testRedis() {
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUser("1");
        map.put("redis", "redis.....");
        map.put("user", user);
        logger.info("Performing expensive calculation...");
        return map;
    }


    /**
     * 测试shiro用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(path = "/userLogin")
    public String userLogin(String username,  String password) {
        logger.info(username + "....." + password);

        UsernamePasswordToken token = new UsernamePasswordToken(username , password);
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            token.setRememberMe(true);
        }
        try {
            currentUser.login(token);
            return "redirect:/home/index";
        }catch (AuthenticationException e) {
            logger.error("..........................." + e.getMessage());
        }
        return "userInfo";
    }


    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
