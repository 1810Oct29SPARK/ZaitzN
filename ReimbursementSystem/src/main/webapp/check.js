/**
 * 
 */

let user = {};

let reimbursement = {};

let output = "";

let stuff = "";

let employees = "";

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
		if (user.roleId.roleId == 1) {
			populateReimbursementEmployee();
		} else {
			populateReimbursementManager();
			populateEmployees();
		}
	});

}

function populateReimbursementEmployee() {
	fetch("http://localhost:7001/ReimbursementSystem/reimbursement")
		.then((response) => {
			return response.json();
		}).then((data) => {
			reimbursement = data;
			console.log(reimbursement);
			$.each(reimbursement, (index, r) => {
				console.log(r);
				if (r.statusId.id == 1) {
					stuff += `
						<tr>
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId}</td>
						</tr>
						`;
				} else if (r.statusId.id == 2) {
					stuff += `
						<tr style="background-color: green">
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId.firstName} ${r.resolverId.lastName}</td>
						</tr>
					`;
				} else {
					stuff += `
						<tr style="background-color: darkred">
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId.firstName} ${r.resolverId.lastName}</td>
						</tr>
					`;
				}
			});
			$('#tableGrab1').html(stuff);
		});
}

function populateReimbursementManager() {
	fetch("http://localhost:7001/ReimbursementSystem/reimbursement")
		.then((response) => {
			return response.json();
		}).then((data) => {
			reimbursement = data;
			console.log(reimbursement);
			$.each(reimbursement, (index, r) => {
				console.log(r);
				if (r.statusId.id == 1) {
					stuff += `
						<tr>
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId}</td>
							<td><button class="btn btn-sm btn-success" id="approve">Approve</button><button class="btn btn-sm btn-danger" id="deny">Deny</button></td>
						</tr>
						`;
				} else if (r.statusId.id == 2) {
					stuff += `
						<tr style="background-color: green">
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId.firstName} ${r.resolverId.lastName}</td>
							<td><button class="btn btn-sm btn-success" id="approve">Approve</button><button class="btn btn-sm btn-danger" id="deny">Deny</button></td>
						</tr>
					`;
				} else {
					stuff += `
						<tr style="background-color: darkred">
							<td>${r.id}</td>
							<td>$${r.amount}</td>
							<td>${r.description}</td>
							<td>${r.employeeId.id}</td>
							<td>${r.statusId.name}</td>
							<td>${r.resolverId.firstName} ${r.resolverId.lastName}</td>
							<td><button class="btn btn-sm btn-success" id="approve">Approve</button><button class="btn btn-sm btn-danger" id="deny">Deny</button></td>
						</tr>
					`;
				}
			});
			$('#tableGrab2').html(stuff);
		});
}

function populateEmployees() {
	fetch("http://localhost:7001/ReimbursementSystem/employee")
		.then((response) => {
			return response.json();
		}).then((data) => {
			employee = data;
			console.log(employee);
			$.each(employee, (index, e) => {
				console.log(e)
				employees +=`
					<tr>
						<td>${e.id}</td>
						<td>${e.firstName}</td>
						<td>${e.lastName}</td>
						<td>${e.email}</td>
						<td>${e.roleId.roleName}</td>
				`;
			})
			$('#eTableGrab').html(employees);
		})
}

var currentRow;

function approveRequest(rId) {
	axios.post("http://localhost:7001/ReimbursementSystem/approve", {
		r_id: "" + rId
	});
}

function denyRequest(rId) {
	axios.post("http://localhost:7001/ReimbursementSystem/deny", {
		r_id: "" + rId
	});
}

$('#rTable').on('click', '#approve', function () {
	currentRow = $(this).closest("tr");
	let rId = currentRow.find("td:eq(0)").text();
	approveRequest(rId);
	window.location.reload();
})


$('#rTable').on('click', '#deny', function () {
	currentRow = $(this).closest("tr");
	let rId = currentRow.find("td:eq(0)").text();
	denyRequest(rId);
	window.location.reload();
})

$(document).ready(() => {
	$('#reimbButton').click(() => {
		$('#hiddenReimb').slideToggle(1000);
	});
});

$(document).ready(() => {
	$('#login').click(() => {
		$('#loginBox').slideToggle(1000);
	});

});

$(document).ready(() => {
	$('#employeeButton').click(() => {
		$('#hiddenEmp').slideToggle(1000);
	});

});

