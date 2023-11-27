package com.soholighting.sohoTeam8.cxService;





import com.soholighting.sohoTeam8.cxEnity.Comments;
import com.soholighting.sohoTeam8.cxMapper.KidsImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final KidsImageMapper kidsImageMapper;

    @Autowired
    public CommentService(KidsImageMapper kidsImageMapper) {
        this.kidsImageMapper = kidsImageMapper;
    }

    @Transactional
    public void addComment(Comments comment) {
        kidsImageMapper.insertComment(comment);
    }
    public List<Comments> getCommentsByImageId(Integer imageId) {
        System.out.println(kidsImageMapper.findCommentsByImageId(imageId));
        return kidsImageMapper.findCommentsByImageId(imageId);

    }
}
