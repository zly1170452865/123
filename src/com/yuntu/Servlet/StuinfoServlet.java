package com.yuntu.Servlet;

import com.alibaba.fastjson.JSON;
import com.yuntu.biz.StuinfoBiz;
import com.yuntu.biz.impl.StuinfoBizImpl;
import com.yuntu.enetiy.Stuinfo;
import com.yuntu.utli.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StuinfoServlet")
public class StuinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        StuinfoBiz stuinfoBiz = new StuinfoBizImpl();
        if ("getAll".equals(type)){
            String pageIndexStr = request.getParameter("pageIndex");
            int pageIndex =0;
            if (pageIndexStr==null || "".equals(pageIndexStr)){
                pageIndex=1;
            }else {
                pageIndex = Integer.parseInt(pageIndexStr);
            }
            //左边界
            if (pageIndex<1){
                pageIndex=1;
            }
            PageUtil pageUtil = new PageUtil();
            pageUtil.setPageIndex(pageIndex);
            //边界问题,时间显示没有解决
            stuinfoBiz.getPage(pageUtil);
            String JSONStr = JSON.toJSONStringWithDateFormat(pageUtil,"yyyy-MM-dd HH:mm:ss");
            out.print(JSONStr);
        }else if ("upd".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            String stu_name = request.getParameter("stu_name");
            String stu_pwd = request.getParameter("stu_pwd");
            String stu_sex = request.getParameter("stu_sex");
            String stu_age = request.getParameter("stu_age");
            String stu_address = request.getParameter("stu_address");
            String stu_major = request.getParameter("stu_major");
            out.print(stuinfoBiz.upd(new Stuinfo(id,stu_name,stu_pwd,stu_sex,stu_age,stu_address,stu_major)));
        }else if ("getOne".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Stuinfo stuinfo = stuinfoBiz.getOne(id);
            String JSONSt = JSON.toJSONString(stuinfo);
            out.print(JSONSt);
        }
    }
}
