package com.securonix.solr.metrics;

import java.util.Map;

public class ModeName {
    private Map<String, String> params;
    private String paramKey;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }
}