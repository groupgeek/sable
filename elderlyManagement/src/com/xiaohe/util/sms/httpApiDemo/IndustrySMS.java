package com.xiaohe.util.sms.httpApiDemo;

import com.xiaohe.util.sms.common.Config;
import com.xiaohe.util.sms.common.HttpUtil;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "18584430401";
	//private static String smsContent = "100315793";
	private static String templateid = "100315793";
	//private static String param = "789,2";

	/**
	 * 验证码通知短信
	 * @throws Exception 
	 */
	public static String execute(String to,String param) throws Exception
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + templateid + "&param=" + param
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" +  result);
		return result;
	}
}
