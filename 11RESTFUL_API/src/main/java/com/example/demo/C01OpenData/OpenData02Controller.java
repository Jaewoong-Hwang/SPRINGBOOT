package com.example.demo.C01OpenData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/openData")
public class OpenData02Controller {

    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    String serviceKey = "xYZ80mMcU8S57mCCY/q8sRsk7o7G8NtnfnK7mVEuVxdtozrl0skuhvNf34epviHrru/jiRQ41FokE9H4lK0Hhg==";
    String pageNo = "1";
    String numOfRows = "10";
    String base_date = "20250509";
    String base_time = "1600";
    String dataType = "JSON";
    String nx = "89";
    String ny = "90";
    @GetMapping("/forcast")
    public void forcast(){
        log.info("GET /openData/forcast...");
        // 서버 정보
        url += "?serviceKey=" + serviceKey;
        url +="&pageNo=" + pageNo;
        url +="&numOfRows=" + numOfRows;
        url +="&base_date=" + base_date;
        url +="&base_time=" + base_time;
        url +="&dataType=" + dataType;
        url +="&nx="+nx;
        url +="&ny="+ny;
        // 요청 헤더(x)
        // 요청 바디(x)
        // 요청 -> 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET,null,String.class);
        System.out.println(response.getBody());
        // 데이터 가공처리
    }

    //------------------------------------------
    public class Body{
        public String dataType;
        public Items items;
        public int pageNo;
        public int numOfRows;
        public int totalCount;
    }

    public class Header{
        public String resultCode;
        public String resultMsg;
    }

    public class Item{
        public String baseDate;
        public String baseTime;
        public String category;
        public int nx;
        public int ny;
        public String obsrValue;
    }

    public class Items{
        public ArrayList<Item> item;
    }

    public class Response{
        public Header header;
        public Body body;
    }

    public class Root{
        public Response response;
    }
    //------------------------------------------
}
