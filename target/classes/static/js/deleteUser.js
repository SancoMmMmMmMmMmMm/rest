$(async function () {
    deleteUser();
});

function deleteUser() {
    const deleteForm = document.forms["formDeleteUser"];

    deleteForm.addEventListener("submit", ev => {
        ev.preventDefault();
        console.log(deleteForm.id.value);

        fetch("/api/admin/delete/" + deleteForm.id.value, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            $('#deleteFormCloseButton').click();
            allUsers();
        })
    })
}

async function getUser(id) {
    let url = "/api/user/" + id;
    let response = await fetch(url);
    return await response.json();
}


$('#delete').on('show.bs.modal', ev => {
    let button = $(ev.relatedTarget);
    let id = button.data('id');
    showDeleteModal(id);
})

async function showDeleteModal(id) {
    $('#deleteRoles').empty();
    let user = await getUser(id);
    let form = document.forms["formDeleteUser"];

    form.id.value = user.id;
    form.name.value = user.name;
    form.lastName.value = user.lastName;
    form.age.value = user.age;
    form.email.value = user.email;

    await fetch("/api/admin/roles")
        .then(res => res.json())
        .then(roles => {
            roles.forEach(role => {
                let selectedRole = false;
                for (let i = 0; i < user.roles.length; i++) {
                    if (user.roles[i].name === role.name) {
                        selectedRole = true;
                        break;
                    }
                }
                let el = document.createElement("option");
                el.text = role.name;
                el.value = role.id;
                if (selectedRole) el.selected = true;
                $('#deleteRoles')[0].appendChild(el);
            })
        })
}