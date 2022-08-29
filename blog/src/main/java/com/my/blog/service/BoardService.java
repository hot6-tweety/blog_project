package com.my.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.blog.dto.ReplySaveRequestDto;
import com.my.blog.model.Board;
import com.my.blog.model.Reply;
import com.my.blog.model.User;
import com.my.blog.repository.BoardRepository;
import com.my.blog.repository.ReplyRepository;
import com.my.blog.repository.UserRepository;


@Service // 스프링 컴포넌트 스캔, bean 에 등록 IoC
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user) { //title. content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly =true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly =true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		 boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); // 영속화 완료
		
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당 함수 종료시 (Service가 종료될 때 ) 트랜잭션이 종료, 이때 더티체킹 - 자동업데이트 db flush
	}
	
	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
		
		User user =userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글 작성 실패 : 유저 아이디를 찾을 수 없습니다.");
		});
		
		Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글 작성 실패 : 게시글 아이디를 찾을 수 없습니다.");
		});
		
		Reply reply = new Reply();
		reply.update(user, board, replySaveRequestDto.getContent());
		
		
		replyRepository.save(reply);
	}
	
	@Transactional
	public void 댓글삭제(int replyId) {
		 replyRepository.deleteById(replyId);
	}
	
}
