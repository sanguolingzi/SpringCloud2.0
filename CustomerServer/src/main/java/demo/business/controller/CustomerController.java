package demo.business.controller;

import brave.Tracer;
import demo.business.httpresponse.ResponseData;
import demo.business.service.info.CustomerInfoService;
import model.custoemr.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseDataUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerInfoService customerInfoServiceImpl;

    @Autowired
    private Tracer tracer;

    @GetMapping(value="getCustomerInfo")
    public ResponseData<CustomerModel> getCustomerInfoExecutor(@RequestParam("customerId") String customerId,
                                                               HttpServletRequest request){
        tracer.currentSpan().tag("customer","user");
        return ResponseDataUtil.toSuccess(customerInfoServiceImpl.getCustomerInfo(customerId));
    }

    @PostMapping(value="getCustomerInfo")
    public ResponseData<CustomerModel> getCustomerInfoExecutor(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String>  enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            System.out.println(name+"="+request.getHeader(name));
        }
        //for(Cookie cookie:request.getCookies()){
        //    System.out.println(cookie);
        //}
        /*
        StringBuilder cookieBuilder = new StringBuilder();
        cookieBuilder.append("JSESSIONID=").append(request.getSession().getId() )
                .append(";")
                .append("Path=").append(request.getContextPath())
                .append(";")
                .append("Domain=").append(request.getServerName())
                .append(";HttpOnly=false");
        response.addHeader("SET-COOKIE",cookieBuilder.toString());
        */
        Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
        cookie.setPath(request.getContextPath());
        cookie.setDomain(request.getServerName());
        cookie.setHttpOnly(false);
        response.addCookie(cookie);
        return ResponseDataUtil.toSuccess();
    }


    @GetMapping(value="forElExpression")
    public ResponseData<Object> forElExpression(String customerId){
        customerInfoServiceImpl.forElExpressMethod(customerId);
        return ResponseDataUtil.toSuccess();
    }
}
