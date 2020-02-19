package com.example.facebook.service;

import com.example.facebook.dto.request.FriendRequestDTO;
import com.example.facebook.exception.ErrorRequestException;
import com.example.facebook.model.User;
import com.example.facebook.model.UserFriend;
import com.example.facebook.repository.UserFriendRepository;
import com.example.facebook.repository.UserRepository;
import com.example.facebook.util.FriendRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFriendRepository userFriendRepository;
    public UserFriend requestFriend(FriendRequestDTO friendRequestData, User sessionUser) {
        Optional<User> friend = userRepository.findById(friendRequestData.getFriendId());
        if(!friend.isPresent()) {
            throw new ErrorRequestException("FriendId Not Exist");
        }

        Optional<UserFriend> userFriend = userFriendRepository.findByUserIdAndFriendId(
                sessionUser.getId(), friendRequestData.getFriendId()
        );
        Optional<UserFriend> userFriendReverted = userFriendRepository.findByUserIdAndFriendId(
                friendRequestData.getFriendId(), sessionUser.getId()
        );

        if(userFriend.isPresent() || userFriendReverted.isPresent()){
            throw new ErrorRequestException("Friend request existed");
        }

        UserFriend newUserFriend = new UserFriend();
        newUserFriend.setFriend(friend.get());
        newUserFriend.setUser(sessionUser);
        newUserFriend.setIsAccepted(FriendRequestStatus.NEW);
        return userFriendRepository.save(newUserFriend);
    }
    public void actionFriendRequest(FriendRequestDTO friendRequestData, User sessionUser, FriendRequestStatus status) {
        Optional<UserFriend> userFriend = userFriendRepository.findByUserIdAndFriendId(
                sessionUser.getId(), friendRequestData.getFriendId()
        );
        Optional<UserFriend> userFriendReverted = userFriendRepository.findByUserIdAndFriendId(
                friendRequestData.getFriendId(), sessionUser.getId()
        );

        if(userFriend.isPresent()){
            UserFriend updateUserFriend = userFriend.get();
            updateUserFriend.setIsAccepted(status);
            userFriendRepository.save(updateUserFriend);
        }

        if(userFriendReverted.isPresent()){
            UserFriend updateUserFriend = userFriendReverted.get();
            updateUserFriend.setIsAccepted(status);
            userFriendRepository.save(updateUserFriend);
        }
    }
}
