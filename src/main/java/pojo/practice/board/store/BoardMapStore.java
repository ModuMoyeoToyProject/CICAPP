package pojo.practice.board.store;


import org.springframework.stereotype.Repository;
import pojo.practice.board.BoardVO;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
@Repository
public class BoardMapStore implements BoardStoreInterface {

    private Map<String, BoardVO> boardMap;

    //SQL영역
    //DB를 Map으로 대체하기 때문에 sequence와 sysdate를 대신함
    int seq = 0; //게시글 번호
    Date today = new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss");
    String regDate = date.format(today);    //등록일


    public BoardMapStore(){
        this.boardMap = new LinkedHashMap<>();
        //더미 데이터
        String id = UUID.randomUUID().toString();
        BoardVO firstData = new BoardVO();
        firstData.setId(id);
        firstData.setBoardType("notice");
        firstData.setBoardNo(this.seq++);
        firstData.setTitle("공지사항");
        firstData.setContents("테스트용 첫글");
        firstData.setRegister("테스터1");
        firstData.setUserId("admin");
        firstData.setRegDt(regDate);
        firstData.setViewCnt(0);
        firstData.setAuth("N");
        this.boardMap.put(id, firstData);
    }

    @Override
    public String create(BoardVO boardVO) {
        String id = UUID.randomUUID().toString();
        //고유값
        boardVO.setId(id);
        boardVO.setBoardNo(this.seq++);
        boardVO.setRegDt(this.regDate);
        //조회수 0
        boardVO.setViewCnt(0);
        boardMap.put(boardVO.getId(), boardVO);
        boardMap.toString();
        return boardVO.getId();
    }

    //세부조회
    @Override
    public BoardVO retrieveById(String boardId) {
        BoardVO boardVO = boardMap.get(boardId);
        //조회수 가져와서 증가
        int viewCnt = boardVO.getViewCnt();
        boardVO.setViewCnt(viewCnt+1);
        return boardVO;
    }

    //검색항목 조회
    @Override
    public List<BoardVO> retrieveAllForParam(BoardVO boardVo, String paramType) {
        List<BoardVO> searchedBoardList = new ArrayList<>();
        if (boardVo != null && !paramType.equals("")){
            if(paramType.equals("title")){
                searchedBoardList = boardMap.values().stream().filter(board -> board.getTitle().equals(boardVo.getTitle())).collect(Collectors.toList());
            }else if(paramType.equals("register")){
                searchedBoardList = boardMap.values().stream().filter(board -> board.getRegister().equals(boardVo.getRegister())).collect(Collectors.toList());
            }
        }else{
            searchedBoardList = boardMap.values().stream().filter(board -> board.getAuth().equals("N")).collect(Collectors.toList());
        }
        return searchedBoardList;
    }

    @Override
    public List<BoardVO> retrieveAllForAdmin() {
        return boardMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(BoardVO board) {
        board.setUpDt(regDate);
        boardMap.put(board.getId(), board);
    }

    @Override
    public void delete(String boardId) {
        boardMap.remove(boardId);
    }
}
