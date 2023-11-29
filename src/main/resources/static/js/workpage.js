    $(document).ready(function() {
        $('#addCommentBtn').click(function() {
            $('#commentForm').show();
        });

        $('#commentForm').submit(function(e) {
            e.preventDefault();

            let imageId = $('input[name="imageId"]').val();
            let commentText = $('#commentText').val();

            $.ajax({
                url: $(this).attr('action'),
                type: 'POST',
                data: {
                    imageId: imageId,
                    commentText: commentText
                },
                success: function(response) {
                    console.log('Comment added:', response);
                    $('#commentText').val('');
                    $('#commentForm').hide();
                    loadComments(imageId);
                },
                error: function(xhr, status, error) {
                    alert('Error adding comment: ' + error);
                }
            });
        });
    });

    document.addEventListener('DOMContentLoaded', function() {
    var likeButton = document.getElementById('likeBtn');
    var likeCountDisplay = document.getElementById('likeCount');

    likeButton.addEventListener('click', function() {
        var currentCount = parseInt(likeCountDisplay.textContent);
        likeCountDisplay.textContent = currentCount + 1;
    });
});


    function loadComments(imageId) {
        console.log(imageId);
        $.ajax({
            url: '/getcomments?imageId=' + imageId,
            type: 'GET',
            success: function(comments) {
                console.log(comments);
                let commentsSection = $('#commentsSection');
                commentsSection.empty();

                if (comments.length === 0) {
                    commentsSection.append('<p>No comments yet.</p>');
                } else {
                    $.each(comments, function(index, comment) {
                        commentsSection.append('<div><p>'
                            + comment.commentText +
                            '</p><p>UserID: ' + comment.userID +
                            '</p><p>Time: ' +
                            comment.createdAt + '</p></div>');
                    });
                }
            },
            error: function(xhr, status, error) {
                alert('Error loading comments: ' + error);
            }
        });
    }

    var initialImageId = $('input[name="imageId"]').val();
    loadComments(initialImageId);