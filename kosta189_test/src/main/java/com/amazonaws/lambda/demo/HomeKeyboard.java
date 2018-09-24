package com.amazonaws.lambda.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HomeKeyboard implements RequestHandler<JSONObject, JSONObject> {


    public JSONObject handleRequest(JSONObject input, Context context) {

        //JSON 객체 생성
        JSONObject js = new JSONObject();
        JSONArray jsArr = new JSONArray();
        
        //버튼에 들어갈 텍스트 넣어주기
        jsArr.add("미래에셋 위치");
        jsArr.add("메뉴");
        jsArr.add("오늘메뉴");
        jsArr.add("식당");
        jsArr.add("과제");
        jsArr.add("명령어");
        jsArr.add("제작자 정보");
        //home keyboard 설정해주기
        
        js.put("buttons", jsArr);
        js.put("type", "buttons");

        return js;

    }
}