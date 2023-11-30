function validatePassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let passwordError = document.getElementById("passwordError");
    if (password === confirmPassword) {
        passwordError.classList.add("hide-element");
        passwordError.classList.remove("display-element");
    } else {
        passwordError.classList.add("display-element");
        passwordError.classList.remove("hide-element");
    }
}

function enableSubmit() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let emailAddress = document.getElementById("emailAddress").value;
    let phoneNumber = document.getElementById("phoneNumber").value;
    let userName = document.getElementById("userName").value;
    let dob = document.getElementById("dob").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let submitButton = document.getElementById("submitButton");
    if (firstName === '' || lastName === '' || emailAddress === '' || phoneNumber === '' || userName === '' || dob === '' || confirmPassword === '' || password === '') {
        submitButton.disabled = true;
    } else
        submitButton.disabled = false;
}

function validateForm() {
    let submitButton = document.getElementById("submitButton");
    let signInError = document.getElementById("signInError");
    if (!submitButton.hasAttribute("disabled")) {
        signInError.addClass("invisible");
        signInError.removeClass("visible");
    } else {
        signInError.addClass("visible");
        signInError.removeClass("invisible");
    }

}



