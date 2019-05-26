import React, { Component } from "react";
import model from "../model/model";
import CreateQuestion from "./CreateQuestion";
import createQuestionPresenter from "../presenter/createQuestionPresenter";

const mapModelStateToComponentState = modelState => ({
    title: modelState.newQuestion.title,
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
                onCreateQuestion={createQuestionPresenter.onCreateQuestion}
                onChange={createQuestionPresenter.onChange}
                title={this.state.title}
                text={this.state.text} 
                creationDate={this.state.creationDate}
                author={this.state.author}
                tag={this.state.tag}/>
        );
    }
}