(function () {
	getCores();
})();

function getCores() {

	$.get('/calc/core/getCores').done(function (cores) {
		let coresArray = JSON.parse(cores);

		drowCoresTable(coresArray);
	});
};

function drowCoresTable(cores) {
	
	for (let i = 0; i < cores.length; i++) {
		let tr = $('<tr></tr>');
		$('<td>' + (i + 1) + '</td>').appendTo(tr);
		$('<td>' + cores[i].name + '</td>').appendTo(tr);
		$('<td>' + cores[i].coreSize + '</td>').appendTo(tr);
		
		tr.appendTo('#coresTableBody');
	}
};
