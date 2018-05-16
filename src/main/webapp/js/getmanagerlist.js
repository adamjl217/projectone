window.onload = function () {
	getAllManagers();
}

function getAllManagers() {
    let xhr = new XMLHttpRequest();

    xhr.open("POST", "http://localhost:8080/ProjectOneWeb/getAllManagers.ajax");
    xhr.send();

    xhr.onreadystatechange = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {

            let employees = JSON.parse(xhr.responseText);

            for (let employee of employees) {
            	
            	
                let id = employee.id;
                let username = employee.username;
                let firstname = employee.firstname;
                let lastname = employee.lastname;
                let phonenumber = employee.phonenumber;
                let email = employee.email;
                let datehired = employee.datehired;
                
                let row = document.createElement("tr");
                
                let tdId = document.createElement("td");
                let tdUsername = document.createElement("td");
                let tdFirstname = document.createElement("td");
                let tdLastname = document.createElement("td");
                let tdPhonenumber = document.createElement("td");
                let tdEmail = document.createElement("td");
                let tdDatehired = document.createElement("td");


                tdId.textContent = id;
                tdUsername.textContent = username;
                tdFirstname.textContent = firstname;
                tdLastname.textContent = lastname;
                tdPhonenumber.textContent = phonenumber;
                tdEmail.textContent = email;
                tdDatehired.textContent = datehired;

                row.appendChild(tdId);
                row.appendChild(tdUsername);
                row.appendChild(tdFirstname);
                row.appendChild(tdLastname);
                row.appendChild(tdPhonenumber);
                row.appendChild(tdEmail);
                row.appendChild(tdDatehired);

                document.getElementById("manager_Table").appendChild(row);

            }

        }
    }
}
