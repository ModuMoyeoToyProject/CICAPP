package pojo.practice.board.controller;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.practice.board.BoardOptions;
import pojo.practice.board.BoardVO;
import pojo.practice.board.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("board")
@AllArgsConstructor
public class BoardModelAndViewController {
    @Autowired
    private BoardService boardService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"","/list"})
    public String boardMainPage(Model model){
        List<BoardVO> boardList= boardService.boardListForAdmin();
        model.addAttribute("data", boardList);
        model.addAttribute("boardOptions",deliveryCodes());
        return "board/boardMain";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        BoardVO boardVo = new BoardVO();
        boardVo.setBoardType("자유");
        model.addAttribute("ItemVO",boardVo);
        model.addAttribute("boardOptions",deliveryCodes());
        return "board/boardCreate";
    }
    //post 방식 create.
    @PostMapping(value = "/create.do")
    public String boardCreate(Model model, BoardVO boardJSON){
        boardService.registBoard(boardJSON);
        return "redirect:/board/list";
    }
    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable("id") String id, Model model){
        BoardVO boardVo = boardService.boardDetail(id);
        model.addAttribute("data",boardVo);
        return "board/boardDetail";
    }
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") String id, Model model){
        BoardVO boardVo = boardService.boardDetail(id);
        model.addAttribute("data",boardVo);
        model.addAttribute("boardOptions",deliveryCodes());
        return "board/boardUpdate";
    }
    //post 방식 update
    @PostMapping(value = "/update/{id}")
    public String boardUpdate(@PathVariable("id") String id, Model model, BoardVO boardJSON){
        boardService.modify(boardJSON);
        return "redirect:/board/detail/" + id;
    }

    public List<BoardOptions> deliveryCodes(){
        List<BoardOptions> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new BoardOptions("free","자유게시판"));
        deliveryCodes.add(new BoardOptions("counseling","상담게시판"));
        deliveryCodes.add(new BoardOptions("notice","공지"));
        return deliveryCodes;
    }

}
