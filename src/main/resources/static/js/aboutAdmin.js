
function fetchAndDisplayKids() {
    ['2021', '2022', '2023'].forEach(year => {
        $.ajax({
            url: '/random-kids/' + year,
            type: 'GET',
            dataType: 'json',
            success: function(kids) {
                var kidsList = $('#kids-' + year);
                kidsList.empty();
                kids.forEach(function(kid) {
                    var imageElement = $('<img />', {
                        src: kid.url,
                        alt: "Kid Image",
                        class: "img-fluid",
                        style: "width:100px; height:auto;",
                        'data-id': kid.id
                    }).on('load', function() {
                        $(this).addClass('loaded');
                    });

                    var kidElement = $('<div />', {
                        class: " text-center mb-3 kid",
                        html: imageElement,
                        click: function() {
                            window.location.href = '/workpage?imageId=' + kid.id;
                        }
                    });



                    kidsList.append(kidElement);
                });
            },
            error: function(error) {
                console.error('Error fetching kids for year ' + year + ':', error);
            }
        });
    });
}

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

window.onload = function() {
    let userId = getCookie('user');
    let welcomeMessage = document.getElementById('welcomeMessage');
    let logoutButton = document.getElementById('logoutButton');
    let dropmenu = document.getElementById('dropmenu');
    if(userId) {
        welcomeMessage.innerHTML = ' Admin:' + userId;
        logoutButton.style.display = 'inline-block';
        dropmenu.style.display = 'none';
    } else {
        dropdownmenu.style.display = 'inline';
        logoutButton.style.display = 'none';
    }
};
$('#logoutButton').click(function() {
    $.post('/logout', function(data, status) {
        if (status === 'success') {


            $('#logoutButton').hide();
            window.location = '/Adminlogin';
        } else {
            console.error('Logout failed');
        }
    });
});

$(document).ready(function() {
    fetchAndDisplayKids();
    setInterval(fetchAndDisplayKids, 200);
});


