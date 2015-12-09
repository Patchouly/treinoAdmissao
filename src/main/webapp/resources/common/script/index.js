/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jsf.ajax.addOnEvent(function(data){
	if ($(data.status) === "success") {
		if ($(data.source).hasClass("delete-row")) {
                    alert("achou");
                    $("render-table").click();
                    alert("deletou e clicou");
                }
	}

});