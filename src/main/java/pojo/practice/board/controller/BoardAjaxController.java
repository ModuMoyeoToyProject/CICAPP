package pojo.practice.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.practice.board.BoardVO;
import pojo.practice.board.service.BoardService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("board")
public class BoardAjaxController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/list.do")
    public List<BoardVO> boardList(Model model, BoardVO boardJSON, String paramType){
        List<BoardVO> boardList= boardService.boardListForAdmin();
        return boardList;
    }
    @RequestMapping(value = "/delete.do")
    public String boardDelete(@RequestParam Map<String, Object> paramMap, Model model){
        String id = (String)paramMap.get("id");
        boardService.remove(id);
        return id;
    }

}
