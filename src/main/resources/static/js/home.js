function fetchAndDisplayKids() {
    ['2021', '2022', '2023'].forEach(year => {
        $.ajax({
            url: '/random-kids/' + year,
            type: 'GET',
            dataType: 'json',
            success: function (kids) {
                var kidsList = $('#kids-' + year);
                kidsList.find('.kid').addClass('flipping-out');
                setTimeout(function () {
                    kidsList.empty();
                    kids.forEach(function (kid) {
                        var imageElement = $('<img />', {
                            src: kid.url,
                            alt: "Kid Image",
                            class: "img-fluid img-hover-zoom loaded",
                            style: "width:100px; height:112px;",
                            'data-id': kid.id
                        });

                        var kidElement = $('<div />', {
                            class: "col-md-4 text-center mb-3 kid flipping-in",
                            click: function () {
                                window.location.href = '/workpage?imageId=' + kid.id;
                            }
                        });

                        kidElement.append(imageElement);
                        kidElement.append('<p class="mt-auto kid-name"> - ID: ' + kid.id + ' <br>- Name: ' + kid.name + ' <br>- Age: ' + kid.age + '</p>');

                        kidsList.append(kidElement);
                    });
                }, 500);
            },
            error: function (error) {
                console.error('Error fetching kids for year ' + year + ':', error);
            }
        });
    });
}

//#65
function showContent(year) {
    var contents = document.getElementsByClassName('content');
    var tabs = document.getElementsByClassName('tab');
    for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
        tabs[i].classList.remove('active-tab');
    }
    document.getElementById('content' + year).style.display = 'block';
    document.getElementById('tab' + year).classList.add('active-tab');
}
document.addEventListener('DOMContentLoaded', function() {
    fetchAndDisplayKids();
    setInterval(fetchAndDisplayKids, 2000);

    var mybutton = document.getElementById("backToTopBtn");

    function scrollFunction() {
        if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    }

    function topFunction() {
        window.scrollTo({ top: 0});
    }

    if (mybutton) {
        window.onscroll = function() { scrollFunction(); };
        mybutton.onclick = function() { topFunction(); };
    }

    function showContent(year) {
        var contents = document.getElementsByClassName('content');
        var tabs = document.getElementsByClassName('tab');
        for (var i = 0; i < contents.length; i++) {
            contents[i].style.display = 'none';
            tabs[i].classList.remove('active-tab');
        }
        document.getElementById('content' + year).style.display = 'block';
        document.getElementById('tab' + year).classList.add('active-tab');
    }

    document.getElementById('tab2023').addEventListener('click', function() { showContent('2023'); });
    document.getElementById('tab2022').addEventListener('click', function() { showContent('2022'); });
    document.getElementById('tab2021').addEventListener('click', function() { showContent('2021'); });

    showContent('2023');
});