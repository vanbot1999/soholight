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
                var sendEmailButton = $('<button>')
                    .addClass('noticeBtn')
                    .text('send precautions')
                    .click(function () {
                        sendEmail(comment.userId, this);
                    });
                var commentRow = $('<tr>').append(
                    $('<td>').text(comment.id),
                    $('<td>').text(comment.userId),
                    $('<td>').text(comment.content),
                    $('<td>').text(formattedDate),
                    $('<td>').append($('<button>')
                        .addClass('deleteBtn')
                        .text('delete')
                        .click(function() {
                            deleteComment(comment.id,comment.userId);
                        }),


                        sendEmailButton
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

function deleteComment(commentId,userId) {
    if (confirm('Are you sure you want to delete this comment?')) {

        $.ajax({
            url: '/delete2/' + commentId + '/' + userId,
            type: 'DELETE',
            success: function(response) {
                alert('Comment deleted');
                loadAllComments();
            },
            error: function(xhr) {

                alert('Failed to delete: ' + xhr.responseText);
            }
        });
    }
}
function sendEmail(userId, button) {
    if (confirm('Are you sure you want to send an email to this user?')) {
        $(button).prop('disabled', true).text('Sending...');
        $.ajax({
            url: '/sendEmail/' + userId,
            type: 'POST',
            success: function (response) {
                $(button).text('has sent');
            },
            error: function (xhr) {
                $(button).prop('disabled', false).text('send precautions');
                alert('Failed to send email: ' + xhr.responseText);
            }
        });
    }
}
$(document).ready(function() {
    loadAllComments();
});
