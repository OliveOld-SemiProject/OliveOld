package com.semi.oliveold.faq.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long no;
    private int refBoardNo;
    private String originalName;
    private String savedName;
    private String savePath;
    private String fileType;
    private String thumbnailPath;
    private String status;


}
