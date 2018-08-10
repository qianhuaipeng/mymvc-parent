package com.alan.web.context;

import com.alan.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: alan.peng
 * description:
 * date: create in 10:05 2018/8/9
 * modified By：
 */
public class UrlMapping {

    private boolean hasPathVariable = false;

    @Getter
    private Pattern urlPattern = null;

    @Getter
    @Setter
    private String url;

    @Setter
    @Getter
    private Method method;

    @Getter
    @Setter
    private Map<String,Integer> pathVariableMap = null;

    public UrlMapping(Method method) {
        super();
        this.method = method;
    }

    public Class<?> getClaze(){
        return method.getDeclaringClass();
    }

    public void setUrlExpression(String urlExpression){
        this.hasPathVariable = true;
        this.urlPattern = Pattern.compile(urlExpression);
    }

    @Override
    public String toString() {
        JSONObject map = new JSONObject();
        map.put("class",getClaze());
        map.put("method",getMethod().getName());
        if (hasPathVariable) {
            map.put("hasPathVariable",hasPathVariable);
            map.put("urlPattern",urlPattern == null ? "" : urlPattern.pattern());
            map.put("url", url);
            map.put("pathVariableMap",pathVariableMap);
        }
        return map.toJSONString();
    }


    public String getPathVariable(String realUrl, String pathVariableName){
        if (!hasPathVariable)
            return null;

        Matcher m = urlPattern.matcher(realUrl);
        if (m.find()) {
            int index = pathVariableMap.get(pathVariableName);
            return m.groupCount() >= index ? StringUtils.decode(m.group(index)) : null;
        }
        return null;
    }

}
