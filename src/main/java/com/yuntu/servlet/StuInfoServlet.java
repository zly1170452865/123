package com.yuntu.servlet;

import com.yuntu.biz.StuInfoBiz;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.StuInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StuInfoServlet")
public class StuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String type=request.getParameter("type");
        //*********************************************************
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        if ("StuInfoPage".equals(type)){
            String pageIndexStr=request.getParameter("pageIndexStr");
            int pageIndex=0;
            if (pageIndexStr==null){
                pageIndex=1;
            }else {
                pageIndex=Integer.parseInt(pageIndexStr);
            }
            //左边界
            if (pageIndex<1){
                pageIndex=1;
            }
            PageUtil<StuInfo> pageUtil=new PageUtil<StuInfo>();
            pageUtil.setPageindex(pageIndex);
            pageUtil.setPagesize(3);
            biz.getPage(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if ("".equals(type)){

        }else if ("".equals(type)){

        }else if ("".equals(type)){

        }else if ("".equals(type)){

        }else if ("".equals(type)){

        }else{

        }


        //*********************************************************
        out.flush();
        out.close();
    }
}
