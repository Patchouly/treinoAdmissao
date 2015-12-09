/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on('click', '.edit-client', function () {
    var nome = $(this).closest('tr').find('#clientName').text();
    var id = $(this).closest('tr').find('#clientId').text();
    $('.edit-name').val(nome);
});

jsf.ajax.addOnEvent(function (data) {
    if (data.status === "success") {
        console.log($(data.source).attr("class"));
        if ($(data.source).hasClass("btn-delete")) {
            $('.render-table').click();
        }
    }

});