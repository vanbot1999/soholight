$(document).ready(function() {
    $('#addCommentBtn').click(function() {
        $('#commentForm').show();
    });});

    $('#commentForm').submit(function(e) {
    e.preventDefault();

    let image_id = $('input[name="imageId"]').val();
    let content = $('#commentText').val();
        let username = getCookie('user');
        $.ajax({
        url: '/addcomment', // 确保这个URL是正确的
        type: 'POST',
        data: {
            image_id: image_id,
            content: content,
            username: username

        },
        success: function(response) {
            // 如果不是用重定向，则需要处理response返回的数据
            console.log('Comment added:', response);
            $('#commentText').val('');
            $('#commentForm').hide();
            loadComments(image_id);
        },
        error: function(xhr, status, error) {
            alert('Error adding comment: ' + error);
        }
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
                            '<h3>' + comment.username + '</h3>' +
                            '<h5>UserID: ' + comment.userId + '</h5>' +
                            '<p> ' + formattedDate + '</p>' +
                            '<div class="comment-box">' +

                            '<p>' + comment.content + '</p>' +

                            '</div>'+
                        '<button>' + 'like' + '</button>' +
                        '<button>' + 'delete' + '</button>'
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
    function getCookie(name) {
        let cookieArray = document.cookie.split(';');
        for(let i = 0; i < cookieArray.length; i++) {
            let cookiePair = cookieArray[i].split('=');
            if(name == cookiePair[0].trim()) {
                return decodeURIComponent(cookiePair[1]);
            }
        }
        return null;
    }