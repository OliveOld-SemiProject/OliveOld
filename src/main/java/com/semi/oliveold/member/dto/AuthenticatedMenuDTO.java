package com.semi.oliveold.member.dto;

// 인증된 메뉴
public class AuthenticatedMenuDTO {
    
    private int authorityCode;         // 권한코드
    private int menuCode;              // 메뉴코드
    
    private GlobalMenuDTO globalMenu;  // 메뉴 상세정보

    public AuthenticatedMenuDTO() {
    }

    public AuthenticatedMenuDTO(int authorityCode, int menuCode, GlobalMenuDTO globalMenu) {
        this.authorityCode = authorityCode;
        this.menuCode = menuCode;
        this.globalMenu = globalMenu;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public GlobalMenuDTO getGlobalMenu() {
        return globalMenu;
    }

    public void setGlobalMenu(GlobalMenuDTO globalMenu) {
        this.globalMenu = globalMenu;
    }

    @Override
    public String toString() {
        return "AuthenticatedMenuDTO{" +
                "authorityCode=" + authorityCode +
                ", menuCode=" + menuCode +
                ", globalMenu=" + globalMenu +
                '}';
    }
}
