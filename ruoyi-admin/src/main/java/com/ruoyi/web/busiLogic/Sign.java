package com.ruoyi.web.busiLogic;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.EncryptionDecrypt.SHA256Util;
import com.ruoyi.system.domain.SysCase;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sign {
    public String sha256Util(List<SysCase> sysCases){

        Long ids = Long.valueOf(0);
        Map<String,Object> map=new HashMap<>();
        for(SysCase syscase :sysCases){
            ids = syscase.getInterfaceId();
            map.put(syscase.getCode(),syscase.getValue());
        }
        //对map按照ascii进行排序
        Map<String, Object> result = new LinkedHashMap<>(map.size());
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        //临时字符串
        String StringA = null;
        //secret
        String secret = "CJd4bE8BlJPP7hxUHHx0UtNXbCeAaIJg";
        for(String key : result.keySet()){
            System.out.println("key"+key + "value"+ result.get(key));
            if (!key.equalsIgnoreCase("sign")){
                StringA = key + "=" +result.get(key)+ "&";
            }
        }
        String stringSignTemp = StringA.substring(0,StringA.length()-1)+ secret;

        String FinSign = SHA256Util.getSHA256StrJava(stringSignTemp);

        result.put("sign",FinSign);
        JSONObject json = new JSONObject(result);
        String param = json.toString();


        return  null;
    }


}
