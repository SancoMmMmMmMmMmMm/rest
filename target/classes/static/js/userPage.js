$(async function() {
    await thisUser();
});
async function thisUser() {

    fetch("/api/user/getUserInfo")
        .then(res => res.json())
        .then(data => {
            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>
                    <td>${data.email}</td>
                    <td>${data.roles.map(role => " " + role.name.substring(5))}</td>
                </tr>
            )`;
            $('#userPanelBody').append(user);
        })
}






