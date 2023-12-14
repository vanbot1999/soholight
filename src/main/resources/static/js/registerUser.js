document.getElementById('registrationForm').addEventListener('submit', function(event) {
    var isValid = true;

    function validateField(fieldId, errorId, validationFunction) {
        var fieldValue = document.getElementById(fieldId).value.trim();
        var isValidField = validationFunction(fieldValue);
        document.getElementById(errorId).style.display = isValidField ? 'none' : 'block';
        return isValidField;
    }

    var isNotEmpty = value => value !== '';
    var isPhoneNumberValid = value => /^\d{10}$/.test(value);
    var isEmailValid = value => /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(value);

    isValid &= validateField('firstName', 'firstNameError', isNotEmpty);
    isValid &= validateField('lastName', 'lastNameError', isNotEmpty);
    isValid &= validateField('userName', 'userNameError', isNotEmpty);
    isValid &= validateField('emailAddress', 'emailError', isEmailValid);
    isValid &= validateField('phoneNumber', 'phoneError', isPhoneNumberValid);
    isValid &= validateField('birthday', 'birthdayError', isNotEmpty);

    let password = document.getElementById('password').value;
    isValid &= validateField('password', 'passwordError', isNotEmpty);

    let confirmPassword = document.getElementById('confirmPassword').value;
    if (password !== confirmPassword) {
        document.getElementById('confirmPasswordError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('confirmPasswordError').style.display = 'none';
    }

    if (!isValid) {
        event.preventDefault();
        event.stopPropagation();
    }
});
