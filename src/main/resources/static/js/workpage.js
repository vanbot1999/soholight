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




$(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var imageId = urlParams.get('imageId');
    var likeButton = $('#likeBtn');
    var likeCountDisplay = $('#likeCount');
    var likeContainer = $('#likeContainer');

    // 检查用户是否已经点赞
    checkUserLiked(imageId);

    // 绑定点赞按钮的点击事件
    $('#likeBtn').on('click', function() {
        var currentCount = parseInt(likeCountDisplay.text(), 10);

        $.ajax({
            url:   imageId + '/like',
            type: 'POST',
            success: function() {
                // 更新显示的点赞数
                likeCountDisplay.text(currentCount + 1);
                // 更新按钮的状态
                likeButton.prop('disabled', true).addClass('liked');
                $('<button>', {
                    text: 'Delete Like',
                    id: 'deleteLikeBtn',
                    click: function() {
                        // 添加删除点赞的逻辑
                    }
                }).appendTo(likeContainer);
            },
            error: function(xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
    });

    // 检查用户是否已经点赞的函数
    function checkUserLiked(imageId) {
        // 添加检查用户是否已点赞的 AJAX 请求
    }

    // 假设 deleteLikeBtn 已经在 HTML 中存在，您可以使用以下代码：
    $('#deleteLikeBtn').on('click', function() {
        $.ajax({
            url: imageId + '/unlike',
            type: 'POST',
            success: function() {
                var currentCount = parseInt(likeCountDisplay.text(), 10);
                likeCountDisplay.text(Math.max(currentCount - 1, 0));
                likeButton.prop('disabled', false).removeClass('liked');
                $(this).hide();
            },
            error: function(xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
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
// document.addEventListener('DOMContentLoaded', function() {
//     var likeButton = document.getElementById('likeBtn');
//     var likeContainer = document.getElementById('likeContainer');
//     var likeCountDisplay = document.getElementById('likeCount');
//
//     likeButton.addEventListener('click', function() {
//         // ... 省略 AJAX 请求和其他逻辑 ...
//
//         // 添加liked类到按钮，这将使心形变为红色
//         likeButton.classList.add('liked');
//
//         // 创建 "Delete Like" 按钮
//         var deleteLikeBtn = document.createElement('button');
//         deleteLikeBtn.textContent = 'Delete Like';
//         deleteLikeBtn.id = 'deleteLikeBtn';
//         deleteLikeBtn.className = 'delete-like-btn';
//         deleteLikeBtn.onclick = function() {
//             // 这里可以添加删除点赞的逻辑
//             console.log('Delete like clicked');
//         };
//
//         // 添加 "Delete Like" 按钮到容器中
//         likeContainer.appendChild(deleteLikeBtn);
//
//         // 禁用点赞按钮
//         likeButton.disabled = true;
//     });
// });
