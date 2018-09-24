package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;
// 날씨 URL 받아오기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;



import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class HomeKeyboard2 implements RequestHandler<JSONObject, JSONObject> {

    @Override
    public JSONObject handleRequest(JSONObject input, Context context) {
        //입력된 메시지에서 content만 뽑아내기

        String answer = input.get("content").toString();
        JSONObject js = new JSONObject();
        JSONArray jsArr = new JSONArray();
        //내보내야 하는 JSON이 2단계여서 객체도 2개가 필요
        JSONObject jsMes = new JSONObject();
        JSONObject jsMes2 = new JSONObject();
        JSONObject jsAns = new JSONObject();

        if(answer.contains("제작자 정보")) {
            jsAns.put("text", "수정 및 재배포 : sorryisme \n 비영리 목적으로 사용됨을 알려드립니다 버그 및 추가 요청사항 : sorryisme@naver.com \n"
                    + "원본자 : 전상무, 소스 사용 관련 문의 중 문제시 삭제예정\n"
                    + "https://github.com/Sangmoo/kakaoTalk_JAVA_AWS");
            jsMes.put("message", jsAns);
        } else if(answer.contains("명령어")) {
            jsAns.put("text", "명령어 : 미래에셋 위치, 메뉴, 오늘메뉴, 식당, 과제, 명령어");
            jsMes.put("message", jsMes2);
        } else if(answer.contains("미래에셋 위치")) {
            jsAns.put("label", "미래에셋 위치");
            jsAns.put("url", "http://naver.me/GBA7uRfw");
            jsMes2.put("text","주소 : 경기도 성남시 분당구 판교역로 241번길 20 지하");
            jsMes2.put("message_button",jsAns);
            jsMes.put("message", jsMes2);
        } else if (answer.contains("식당")) {
            jsAns.put("text", "유스페이스2 근처 식당");
            jsArr.add("피자");
            jsArr.add("돈까스");
            jsArr.add("국밥");
            js.put("buttons", jsArr);
            js.put("type", "buttons");
            jsMes.put("message", jsAns);
            jsMes.put("keyboard", js);

        }else if(answer.contains("피자")) {
            jsAns.put("label", "빅사이즈");
            jsAns.put("url", "http://naver.me/55B7xD34");
            jsMes2.put("text", "돼지 껍데기로 만든 피자 맥주도 맛있음");
            jsMes2.put("message_button",jsAns);
            jsMes.put("message", jsMes2);
        }else if(answer.contains("돈까스")) {
            jsAns.put("label", "짱가네포크포크");
            jsAns.put("url", "http://naver.me/Fg8iywcX");
            jsMes2.put("text", "매콤 돈까스 양 많은 편");
            jsMes2.put("message_button",jsAns);
            jsMes.put("message", jsMes2);
        } else if(answer.contains("국밥")) {
            jsAns.put("label", "현대옥 판교점");
            jsAns.put("url", "http://naver.me/F3BvEc7a");
            jsMes2.put("text", "돼지국밥이 맛있는 콩나물국밥집");
            jsMes2.put("message_button",jsAns);
            jsMes.put("message", jsMes2);
        } else if(answer.equals("메뉴")) {
            jsAns.put("text", 
                    "월 | \n"
                            + "한식코너 : 흑미밥, 미역국, 매콤 제육, 감자채볶음, 탕평채, 양배추샐러드, 김치\n "
                            + "일품코너 : 김치볶음밥 +김가루, 미역국, 김말이튀김, 짜장떡볶이, 감자채볶음, 김치\n"
                            + "화 | \n"
                            + "한식코너 : 흑미밥, 콩나물국, 오징어볶음, 두부찜+양념장, 새송이버섯볶음, 오이무침, 김치\n"
                            + "일품코너 : 카레라이스, 콩나물국, 미트볼케찹조림, 새송이버섯볶음, 청경채겉절이, 김치\n"
                            + "수 | \n"
                            + "한식코너 : 흑미밥, 순대국, 고등어유자소스구이, 도토리묵야채무침, 죽봉어묵볶음, 고구마순나물, 김치\n"
                            + "일품코너 : 막국수, 쌀밥, 만두찜, 죽봉어묵볶음, 락교*오복지, 김치\n"
                            + "목 | \n"
                            + "한식코너 : 흑미밥, 시금치된장국, 닭볶음탕, 햄야채볶음, 건파래자반, 얼갈이나물, 김치\n"
                            + "일품코너 : 캔참치볶음밥, 시금치된장국, 야채고로케+케찹, 햄야채볶음, 만다린샐러드*오렌지D 김치\n"
                            + "금 | \n"
                            + "한식코너 : 흑미밥, 다시마무국, 간장돈불고기, 영양잡채, 둥근호박전, 숙주나물, 김치\n"
                            + "일품코너 : 마파두부덮밥, 다시마무국, 만두튀김*초간장, 쫄면야채무침, 건새우마늘쫑볶음, 김치\n");
            jsMes.put("message", jsAns);

        } else if(answer.contains("오늘메뉴")) {
            jsAns.put("text", "목 | \n"
                    + "한식코너 : 흑미밥, 시금치된장국, 닭볶음탕, 햄야채볶음, 건파래자반, 얼갈이나물, 김치\n"
                    + "일품코너 : 캔참치볶음밥, 시금치된장국, 야채고로케+케찹, 햄야채볶음, 만다린샐러드*오렌지D 김치\n");
            jsMes.put("message", jsAns);
        } else if(answer.contains("과제")) {
            jsAns.put("text", "1순위. 시험 문제 관리 프로그램\r\n" + 
                    "2순위. 채팅 프로그램 \r\n" + 
                    "각자 추석연휴 간에 기능 발생될 문제점 등을 생각정리해서 금요일까지 전달  ");
            jsMes.put("message", jsAns);
        } else if(answer.contains("박성호")) {
            jsAns.put("text", "스파링 파트너 구함 010-****-****");
            jsMes.put("message", jsAns);
        } else if(answer.contains("박병현")) {
            jsAns.put("text", "미슐랭 박병현, 도망자 박병현, 별로다");
            jsMes.put("message", jsAns);
        } else if(answer.contains("이한나")) {
            jsAns.put("text", "OㅅO 두 개 표정 중 하나  ");
            jsMes.put("message", jsAns);
        } else if(answer.contains("김지혜")) {
            jsAns.put("text", "맹해 보이는 것이 특징, 이랏샤이마세 미래엣셋 이따다끼마스");
            jsMes.put("message", jsAns);
        } else if(answer.contains("김지성")) {
            jsAns.put("text", "힘내자");
            jsMes.put("message", jsAns);
        }

        return jsMes;
        //완성된 JSON 내보내기
    }
}

