$(document).ready(function() {
    $('#addCommentBtn').click(function() {
        $('#commentForm').show();
    });});

    $('#commentForm').submit(function(e) {
    e.preventDefault();

    let image_id = $('input[name="imageId"]').val();
    let content = $('#commentText').val();
        let username = getCookie('user');
        var currentUserId = getCookie('user');
        if (!currentUserId) {
            alert('您还没有登录。');
            return;
        }
        $.ajax({
        url: '/addcomment',
        type: 'POST',
        data: {
            image_id: image_id,
            content: content,
            username: username

        },
        success: function(response) {

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




$(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var imageId = urlParams.get('imageId');
    var likeButton = $('#likeBtn');
    var likeCountDisplay = $('#likeCount');
    var likeContainer = $('#likeContainer');
    var deleteLikeButton = $('#deleteLikeBtn');
    var currentUserId = getCookie('user');
    if (!currentUserId) {
        alert('您还没有登录。');
        return;
    }

    checkUserLiked(imageId);
    updateLikeCount(imageId);

    likeButton.on('click', function() {
        $.ajax({
            url: '/' + imageId + '/like',
            type: 'POST',
            success: function(response) {
                updateLikeCount(imageId);

                $('#likeCount').text(response);

                likeButton.addClass('liked').prop('disabled', true);

                deleteLikeButton.show();
            },
            error: function(xhr) {
                console.error( xhr.responseText);
            }
        });
    });


    deleteLikeButton.on('click', function() {
        var currentUserId = getCookie('user');
        if (!currentUserId) {
            alert('您还没有登录。');
            return;
        }
        $.ajax({
            url: '/' + imageId + '/unlike',
            type: 'DELETE',
            success: function(response) {
                updateLikeCount(imageId);
                likeButton.removeClass('liked').prop('disabled', false);
                deleteLikeButton.hide();
                $('#likeCount').text(response);
            },
            error: function(xhr) {
                console.error( xhr.responseText);
            }
        });
    });

    function checkUserLiked(imageId) {
        $.ajax({
            url: '/' + imageId + '/check-like',
            type: 'GET',
            success: function(response) {
                if(response) {

                    $('#likeBtn').addClass('liked').prop('disabled', true);
                    $('#deleteLikeBtn').show();
                } else {

                    $('#likeBtn').removeClass('liked').prop('disabled', false);
                    $('#deleteLikeBtn').hide();
                }
                updateLikeCount(imageId);
            },
            error: function(xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
    }
    checkUserLiked(imageId);
    updateLikeCount(imageId);
})


function updateLikeCount(imageId) {
    var currentUserId = getCookie('user');
    if (!currentUserId) {
        alert('您还没有登录。');
        return;
    }
    var urlParams = new URLSearchParams(window.location.search);
    var imageId = urlParams.get('imageId');
    $.ajax({
        url: '/' + imageId + '/like-count',
        type: 'GET',
        success: function (response) {


            $('#likeCount').text(response);

        },
        error: function (xhr) {
            console.error('Error:', xhr.responseText);
        }
    });
}
    function loadComments(image_id) {
        var currentUsername = getCookie('user');
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
                        var commentHtml =  '<h3>' + comment.username + '</h3>' +
                            '<h5>UserID: ' + comment.userId + '</h5>' +
                            '<p> ' + formattedDate + '</p>' +
                            '<div class="comment-box">' +
                            '<p>' + comment.content + '</p>' +
                            '</div>'



                        if (currentUsername === comment.username) {
                            commentHtml += '<button onclick="confirmDelete(' + comment.id + ',\'' + currentUsername + '\')">delete</button>';
                        }
                        commentsSection.append('<div class="comment-box">' + commentHtml + '</div>');
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
function confirmDelete(commentId, username) {
    var confirmed = confirm('Are you sure to delete this comment？');
    if (confirmed) {
        deleteComment(commentId, username);
    }
}


function deleteComment(commentId) {
    var currentUserId = getCookie('user');
    if (!currentUserId) {
        alert('您还没有登录。');
        return;
    }
    $.ajax({
        url: '/delete/' + commentId,
        type: 'DELETE',
        success: function(response) {
            alert('Delete successfully。');
            loadComments($('input[name="imageId"]').val());
        },
        error: function(xhr) {
            alert('System in Error: ' + xhr.responseText);
        }
    });
}
