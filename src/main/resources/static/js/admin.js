function loadAllComments() {
    $.ajax({
        url: '/comments',
        type: 'GET',
        success: function(data) {

            var commentsTableBody = $('#commentsTable tbody');
            commentsTableBody.empty();

            data.forEach(function(comment) {
                var date = new Date(comment.create_time);
                var formattedDate = date.toLocaleDateString('zh-CN');

                var commentRow = $('<tr>').append(
                    $('<td>').text(comment.userId),
                    $('<td>').text(comment.content),
                    $('<td>').text(formattedDate),
                    $('<td>').append($('<button>')
                        .addClass('deleteBtn')
                        .text('delete')
                        .click(function() {
                            deleteComment(comment.id);
                        }),

                        $('<button>')
                            .addClass('noticeBtn')
                            .text('send precautions')
                            )



                );

                commentsTableBody.append(commentRow);
            });
        },
        error: function(error) {
            console.log('Error fetching comments:', error);
        }
    });
}

function deleteComment(commentId) {

    if(confirm('确定要删除这条评论吗？')) {

        $.ajax({
            url: '/deletecomment/' + commentId,
            type: 'POST',
            success: function(response) {
                alert('评论已删除');
                loadAllComments();
            },
            error: function(xhr) {
                alert('删除失败: ' + xhr.responseText);
            }
        });
    }
}
$(document).ready(function() {
    loadAllComments();
});
