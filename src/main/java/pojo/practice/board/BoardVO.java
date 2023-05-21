package pojo.practice.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO{

    private String id; //게시판 고유id
    private String boardType; //게시판 종류 (input)
    private int boardNo; //게시판 넘버링
    private String title; //제목 (input)
    private String contents; //내용 (input)
    private String register; //작성자(별명) (input)
    private String userId; //작성자 userId;
    private String regDt; //작성일
    private String upDt; //수정일 (input)
    private int viewCnt; //조회수
    private String auth; //비밀글여부 (input)

}
