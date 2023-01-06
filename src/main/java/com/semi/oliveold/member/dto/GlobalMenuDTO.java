package com.semi.oliveold.member.dto;

public class GlobalMenuDTO {

    private int code;               // 메뉴코드
    private String name;            // 메뉴명
    private String url;             // 메뉴 URL
    private String desc;            // 메뉴 설명
    private int order;              // 출력순서
    private String removedYn;       // 삭제여부
    private int type;               // 구분
    private Integer refMenuCode;    // 상위메뉴코드

    public GlobalMenuDTO() {
    }

    public GlobalMenuDTO(int code, String name, String url, String desc, int order, String removedYn, int type, Integer refMenuCode) {
        this.code = code;
        this.name = name;
        this.url = url;
        this.desc = desc;
        this.order = order;
        this.removedYn = removedYn;
        this.type = type;
        this.refMenuCode = refMenuCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getRemovedYn() {
        return removedYn;
    }

    public void setRemovedYn(String removedYn) {
        this.removedYn = removedYn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getRefMenuCode() {
        return refMenuCode;
    }

    public void setRefMenuCode(Integer refMenuCode) {
        this.refMenuCode = refMenuCode;
    }
}
