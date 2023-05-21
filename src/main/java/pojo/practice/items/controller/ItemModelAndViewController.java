package pojo.practice.items.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.practice.items.ItemOptions;
import pojo.practice.items.ItemVO;
import pojo.practice.items.service.ItemServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("item")
@AllArgsConstructor
public class ItemModelAndViewController {
    @Autowired
    private ItemServiceInterface boardService;
    @GetMapping({"","/list"})
    public String boardMainPage(Model model){
        List<ItemVO> boardList= boardService.itemListForAdmin();
        model.addAttribute("data", boardList);
        model.addAttribute("itemOptions",deliveryCodes());
        return "item/itemMain";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        ItemVO itemVo = new ItemVO();
        model.addAttribute("ItemVO", itemVo);
        model.addAttribute("itemOptions",deliveryCodes());
        return "item/itemCreate";
    }
    //post 방식 create.
    @PostMapping(value = "/create.do")
    public String boardCreate(Model model, ItemVO boardJSON){
        String id = boardService.registItem(boardJSON);

        return "redirect:/item/list";
    }
    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable("id") String id, Model model){
        ItemVO itemVo = boardService.itemDetail(id);
        model.addAttribute("data", itemVo);
        return "item/itemDetail";
    }
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") String id, Model model){
        ItemVO itemVo = boardService.itemDetail(id);
        model.addAttribute("data", itemVo);
        model.addAttribute("itemOptions",deliveryCodes());
        return "item/itemUpdate";
    }
    //post 방식 update
    @PostMapping(value = "/update/{id}")
    public String boardUpdate(@PathVariable("id") String id, Model model, ItemVO itemJSON){
        boardService.modify(itemJSON);
        return "redirect:/item/detail/" + id;
    }

    public List<ItemOptions> deliveryCodes(){
        List<ItemOptions> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new ItemOptions("it","IT자재"));
        deliveryCodes.add(new ItemOptions("visual","영상자재"));
        deliveryCodes.add(new ItemOptions("etc","기타"));
        return deliveryCodes;
    }

}
