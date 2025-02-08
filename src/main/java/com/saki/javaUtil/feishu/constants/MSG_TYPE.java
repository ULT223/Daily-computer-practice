package com.saki.javaUtil.feishu.constants;

public enum MSG_TYPE {
    TEXT("text"),
    POST("post"),
    IMAGE("image"),
    INTERACTIVE("interactive"),
    SHARE_CH("share_chat");

    private String type;

   MSG_TYPE(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
