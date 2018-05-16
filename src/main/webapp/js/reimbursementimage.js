
window.onload = function () {
    document.getElementById("getRequests").addEventListener("click", getRequests);
    document.getElementById("getEmployees").addEventListener("click", getEmployees);
    getRequests();
    getEmployees();
}

function getReceipts(requestId){
	
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		  
	console.log(xhr.responseText);
  	console.log(xhr.status);
	if(xhr.readyState === 4 && xhr.status === 200){

	    	
		let receipts = JSON.parse(xhr.responseText);
	  
		console.log(status);
		for (let receipt of receipts){
	
			if (requestId == receipt.id) {
				var encodedData = receipt.base64;
				document.getElementById("image").src = "data:image/png;base64," + encodedData;
				}    
	    	}
		}
	}
	xhr.open("GET", "http://localhost:8080/ProjectOneWeb/getAllImages.ajax");

	xhr.send();
}