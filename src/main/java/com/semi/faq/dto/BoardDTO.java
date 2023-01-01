package com.semi.faq.dto;

import com.semi.member.dto.MemberDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {

    private Long no;
    private Integer type;
    private Long CategoryCode;
    private String title;
    private String body;
    private Long writerMemberNo;
    private MemberDTO writer;
    private int count;
    private Date createdDate;
    private Date modifiedDate;
    private String status;
    private List<AttachmentDTO> attachmentList;
    private faqCategoryDTO faqCategory;      // faq 카테고리 목록 조회용 밑으로 관련 카테고리 추가하면 됨

}
