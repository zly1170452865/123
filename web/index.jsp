<%--
  Created by IntelliJ IDEA.
  User: dadong
  Date: 2020/12/11
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body id="body">
  </body>
  <script src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript">
    $(function () {
        getAll()
      function getAll() {
        var pageIndex = 0;
        $.post("StuinfoServlet",{"type":'getAll',"pageIndex":pageIndex},GetALL,"JSON");
          function GetALL(data) {
            $("#body").append($("<tabel id = 'table'>\n" +
                    "  <tr>\n" +
                    "    <td>id</td>\n" +
                    "    <td>名字</td>\n" +
                    "    <td>密码</td>\n" +
                    "    <td>性别</td>\n" +
                    "    <td>年龄</td>\n" +
                    "    <td>名地址</td>\n" +
                    "    <td>科目</td>\n" +
                    "    <td>操作</td>\n" +
                    "  </tr>\n" +
                    "</tabel>"))
            $(data).each(function () {
                $("#table").append($("<td>'"+this.id+"'</td>\n" +
                        "    <td>'"+this.stu_name+"'</td>\n" +
                        "    <td>'"+this.stu_pwd+"'</td>\n" +
                        "    <td>'"+this.stu_sex+"'</td>\n" +
                        "    <td>'"+this.stu_age+"'</td>\n" +
                        "    <td>'"+this.stu_address+"'</td>\n" +
                        "    <td>'"+this.stu_major+"'</td>\n" +
                        "    <td><a value='"+this.id+"' id='a' href=\"javascript:void(0)\">修改</a></td>"))
            })

            //修改
            // $("#a").click(function () {
            //   var id = this.getAttribute("value");
            //     $("#table").html("");
            //     $.post("StuinfoServlet",{"type":'getOne',"id":id},getALLOne,"JSON");
            //     function getALLOne(data) {
            //       $("#body").append("<form id='form' action=\"\"></form>")
            //       $("#form").append($("<table id='table' border='1'></table>"))
            //       $("#table").append($(" <tr>\n" +
            //               "    <td>id<input name='id' type='text' value='"+this.id+"'></td>\n" +
            //               "    <td>姓名<input name='stu_name' type='text' value='"+this.stu_name+"'></td>\n" +
            //               "    <td>密码<input name='stu_pwd' type='text' value='"+this.stu_pwd+"'></td>\n" +
            //               "    <td>性别<input name='stu_sex' type='text' value='"+this.stu_sex+"'></td>\n" +
            //               "    <td>年龄<input name='stu_age' type='text' value='"+this.stu_age+"'></td>\n" +
            //               "    <td>地址<input name='stu_address' type='text' value='"+this.stu_address+"'></td>\n" +
            //               "    <td>科目<input name='stu_major' type='text' value='"+this.stu_major+"'></td>\n" +
            //               "    <td><input  id='submit' type='submit' value='提交'></td>\n" +
            //               "  </tr>"))
            //       $("#submit").click(function () {
            //         var paramsArray = $("#form").find(":input").serializeArray();
            //         $.post("StuinfoServlet?type",paramsArray,upd,"text");
            //           function upd(data) {
            //             if (data=="true"){
            //               alert("修改成功")
            //               getAll()
            //             }else {
            //               alert("修改失败")
            //             }
            //           }
            //       })
            //     }
            // })

            //下一页上一页
            $("#body").append($("<div class=\"pages\">\n" +
                    "\t\t\t\t\t\t\t<a id='sy' href=\"javascript:void (0)\"\n" +
                    "\t\t\t\tclass=\"p_pre\">首页</a> <a\n" +
                    "\t\t\t\t\thref=\"javascript:void (0)\"\n" +
                    "\t\t\t\tclass=\"cur\" id='syy'>上一页</a><a\n" +
                    "\t\t\t\t\thref=\"javascript:void (0)\"\n" +
                    "\t\t\t\tclass=\"cur\" id='xyy'>下一页</a> <a\n" +
                    "\t\t\t\t\thref=\"javascript:void (0)\"\n" +
                    "\t\t\t\tclass=\"p_pre\" id='wy'>尾页</a>\n" +
                    "\t\t\t\t\t\t\t</div>"));
            //首页方法
            $("#sy").click(function () {
              pageIndex = 1;
              getAll();
            });
            //上一页方法
            $("#syy").click(function () {
              pageIndex = data.pageIndex - 1;
              getAll();
            });
            //下一页方法
            $("#xyy").click(function () {
              pageIndex = data.pageIndex + 1;
              getAll();
            });
            //尾页方法
            $("#wy").click(function () {
              pageIndex = data.pageCount;
              getAll();
            });
          }
      }
    })
  </script>
</html>
