$(document).ready(function () {

    /* 1. Visualizing things on Hover - See next part for action on click */
    $('#stars li').on('mouseover', function () {
        var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

        // Now highlight all the stars that's not after the current hovered star
        $(this).parent().children('li.star').each(function (e) {
            if (e < onStar) {
                $(this).addClass('hover');
            }
            else {
                $(this).removeClass('hover');
            }
        });

    }).on('mouseout', function () {
        $(this).parent().children('li.star').each(function (e) {
            $(this).removeClass('hover');
        });
    });


    /* 2. Action to perform on click */
    $('#stars li').on('click', function () {
        var onStar = parseInt($(this).data('value'), 10); // The star currently selected
        var stars = $(this).parent().children('li.star');

        for (i = 0; i < stars.length; i++) {
            $(stars[i]).removeClass('selected');
        }

        for (i = 0; i < onStar; i++) {
            $(stars[i]).addClass('selected');
        }

        // JUST RESPONSE (Not needed)
        var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
        var msg = "";
        if (ratingValue > 1) {
            msg = "Thanks! You rated this " + ratingValue + " stars.";
        }
        else {
            msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
        }
        document.getElementById("reviewBtn").disabled = false;
        $('#stars li.selected').last().attr('name', 'rating');
        $('#rating').attr('value', ratingValue)


    })

    var ATTRIBUTES = ['myvalue', 'presenter', 'date', 'id', 'avg'];

    $('[data-toggle="modal"]').on('click', function (e) {
        // convert target (e.g. the button) to jquery object
        var $target = $(e.target);
        // modal targeted by the button
        var modalSelector = $target.data('target');

        // iterate over each possible data-* attribute
        ATTRIBUTES.forEach(function (attributeName) {
            // retrieve the dom element corresponding to current attribute
            var $modalAttribute = $(modalSelector + ' #modal-' + attributeName);
            var dataValue = $target.data(attributeName);

            // if the attribute value is empty, $target.data() will return undefined.
            // In JS boolean expressions return operands and are not coerced into
            // booleans. That way is dataValue is undefined, the left part of the following
            // Boolean expression evaluate to false and the empty string will be returned
            $modalAttribute.attr("value", dataValue);
            $modalAttribute.text(dataValue || '');

        });
        console.log($target.data('avg'));
        if($target.data('avg')>0.5) {
            $('#star1').addClass('btn-warning').removeClass('btn-grey');
            console.log("1 star");
        }
        if($target.data('avg')>1.5) {
            $('#star1').addClass('btn-warning').removeClass('btn-grey');
            $('#star2').addClass('btn-warning').removeClass('btn-grey');
            console.log("2 star");
        }
        if($target.data('avg')>2.5) {
            $('#star1').addClass('btn-warning').removeClass('btn-grey');
            $('#star2').addClass('btn-warning').removeClass('btn-grey');
            console.log("3 star");
            $('#star3').addClass('btn-warning').removeClass('btn-grey');
        }
        if($target.data('avg')>3.5) {
            $('#star1').addClass('btn-warning').removeClass('btn-grey');
            $('#star2').addClass('btn-warning').removeClass('btn-grey');
            $('#star3').addClass('btn-warning').removeClass('btn-grey');
            $('#star4').addClass('btn-warning').removeClass('btn-grey');
            console.log("4 star");
        }
        if ($target.data('avg')>4.5) {
            $('#star1').addClass('btn-warning').removeClass('btn-grey');
            $('#star2').addClass('btn-warning').removeClass('btn-grey');
            $('#star3').addClass('btn-warning').removeClass('btn-grey');
            $('#star4').addClass('btn-warning').removeClass('btn-grey');
            $('#star5').addClass('btn-warning').removeClass('btn-grey');
            console.log("5 star");
        }

    });




});


$('#reviewModal').on('show.bs.modal', function(e) {

    var $modal = $(this);

    $.ajax({
        cache: false,
        type: 'POST',
        url: 'backend.php',
        data: 'EID=' + 58,
        success: function(data) {

        }
    });
});renderPresentationsInfo = function (){
    if (!$("#techtalk-info").length) {
        $.ajax({
            url : "/presentation/",
            error : function(jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
            }
        }).done(function(data) {
            $("#techtalk-content").html(data);
        });
    }
}