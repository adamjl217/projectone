function hideReimbursementsButton() {
    var x = document.getElementById("infoReimbursementButton");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
