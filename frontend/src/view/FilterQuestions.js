import React from "react";

const FilterQuestions = ({  onFilteredQuestions, onChangeToSearch }) => (
    <div>
        <h1 class="text bg-primary">Filter Questions</h1>
        <div>
            <label>Title to search: </label>
            <input onChange={e =>onChangeToSearch("toSearch",e.target.value)} />
            <br />
            <button type="button" class="btn btn-primary" onClick = {onFilteredQuestions}>Search</button>
        </div>
    </div>
);

export default FilterQuestions;
