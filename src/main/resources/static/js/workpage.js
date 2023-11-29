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


    function loadComments(image_id) {
        console.log(image_id);
        $.ajax({
            url: '/getcomments?imageId=' + image_id,
            type: 'GET',
            success: function(comments) {
                console.log(comments);
                let commentsSection = $('#commentsSection');
                commentsSection.empty();

                if (comments.length === 0) {
                    commentsSection.append('<p>No comments yet.</p>');
                } else {
                    $.each(comments, function(index, comment) {

                        var date = new Date(comment.create_time);

                        var formattedDate = date.toLocaleDateString('zh-CN');


                        commentsSection.append(
                            '<h3>UserID: ' + comment.userId + '</h3>' +
                            '<p> ' + formattedDate + '</p>' +
                            '<div class="comment-box">' +

                            '<p>' + comment.content + '</p>' +
                            '</div>'
                        );
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