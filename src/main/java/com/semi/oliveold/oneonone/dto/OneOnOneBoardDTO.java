package com.semi.oliveold.oneonone.dto;

import com.semi.oliveold.faq.dto.AttachmentDTO;
import com.semi.oliveold.member.dto.MemberDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OneOnOneBoardDTO {

    private Long no;
    private Integer type;
    private Long CategoryCode;
    private String title;
    private String body;
    private Long writerMemberId;
    private MemberDTO writer;
    private int count;
    private Date createdDate;
    private Date modifiedDate;
    private String status;
    private List<AttachmentDTO> attachmentList;
    private OneOnOneCategoryDTO oneOnOneCategory;      // faq 카테고리 목록 조회용 밑으로 관련 카테고리 추가하면 됨

}
