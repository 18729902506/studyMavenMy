package example.asserttest;

import org.junit.Assert;

public class AssertTest {
   /* @Test(expected = NullPointerException.class)
   @Test(timeout = 5000)   超时设置
    @Test(expected = xxxException.class)   期望出现异常，如果出现异常则成功，否则测试失败*/

      public void test(){
          String result = "ssssssssss";
          Assert.assertEquals("此处输出提示语",5,result);
          //解析："此处输出提示语"为错误时个人想要输出的错误信息，5 是指期望输出的值
          // result是指调用程序后程序输出给你的结果

          //如果和预期一样为true则成功，否则失败输出msg
          //如果和预期一样为false则成功，否则失败并输出
          boolean a = true;
          Assert.assertTrue("msg", a);
          Assert.assertFalse("msg",a);
      }
}
