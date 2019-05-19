import React, { Component } from "react";
import model from "../model/model";
import CreateQuestion from "./CreateQuestion";
import questionsListPresenter from "../presenter/questionsListPresenter";

const mapModelStateToComponentState = modelState => ({
    titleQ: modelState.newQuestion.titleQ,
    text: modelState.newQuestion.text,
    creationDate: modelState.newQuestion.creationDate,
    author: modelState.newQuestion.author,
    tag: modelState.newQuestion.tag
});

export default class SmartCreateQuestion extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <CreateQuestion
                onCreateQuestion={questionsListPresenter.onCreateQuestion}
                onChange={questionsListPresenter.onChange}
                titleQ={this.state.titleQ}
                text={this.state.text} 
                creationDate={this.state.creationDate}
                author={this.state.author}
                tag={this.state.tag}/>
        );
    }
}