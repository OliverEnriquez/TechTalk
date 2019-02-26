
renderPresentationsInfo = function (sku){
    if (!$("#techtalk-info").length) {
        $.ajax({
            url : "/presentation/",
            error : function(jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
            }
        }).done(function(data) {
            $("#techtalk-content").html(data);
            $("#techTalk-table").DataTable({
                responsive : false,
                scrollY: '65vh',
                scrollX: true,
                scrollCollapse: true,
                paging:   false,
                "order" : [ 1, "desc" ],
                'dom' : '<"top">t<"bottom"><"clear">'
            });
        });
    }
}