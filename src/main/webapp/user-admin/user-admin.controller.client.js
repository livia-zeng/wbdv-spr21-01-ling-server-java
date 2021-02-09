var $usernameFld
var $passwordFld
var $firstNameFld
var $lastNameFld
var $roleFld

var $createBtn
var theTableBody
var $updateBtn

var userService = new AdminUserServiceClient()
var selectedUser = null
var users = []

function init() {
    $usernameFld = $(".wblz-usernameFld")
    $passwordFld = $(".wblz-passwordFld")
    $firstNameFld = $(".wblz-firstNameFld")
    $lastNameFld = $(".wblz-lastNameFld")
    $roleFld = $(".wblz-roleFld")

    $createBtn = $(".wblz-create-btn")
    $updateBtn = $(".wblz-update-btn")
    theTableBody = jQuery("tbody")
    $updateBtn.click(updateUser)
    $createBtn.click(createUser)
    users = userService.findAllUsers().then(function (actualUsersFromServer) {
        users = actualUsersFromServer;
        renderUsers(users)
    })
}

function clearInput() {
    $usernameFld.val("")
    $passwordFld.val("")
    $firstNameFld.val("")
    $lastNameFld.val("")
    $roleFld.val('FACULTY');
}

function renderUsers(users) {
    theTableBody.empty()
    clearInput();
    for (var i = 0; i < users.length; i++) {
        var user = users[i];
        theTableBody
            .prepend(`
    <tr class="wblz-template wblz-user wblz-hidden">
        <td class="wblz-username">${user.username}</td>
        <td>&nbsp;</td>
        <td class="wblz-first-name">${user.firstName}</td>
        <td class="wblz-last-name">${user.lastName}</td>
        <td class="wblz-role">${user.role}</td>
        <td class="wblz-actions">
        <span class="pull-right">
          <i id="${i}" class="fa-2x fa fa-times wblz-delete"></i>
          <i id="${user._id}" class="fa-2x fa fa-pencil wblz-select"></i>
        </span>
        </td>
      </tr>
  `)
    }
    jQuery(".wblz-delete")
        .click(deleteUser)
    jQuery(".wblz-select")
        .click(selectUser)
}


function createUser() {
    if ($usernameFld.val() === "" || $passwordFld.val() === "" || $firstNameFld.val() === "" || $lastNameFld === "")
        alert("Please enter user information.")
    else {
        var newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        }
        userService.createUser(newUser)
            .then(function (actualUser) {
                users.push(actualUser)
                renderUsers(users)
            })
    }
}

function deleteUser(event) {
    var deleteBtn = jQuery(event.target)
    var theIndex = deleteBtn.attr("id")
    var theId = users[theIndex]._id

    userService.deleteUser(theId)
        .then(function (status) {
            users.splice(theIndex, 1)
            renderUsers(users)
        })
}


function selectUser(event) {
    var selectBtn = jQuery(event.target)
    var id = selectBtn.attr("id")
    selectedUser = users.find(user => user._id === id)
    $usernameFld.val(selectedUser.username)
    $passwordFld.val(selectedUser.password)
    $firstNameFld.val(selectedUser.firstName)
    $lastNameFld.val(selectedUser.lastName)
    $roleFld.val(selectedUser.role)
}

function updateUser() {
    if (selectedUser === null) alert("You haven't select users to be updated!!")
    else {
        selectedUser.username = $usernameFld.val()
        selectedUser.password = $passwordFld.val()
        selectedUser.firstName = $firstNameFld.val()
        selectedUser.lastName = $lastNameFld.val()
        selectedUser.role = $roleFld.val()
        userService.updateUser(selectedUser._id, selectedUser).then(status => {
            var index = users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser;
            renderUsers(users)
        })
    }
}

jQuery(init)
