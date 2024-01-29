function submitForm() {
    const visitorName = document.getElementById("visitorName").value;
    const destination = document.getElementById("destination").value;
    const purpose = document.getElementById("purpose").value;
    const modeOfTravel = document.getElementById("modeOfTravel").value;

    const recordsBody = document.getElementById("recordsBody");
    const newRow = recordsBody.insertRow(-1);

    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);

    cell1.textContent = visitorName;
    cell2.textContent = destination;
    cell3.textContent = purpose;
    cell4.textContent = modeOfTravel;
}
