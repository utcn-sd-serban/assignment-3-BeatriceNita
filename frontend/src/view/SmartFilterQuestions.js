import React, { Component } from "react";
import model from "../model/model";
import FilterQuestions from "./FilterQuestions";
import questionsListPresenter from "../presenter/questionsListPresenter";

const mapModelStateToComponentState = modelState => ({
   
});

export default class SmartFilterQuestions extends Component {
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
            <FilterQuestions
                onFilteredQuestions={questionsListPresenter.onFilteredQuestions}
                onChangeToSearch={questionsListPresenter.changeToSearch} />
        );
    }
}