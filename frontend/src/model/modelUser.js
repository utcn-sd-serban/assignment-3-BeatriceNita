import { EventEmitter } from "events";

class ModelUser extends EventEmitter {
    constructor() {
        super();
        this.state = {
            users: [{ 
                username:"otto",
                password:"food"
            }],
                currentUser: {
                username: "",
                password: ""
             }
        };
    }


    /*addUser(username, password) {
        this.state = {
            ...this.state,
            users: this.state.users.concat([{
                username: username,
                password: password
            }])
        };
        this.emit("change", this.state);
    }*/

    changeNewUserProperty(property, value) {
        this.state = {
            ...this.state,
            currentUser: {
                ...this.state.currentUser,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }
}

//singleton
const modelUser = new ModelUser();

export default modelUser;