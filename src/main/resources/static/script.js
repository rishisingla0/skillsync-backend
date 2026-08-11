async function createUser() {

    const user = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
    };

    const response = await fetch("/api/users", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    });

    const result = await response.text();

    document.getElementById("result").innerText = result;
}

async function createSkill() {
    const skill = {
        name: document.getElementById("skillName").value,
    };
    const response = await fetch("/api/skills", {
        method: "POST",
        headers: {
            "Content-Type": "application/json" 
        },
        body: JSON.stringify(skill)
    });
    const result = await response.text();
    document.getElementById("skillResult").innerText = result;
}

async function createProject() {
    const userId = document.getElementById("projectUserId").value; 
    const project = {
        title: document.getElementById("projectTitle").value,
        description: document.getElementById("projectDescription").value,
    };
    const response = await fetch(`/api/users/${userId}/projects`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(project)
    });
    const result = await response.text();
    document.getElementById("projectResult").innerText = result;
}

async function assignSkill() {
    const userId = document.getElementById("assignUserId").value;
    const skillId = document.getElementById("assignSkillId").value;

    const response = await fetch(
        `/api/users/${userId}/skills/${skillId}`,
        {
            method: "POST"
        }
    );
    const result = await response.text();
    document.getElementById("assignResult").innerText = result;
}

async function searchProjects() {
    const skill = document.getElementById("searchSkill").value;
    const response = await fetch(
        `/api/projects/search?skill=${skill}`
    );
    const projects = await response.json();
    let html = "";
    projects.forEach(project => {
        html += `
        <div>
        <h3>${project.title}</h3>
        <p>${project.description}</p>
        </div>
        <hr>
        `;
    });
    document.getElementById("searchResults").innerHTML = html;
}