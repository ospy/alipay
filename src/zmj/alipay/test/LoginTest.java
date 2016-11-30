package zmj.alipay.test;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LoginTest {

	public static void main(String[] args) throws IOException {
//		WebClient webClient =  new WebClient();//����WebClient
		 WebClient webClient = new WebClient(BrowserVersion.CHROME);
		 webClient.getOptions().setUseInsecureSSL(true);
		 webClient.getOptions().setCssEnabled(false);
//		 webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("https://auth.alipay.com/login/index.htm?goto=https%3A%2F%2Fshanghu.alipay.com%2Fi.htm#");    //�򿪰ٶ�
//        HtmlPage page = webClient.getPage("https://auth.alipay.com/login/index.htm");    //�򿪰ٶ�
        //���nameΪ"��½"��htmlԪ��
//        HtmlElement htmlElement = page.getElementByName("��½"); 
//        page = htmlElement.click();//����click()����
        
        
        System.out.println(page.asXml());
        //���nameΪ"username"��htmlԪ��
        HtmlElement usernameEle =  page.getElementByName("logonId"); 
//      page.getElementById(elementId)
        //���idΪ"password"��htmlԪ��
        HtmlElement passwordEle =  page.getElementByName("password_rsainput");
        usernameEle.focus();   //�������뽹��
        usernameEle.type("136786874@qq.com");  //��дֵ

        passwordEle.focus();   //�������뽹��
        passwordEle.type("52541laozhao");  //��дֵ
        //���nameΪ"��½"��Ԫ�� 
        HtmlElement submitEle = (HtmlElement) page.getElementById("J-login-btn"); 
        //�������½��
        page = submitEle.click();
        String result = page.asXml();//���click()���htmlҳ�棨������ǩ��
        System.out.println(result);
        if(result.contains("��ֵ")){
             System.out.println("��½�ɹ�");     
        }else{
             System.out.println("��½ʧ��");
        }
	}

}
