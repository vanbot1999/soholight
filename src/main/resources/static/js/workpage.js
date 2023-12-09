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
    var deleteLikeButton = $('#deleteLikeBtn');

    // 检查用户是否已经点赞
    checkUserLiked(imageId);

    // 绑定点赞按钮的点击事件
    likeButton.on('click', function () {
        $.ajax({
            url: '/' + imageId + '/like', // 根据后端定义的路由修改
            type: 'POST',
            success: function () {
                // 更新显示的点赞数
                var currentCount = parseInt(likeCountDisplay.text(), 10);
                likeCountDisplay.text(currentCount + 1);
                 likeButton.addClass('liked').prop('disabled', true);
                // 显示 "Delete Like" 按钮
                deleteLikeButton.show();
            },
            error: function (xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
    });
    deleteLikeButton.on('click', function () {
        $.ajax({
            url: '/' + imageId + '/like', // 根据后端定义的路由修改
            type: 'DELETE',
            success: function () {
                // 更新显示的点赞数
                var currentCount = parseInt(likeCountDisplay.text(), 10);
                likeCountDisplay.text(Math.max(currentCount - 1, 0));
                // 更新按钮的状态
                likeButton.removeClass('liked').prop('disabled', false);
                // 隐藏 "Delete Like" 按钮
                deleteLikeButton.hide();
            },
            error: function (xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
    });

    // 检查用户是否已经点赞的函数
    function checkUserLiked(imageId) {
        $.ajax({
            url: '/' + imageId + '/check-like', // 假设您有一个用于检查点赞的后端路由
            type: 'GET',
            success: function (response) {
                // 如果用户已经点赞，则更新按钮状态
                if (response) {
                    likeButton.hide();
                    deleteLikeButton.show();
                }
            },
            error: function (xhr) {
                console.error('Error:', xhr.responseText);
            }
        });
    }
})



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
