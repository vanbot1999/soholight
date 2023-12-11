function submitForm() {
    const formData = $('#imageForm').serialize();
    $.ajax({
        type: 'POST',
        url: '/addImage',
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
function enableSubmit(){
    let img_id = document.getElementById("img_id").value;
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    let description = document.getElementById("description").value;
    let url = document.getElementById("img_id").value;
    let sourceUrl = document.getElementById("sourceUrl").value;
    let issueDate = document.getElementById("issueDate").value;
    let submitButton = document.getElementById("submitButton");
    if(img_id === ''|| name === ''||age === ''||description === ''||url === ''||sourceUrl === ''||issueDate === ''){
        submitButton.disabled = true;
    }else{
        submitButton.disabled = false;
    }
}