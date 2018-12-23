/**
 * 
 */

let user = {};

let reimbursement = {};

let output = "";

let stuff = "";

$(document).ready(() => {
	populateUser();
});

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
			output += `
				<h3> Welcome ${user.firstName} ${user.lastName}! </h3>
				<h5> ${user.roleId.roleName} </h5>
				<h6> email: ${user.email} </h6>
			`;
		}
		$('#grab').prepend(output);
	});

}

function populateReimbursement() {
	fetch("http://localhost:7001/ReimbursementSystem/reimbursement")
		.then((response) => {
			return response.json();
		}).then((data) => {
			reimbursement = data;
			console.log(reimbursement);
			$.each(reimbursement, (index, r) => {
				console.log(r);
				stuff += `
						<tr>
							<td>${r.id}</td>
							<td>${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId}</td>
						</tr>
					`;
			});
			$('#tableGrab').html(stuff);
		})
}

$(document).ready(() => {
	$('#reimbButton').click(() => {
		$('#hiddenReimb').slideToggle(1000);
		populateReimbursement();
	});
});

$(document).ready(() => {
	$('#login').click(() => {
		$('#loginBox').slideToggle(1000);
	});

});