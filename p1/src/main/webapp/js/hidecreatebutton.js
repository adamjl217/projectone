function hideCreateButton() {
    var y = document.getElementById("infoCreateEmployee");
    if (y.style.display === "none") {
        y.style.display = "block";
    } else {
        y.style.display = "none";
    }
}