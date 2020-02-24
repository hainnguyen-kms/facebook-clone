package com.example.facebook.service;

import com.example.facebook.dto.request.CommentRequest;
import com.example.facebook.dto.request.CreatePostRequest;
import com.example.facebook.dto.request.LikeRequest;
import com.example.facebook.model.Comment;
import com.example.facebook.model.FacebookLike;
import com.example.facebook.model.Post;
import com.example.facebook.model.User;
import com.example.facebook.repository.CommentRepository;
import com.example.facebook.repository.FacebookLikeRepository;
import com.example.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    public Comment commentPost(CommentRequest commentRequest, User sessionUser) {
        Optional<Post> post = postRepository.findById(commentRequest.getId());
        if(post.isPresent()) {
            Comment comment = new Comment();
            comment.setPost(post.get());
            comment.setText(commentRequest.getText());
            comment.setUser(sessionUser);
            return commentRepository.save(comment);
        }
        return null;
    }

    public Comment replyComment(UUID commentId, CommentRequest replyRequest, User sessionUser) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if(optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            Comment replyComment = new Comment();
            replyComment.setPost(comment.getPost());
            replyComment.setText(replyRequest.getText());
            replyComment.setUser(sessionUser);

            List<Comment> replies = comment.getReplies();
            replies.add(replyComment);
            comment.setReplies(replies);

            return commentRepository.save(comment);
        }
        return null;
    }
}
