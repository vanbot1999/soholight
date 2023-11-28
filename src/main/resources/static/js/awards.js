$(document).ready(function() {
    $.get("/api/awards", function(awards) {
        awards.forEach(function(award) {
            $('#awards-container').append(
                '<div class="card">' +
                '<div class="card-body">' +
                '<h5 class="card-title"><a href="/award-details/' + award.id + '">' + award.name + '</a></h5>' +
                '<h6 class="card-subtitle mb-2 text-muted">' + award.date + '</h6>' +
                '<p class="card-text">' + award.description + '</p>' +
                '</div>' +
                '</div>'
            );
        });
    });
});
