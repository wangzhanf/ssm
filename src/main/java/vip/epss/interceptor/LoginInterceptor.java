package vip.epss.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 实现登录验证的拦截功能    实现 Interceptor接口
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //开启登录验证
        //首先应该获取当前的地址
        String uri = request.getRequestURI();
        //如果用户访问的地址是无需验证的页面,则放行
        if (uri.indexOf("/user/login") >= 0 || uri.indexOf("/user/loginCheck") >= 0) {
            return true;//放行
        }

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("USER_SESSION");
        if (username != null && username != "") {
            return true;//用户已经登录则放行
        }
        //如果不放行,则跳转到登录页面
        request.setAttribute("msg", "亲,请先登录");
        request.getRequestDispatcher("/user/login").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
