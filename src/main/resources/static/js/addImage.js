function validateForm() {
    let isValid = true;
    let img_id = document.getElementById("img_id").value;
    let name = document.getElementById("name").value;
    let age = parseInt(document.getElementById("age").value);
    let description = document.getElementById("description").value;
    let url = document.getElementById("url").value;
    let sourceUrl = document.getElementById("sourceUrl").value;
    let issueDate = parseInt(document.getElementById("issueDate").value);

    if (isNaN(img_id) || !/^[0-9]{1,6}$/.test(img_id)) {
        document.getElementById('img_id_error').innerText = 'Valid Image ID is required.';
        isValid = false;
    } else {
        document.getElementById('img_id_error').innerText = '';
    }

    if (name === '' || !/^[a-zA-Z ]+$/.test(name)) {
        document.getElementById('name_error').innerText = 'Name is required.';
        isValid = false;
    } else {
        document.getElementById('name_error').innerText = '';
    }

    if (isNaN(age)) {
        document.getElementById('age_error').innerText = 'Age is required.';
        isValid = false;
    } else if (age < 1 || age > 20) {
        document.getElementById('age_error').innerText = 'Not in the permitted age limit (1-20 years)';
        isValid = false;
    } else {
        document.getElementById('age_error').innerText = '';
    }
    if (description === '') {
        document.getElementById('description_error').innerText = 'Description is required.';
        isValid = false;
    } else {
        document.getElementById('description_error').innerText = '';
    }
    if (url === '' || !isValidURL(url)) {
        document.getElementById('url_error').innerText = 'Valid URL is required.';
        isValid = false;
    } else {
        document.getElementById('url_error').innerText = '';
    }
    if (sourceUrl === '' || !isValidURL(sourceUrl)) {
        document.getElementById('source_url_error').innerText = 'Valid Source URL is required.';
        isValid = false;
    } else {
        document.getElementById('source_url_error').innerText = '';
    }
    if (isNaN(issueDate) || issueDate < 2020 || issueDate > 2024) {
        document.getElementById('issue_date_error').innerText = 'Valid Issue year is required.(2020-2024)';
        isValid = false;
    } else {
        document.getElementById('issue_date_error').innerText = '';
    }
    return isValid;
}

function isValidURL(string) {
    var res = string.match(/(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/);
    return (res !== null);
};

function submitForm() {
    if (!validateForm()) {
        document.getElementById('errorMessages').innerText = 'Please fill all the fields correctly.';
        return;
    }
    document.getElementById('errorMessages').innerText = '';
    const formData = $('#imageForm').serialize();
    $.ajax({
        type: 'POST',
        url: '/addImage',
        data: formData,
        success: function (response) {
            $('#result').html('<div class="alert alert-success" role="alert">Form submitted successfully!</div>');
            $('#imageForm').trigger("reset");
        },
        error: function (error) {
            $('#result').html('<div class="alert alert-danger" role="alert">Error submitting form!</div>');
        }
    });
}
