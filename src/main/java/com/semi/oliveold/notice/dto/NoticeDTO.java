package com.semi.oliveold.notice.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeDTO {

    private int noticeNo;
    private String noticeTitle;
    private Date noticeRegistDate;
    private String noticeContent;
    private String noticeWriter;
}
