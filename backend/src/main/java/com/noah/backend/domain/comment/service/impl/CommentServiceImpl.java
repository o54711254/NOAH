package com.noah.backend.domain.comment.service.impl;

import com.noah.backend.domain.comment.dto.requestDto.CommentPostDto;
import com.noah.backend.domain.comment.dto.requestDto.CommentUpdateDto;
import com.noah.backend.domain.comment.dto.responseDto.CommentGetDto;
import com.noah.backend.domain.comment.dto.responseDto.CommentListGetDto;
import com.noah.backend.domain.comment.entity.Comment;
import com.noah.backend.domain.comment.repository.CommentRepository;
import com.noah.backend.domain.comment.service.CommentService;
import com.noah.backend.domain.datailPlan.repository.DetailPlanRepository;
import com.noah.backend.domain.plan.repository.PlanRepository;
import com.noah.backend.domain.review.entity.Review;
import com.noah.backend.domain.review.repository.ReviewRepository;
import com.noah.backend.domain.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final TicketRepository ticketRepository;
    private final PlanRepository planRepository;
    private final DetailPlanRepository detailPlanRepository;
    private final ReviewRepository reviewRepository;
    private final CommentRepository commentRepository;
//    private final MemberRepository memberRepository;

    @Override
    public List<CommentListGetDto> getCommentList(Long reviewId) {
        return commentRepository.getCommentList(reviewId)
                .orElseThrow(() -> new RuntimeException("코멘트가 없슈"));
    }

    @Override
    public CommentGetDto getCommentSelect(Long commentId) {
        return commentRepository.getCommentSelect(commentId)
                .orElseThrow(() -> new RuntimeException("코멘트가 없어요"));
    }

    @Override
    public Long createComment(CommentPostDto commentDto) {
        Comment comment = Comment.builder()
                .id(commentDto.getId())
                .content(commentDto.getContent())
                .build();
        Comment saveComment = commentRepository.save(comment);
        return comment.getId();
    }

    @Override
    public Long updateComment(Long commentId, CommentUpdateDto commentDto) {
        Comment currentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("코멘트 없어용"));
        currentComment.setContent(commentDto.getContent());
        commentRepository.save(currentComment);

        return currentComment.getId();
    }

    @Override
    public void deleteReview(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
