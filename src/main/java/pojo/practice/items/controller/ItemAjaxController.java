package pojo.practice.items.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.practice.items.ItemVO;
import pojo.practice.items.service.ItemServiceInterface;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("item")
public class ItemAjaxController {

    @Autowired
    private ItemServiceInterface itemService;

    @RequestMapping("/list.do")
    public List<ItemVO> itemList(){
        List<ItemVO> itemList= itemService.itemListForAdmin();
        return itemList;
    }
    @RequestMapping(value = "/delete.do")
    public String itemDelete(@RequestParam Map<String, Object> paramMap, Model model){
        String id = (String)paramMap.get("itemId");
        itemService.remove(id);
        return id;
    }

}
