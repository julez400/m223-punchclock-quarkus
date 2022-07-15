const URL = 'http://localhost:8080';

function onload(){
    document.getElementById("loginForm").addEventListener("submit", login)
}

function login(e){
    const data = {};
    const formData = new FormData(e.target);
    data["username"] = formData.get("username");
    data["password"] = formData.get("password");
    e.preventDefault();
    fetch(`${URL}/auth/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then((response) => {
        response.text().then((text) => {
            localStorage.setItem("token", text);
            location.href = "main.html";
        })
    });
}