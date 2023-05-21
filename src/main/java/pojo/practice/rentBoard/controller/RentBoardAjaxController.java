package pojo.practice.rentBoard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.practice.rentBoard.RentBoardVO;
import pojo.practice.rentBoard.service.RentBoardServiceInterface;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rentBoard")
public class RentBoardAjaxController {

    @Autowired
    private RentBoardServiceInterface rentBoardService;

    @RequestMapping("/list.do")
    public List<RentBoardVO> rentList(){
        List<RentBoardVO> rentList= rentBoardService.rentBoardList();
        return rentList;
    }
    @RequestMapping(value = "/delete.do")
    public String rentDelete(@RequestParam Map<String, Object> paramMap, Model model){
        String id = (String)paramMap.get("rentId");
        rentBoardService.removeRentBoard(id);
        return id;
    }

}
