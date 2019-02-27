renderPresentationsInfo = function (){
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