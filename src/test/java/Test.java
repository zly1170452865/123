import com.yuntu.biz.StuInfoBiz;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Sex;
import com.yuntu.pojo.StuInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void getPage(){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        PageUtil<StuInfo> pageUtil=new PageUtil<StuInfo>();
        pageUtil.setPageindex(1);
        pageUtil.setPagesize(2);
        biz.getPage(pageUtil);
        for (StuInfo stu:pageUtil.getLists()) {
            System.out.println(stu.toString());
        }
    }
    @org.junit.Test
    public void addStuInfo(){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        StuInfo stu=new StuInfo("梨","123","10","江西南昌","计算机",new Sex(2,null));
        int num=biz.addStuInfo(stu);
        if (num!=0){
            System.out.println("成功");
        }else {
            System.out.println("成功");
        }
    }
    @org.junit.Test
    public void updStuInfo(){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        StuInfo stu=new StuInfo(1,"梨","123","10","江西南昌","计算机",new Sex(2,null));
        int num=biz.updStuInfo(stu);
        if (num!=0){
            System.out.println("成功");
        }else {
            System.out.println("成功");
        }
    }
    @org.junit.Test
    public void delStuInfo(){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        int num=biz.delStuInfo(7);
        if (num!=0){
            System.out.println("成功");
        }else {
            System.out.println("成功");
        }
    }
    @org.junit.Test
    public void getOne(){
        ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz =(StuInfoBiz) appCon.getBean("stuInfoBiz");
        System.out.println(biz.getOne(1).toString());
    }
}
