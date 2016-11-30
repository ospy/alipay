package zmj.alipay.test;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LoginTest {

	public static void main(String[] args) throws IOException {
//		WebClient webClient =  new WebClient();//创建WebClient
		 WebClient webClient = new WebClient(BrowserVersion.CHROME);
		 webClient.getOptions().setUseInsecureSSL(true);
		 webClient.getOptions().setCssEnabled(false);
//		 webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("https://auth.alipay.com/login/index.htm?goto=https%3A%2F%2Fshanghu.alipay.com%2Fi.htm#");    //打开百度
//        HtmlPage page = webClient.getPage("https://auth.alipay.com/login/index.htm");    //打开百度
        //获得name为"登陆"的html元素
//        HtmlElement htmlElement = page.getElementByName("登陆"); 
//        page = htmlElement.click();//调用click()方法
        
        
        System.out.println(page.asXml());
        //获得name为"username"的html元素
        HtmlElement usernameEle =  page.getElementByName("logonId"); 
//      page.getElementById(elementId)
        //获得id为"password"的html元素
        HtmlElement passwordEle =  page.getElementByName("password_rsainput");
        usernameEle.focus();   //设置输入焦点
        usernameEle.type("136786874@qq.com");  //填写值

        passwordEle.focus();   //设置输入焦点
        passwordEle.type("52541laozhao");  //填写值
        //获得name为"登陆"的元素 
        HtmlElement submitEle = (HtmlElement) page.getElementById("J-login-btn"); 
        //点击“登陆”
        page = submitEle.click();
        String result = page.asXml();//获得click()后的html页面（包括标签）
        System.out.println(result);
        if(result.contains("充值")){
             System.out.println("登陆成功");     
        }else{
             System.out.println("登陆失败");
        }
	}

}
