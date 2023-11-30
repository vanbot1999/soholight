function submitForm() {
    var formData = $('#imageForm').serialize();

    $.ajax({
        type: 'POST',
        url: '/admin/addImage',
        data: formData,
        success: function (response) {
            $('#result').html('<div class="alert alert-success" role="alert">Form submitted successfully!</div>');
        },
        error: function (error) {
            $('#result').html('<div class="alert alert-danger" role="alert">Error submitting form!</div>');
            console.error('Error:', error);
        }
    });
}