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

    if(confirm('Are you sure you want to delete this comment?')) {

        $.ajax({
            url: '/deletecomment/' + commentId,
            type: 'POST',
            success: function(response) {
                alert('Comment deleted');
                loadAllComments();
            },
            error: function(xhr) {
                alert('failed to delete: ' + xhr.responseText);
            }
        });
    }
}
$(document).ready(function() {
    loadAllComments();
});
