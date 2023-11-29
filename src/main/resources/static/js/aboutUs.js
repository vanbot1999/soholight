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


$(document).ready(function() {
    fetchAndDisplayKids();
    setInterval(fetchAndDisplayKids, 200);
});