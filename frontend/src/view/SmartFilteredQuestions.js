import React, { Component } from "react";
import model from "../model/model";
import FilteredQuestions from "./FilteredQuestions";

const mapModelStateToComponentState = modelState => ({
    searchQuestions:modelState.searchQuestions
});

export default class SmartFilteredQuestions extends Component {
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
            <FilteredQuestions
            questions={this.state.searchQuestions}/>
        );
    }
}