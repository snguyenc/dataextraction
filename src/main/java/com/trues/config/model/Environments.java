package com.trues.config.model;

import java.util.HashMap;
import java.util.Map;

public class Environments {

    private String active;
    private Map<String, Env> envs = new HashMap<String, Env>();

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void addEnv(Env env) {
        this.envs.put(env.getName(), env);
    }

    public Env getActiveEnv() {
        return this.envs.get(active);
    }
}
