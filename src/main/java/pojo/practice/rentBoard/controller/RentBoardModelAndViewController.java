package pojo.practice.rentBoard.controller;


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
import pojo.practice.items.ItemVO;
import pojo.practice.items.service.ItemServiceInterface;
import pojo.practice.rentBoard.RentBoardVO;
import pojo.practice.rentBoard.service.RentBoardServiceInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("rentBoard")
@AllArgsConstructor
public class RentBoardModelAndViewController {
    @Autowired
    private RentBoardServiceInterface boardService;

    @Autowired
    private ItemServiceInterface itemStoreInterface;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"","/list"})
    public String boardMainPage(Model model){
        List<RentBoardVO> boardList= boardService.rentBoardList();
        model.addAttribute("boardList", boardList);
        return "rentBoard/rentMain";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        RentBoardVO rentBoardVO = new RentBoardVO();
        List<ItemVO> itemVOList = itemStoreInterface.itemListForAdmin();
        model.addAttribute("rentVO", rentBoardVO);
        model.addAttribute("itemList", itemVOList);
        return "rentBoard/rentCreate";
    }
    //post 방식 create.
    @PostMapping(value = "/create.do")
    public String boardCreate(Model model, RentBoardVO boardJSON){
        String id = boardService.registRentBoard(boardJSON);

        return "redirect:/rentBoard/list";
    }
    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable("id") String id, Model model){
        RentBoardVO rentBoardVO = boardService.rentBoardDetail(id);
        model.addAttribute("data", rentBoardVO);
        return "rentBoard/rentDetail";
    }
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") String id, Model model){
        RentBoardVO rentBoardVO = boardService.rentBoardDetail(id);
        List<ItemVO> itemVOList = itemStoreInterface.itemListForAdmin();
        model.addAttribute("RentBoardVO", rentBoardVO);
        model.addAttribute("itemList", itemVOList);
        return "rentBoard/rentUpdate";
    }
    //post 방식 update
    @PostMapping(value = "/update/{id}")
    public String boardUpdate(@PathVariable("id") String id, Model model, RentBoardVO boardJSON){
        boardService.modifyRentBoard(boardJSON);
        return "redirect:/rentBoard/detail/" + id;
    }
    @GetMapping(value = "/rental/{id}")
    public String rental(@PathVariable("id") String id, Model model){
        RentBoardVO rentBoardVO = boardService.rentBoardDetail(id);
        rentBoardVO.setRentalYn("Y");
        //일정처리
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss");
        String now = date.format(today);
        rentBoardVO.setRentDt(now);
        boardService.modifyRentBoard(rentBoardVO);
        //물품수량처리
        String msg = itemStoreInterface.rent(rentBoardVO.getItemId(),rentBoardVO.getItemCnt());
        model.addAttribute("msg",msg);
        return "redirect:/rentBoard/detail/" + id;
    }
    @GetMapping(value = "/returnItem/{id}")
    public String returnItem(@PathVariable("id") String id, Model model){
        RentBoardVO rentBoardVO = boardService.rentBoardDetail(id);
        rentBoardVO.setReturnYn("Y");
        //일정처리
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss");
        String now = date.format(today);
        rentBoardVO.setReturnDt(now);
        boardService.modifyRentBoard(rentBoardVO);
        //물품수량처리
        String msg = itemStoreInterface.returnItem(rentBoardVO.getItemId(),rentBoardVO.getItemCnt());
        model.addAttribute("msg",msg);
        return "redirect:/rentBoard/detail/" + id;
    }

}
