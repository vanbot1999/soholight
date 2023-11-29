$(document).ready(function() {
    $.get("/api/awards", function(awards) {
        var template = $('#award-template')[0];
        if (template) {
            awards.forEach(function(award) {
                var clone = template.content.cloneNode(true);
                var link = clone.querySelector('.card-title a');
                link.href = '/award-details/' + award.id;
                link.textContent = award.name;
                clone.querySelector('.card-subtitle').textContent = award.date;
                clone.querySelector('.card-text').textContent = award.description;
                $('#awards-container').append(clone);
            });
        }
    }).fail(function(jqXHR, textStatus, errorThrown) {
        console.error("Error getting awards: " + textStatus, errorThrown);
    });
});
