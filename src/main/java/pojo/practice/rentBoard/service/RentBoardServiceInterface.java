package pojo.practice.rentBoard.service;


import pojo.practice.rentBoard.RentBoardVO;

import java.util.List;

public interface RentBoardServiceInterface {
    String registRentBoard(RentBoardVO rentBoardVO);

    RentBoardVO rentBoardDetail(String rentBoardId);

    List<RentBoardVO> rentBoardList();

    void modifyRentBoard(RentBoardVO rentBoardVO);

    void removeRentBoard(String rentBoardId);

}
