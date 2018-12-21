package club.fangqcloud.impl;

import club.fangqcloud.service.LoginService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {
    private static final String AppID = "wx78568ba6b724e240";
    private static final String AppSecret = "5ed13e2240795f6b29728f0d6e527a65";
    
    @Override
    public String login(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+AppID+
                "&secret="+AppSecret+"&js_code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        //进行网络请求,访问url接口
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        //根据返回值进行后续操作
        String sessionData = null;
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK)
        {
            sessionData = responseEntity.getBody();
        }
    
        return sessionData;
    }
}
