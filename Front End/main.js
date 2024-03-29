const address = "http://localhost:8080/";

addRequestKindOptions();
addHobbyOptions();

document.querySelector("textarea").addEventListener("input", displayChars);
document.querySelector("form").addEventListener("submit", submitForm);

async function getRequestKinds() {
    return await fetch(address + "kindofrequest")
        .then(function(response) {
            return response.json();
        });
}

async function getHobbies() {
    return await fetch(address + "hobby")
        .then(function(response) {
            return response.json();
        });
}

async function addRequestKindOptions() {
    let selectItems = await getRequestKinds();
    let select = document.getElementById("kindOfRequest");
    for (let i = 0; i < selectItems.length; i++) {
        let option = document.createElement("option");
        option.value = selectItems[i].kind;
        option.innerHTML = selectItems[i].kind;
        select.appendChild(option);
    }
}

async function addHobbyOptions() {
    let hobbyList = await getHobbies();
    let form = document.getElementsByName("contactForm");
    
}

function displayChars() {
    let current = this.value.length;
    document.getElementById("remainingChars").innerHTML = current + "/5000";
}

function submitForm(e) {
    e.preventDefault();
    let form = {};
    form.kindOfRequest = document.forms["contactForm"]["kindOfRequest"].value;
    form.policyNumber = document.forms["contactForm"]["policyNumber"].value;
    form.name = document.forms["contactForm"]["firstName"].value;
    form.lastName = document.forms["contactForm"]["lastName"].value;
    form.requestText = document.forms["contactForm"]["requestText"].value;
    let formJSON = JSON.stringify(form);
    sendForm(formJSON);
    window.location.reload();
}

async function sendForm(json) {
    let response = await fetch(address + "request", {
        method: 'POST',
        body: json,
        headers: {
            'Content-Type': 'application/json'
        }
    });
}