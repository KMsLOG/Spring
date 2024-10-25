package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}
	
	@Transactional
	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}
	
	@Transactional
	@Override
	public boolean removeBoard(int id) {
		int result = boardDao.deleteBoard(id);
		
		return result == 1;
	}
	
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		
		// 실제로 수정하고 싶은 id를 가진 게시글을 일단 가지고와서
//		Board tmp = boardDao.selectOne(board.getId());
//		tmp.setTitle(board.getTitle());
//		tmp.setContent(board.getContent());
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
