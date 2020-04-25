(function () {
	getCables();
	
	$("input[name='conductorName']").focus(function () {
		$.get('/calc/conductor/getAllNames').done(function (data) {
			let chooseData = JSON.parse(data);
                        $("#conductorName").autocomplete({
				source: chooseData,
				appendTo: $("#divConductor")
			});
		});
	});
	
})();

function getCables() {

	$.get('/calc/cable/getCables').done(function (cables) {
		let cablesArray = cables;
		

		drowCableTable(cablesArray);
	});
};

function drowCableTable(cables) {
	
	for (let i = 0; i < cables.length; i++) {
		let tr = $('<tr></tr>');
		$('<td>' + (i + 1) + '</td>').appendTo(tr);
		$('<td>' + cables[i].name + '</td>').appendTo(tr);
		
		if (cables[i].conductor !== null) {
			$('<td>' + cables[i].conductor.name + '</td>').appendTo(tr);
		}else {
			$('<td></td>').appendTo(tr);
		}
		
		$('<td  class="text-center">' + cables[i].numberOfConductors + '</td>').appendTo(tr);
		
		tr.appendTo('#cableTableBody');
	}
};


