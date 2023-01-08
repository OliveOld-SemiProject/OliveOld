package com.semi.oliveold.member.dto;

import java.util.List;

// 인가된 정보
public class AuthorityDTO {

    private int code;                                           // 권한코드
    private String name;                                        // 권한명
    private String desc;                                        // 권한설명
    
    private List<AuthenticatedMenuDTO> authenticatedMenuList;   //권한별 인가된 메뉴 목록

    public AuthorityDTO() {
    }

    public AuthorityDTO(int code, String name, String desc, List<AuthenticatedMenuDTO> authenticatedMenuList) {
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.authenticatedMenuList = authenticatedMenuList;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<AuthenticatedMenuDTO> getAuthenticatedMenuList() {
        return authenticatedMenuList;
    }

    public void setAuthenticatedMenuList(List<AuthenticatedMenuDTO> authenticatedMenuList) {
        this.authenticatedMenuList = authenticatedMenuList;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", authenticatedMenuList=" + authenticatedMenuList +
                '}';
    }
}
