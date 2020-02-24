package com.example.facebook.service;

import com.example.facebook.dto.request.CreateImageRequest;
import com.example.facebook.dto.response.CreatePostResponse;
import com.example.facebook.model.Image;
import com.example.facebook.model.Post;
import com.example.facebook.model.User;
import com.example.facebook.repository.ImageRepository;
import com.example.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    PostRepository postRepository;

    public CreatePostResponse create(CreateImageRequest createImageRequest, User sessionUser) {
        List<Image> savedImages = createImageRequest.getImageUrls().stream().map(
                imageUrl -> {
                    Image image = new Image();
                    image.setUrl(imageUrl);
                    image.setUser(sessionUser);
                    return imageRepository.save(image);
                }
        ).collect(Collectors.toList());


        Post newPost = new Post();
        newPost.setUser(sessionUser);
        newPost.setImages(savedImages);

        return CreatePostResponse.of(postRepository.save(newPost));
    }
}
