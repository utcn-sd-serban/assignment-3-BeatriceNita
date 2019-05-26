import React from "react";

const CreateQuestion = ({ title, text, author, tag, onCreateQuestion, onChange }) => (
    <div>
        <h1 class="text bg-info">Ask Question</h1>
        <p class="text-info">Fill in the requested info</p>
        <div>
            <label>Title: </label>
            <input value={title} onChange={ e => onChange("title", e.target.value)} />
            <br />
            <label>Text: </label>
            <input value={text} onChange={ e => onChange("text", e.target.value)} />
            <br />
            <label>Author: </label>
            <input value={author} onChange={ e => onChange("author", e.target.value)} />
            <br />
            <label>Tag: </label>
            <input value={tag} onChange={ e => onChange("tag", e.target.value)} />
            <br />
            <button type="button" class="btn btn-info" onClick = {onCreateQuestion}>Create!</button>
        </div>
    </div>
);

export default CreateQuestion;
