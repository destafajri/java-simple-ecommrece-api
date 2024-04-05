$(document).ready(function () {
    $("#verify-button").click(function (event) {
        event.preventDefault();
        ajaxPost();
    })
});

function ajaxPost() {
    // Assuming verificationUrl is available from Thymeleaf
    const verificationUrl = $(this).data("verification-url");

    // Extract token and OTP from URL
    var urlParams = new URLSearchParams(verificationUrl);
    var token = urlParams.get("token");
    var otp = urlParams.get("code");

    // Create an object with the data to be sent
    var dataToSend = {
        token: token,
        otp: otp
    };

    // Make a POST request to the server using verificationUrl
    fetch(verificationUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dataToSend),
    })
        .then(response => {
            if (response.ok) {
                console.log("Email verification request sent successfully!");
            } else {
                console.error("Error sending email verification request.");
            }
        })
        .catch(error => {
            console.error("An error occurred:", error);
        });
}