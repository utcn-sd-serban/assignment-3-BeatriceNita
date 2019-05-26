import modelUser from "../model/modelUser";

class UsersLoginPresenter {
    onChange(property, value) {
        modelUser.changeNewUserProperty(property, value);
    }

    onLogin() {
        for (let index = 0; index < modelUser.state.users.length; index++) {
            if (modelUser.state.users[index].username === modelUser.state.currentUser.username) {
                window.location.assign("#/questions-ops");
            }
        }
    }
}

const usersLoginPresenter = new UsersLoginPresenter();

export default usersLoginPresenter;

