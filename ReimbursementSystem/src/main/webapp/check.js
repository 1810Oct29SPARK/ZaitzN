/**
 * 
 */

let user = {};

let output = "";

window.onload = function () {
	populateUser();
}

function populateUser() {
	// send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/ReimbursementSystem/session").then(function (response) {
		return response.json();
	}).then(function (data) {
		// check whether there was a valid session returned
		// define behavior for no user returned
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/ReimbursementSystem/login";
		} else {
			// define behavior for user returned
			user = data;
			console.log(user);
			output = `
				<h3> Welcome ${user.firstName} ${user.lastName}! </h3>
				<h6> email: ${user.email} </h6>
			`;
		}
		$(document).ready(() => {
			$('#grab').prepend(output);
		});
		
	});




}
$(document).ready(() =>{
	$('#reimbButton').click(()=>{
		$('#hiddenReimb').slideToggle(1000);
	});
});

$(document).ready(() => {
	$('#login').click(() => {
		$('#loginBox').slideToggle(1000);
	});

});