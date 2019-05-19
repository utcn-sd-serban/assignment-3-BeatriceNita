import React from "react";
import SmartListAllQuestions from './view/SmartListAllQuestions';
import SmartCreateQuestion from './view/SmartCreateQuestion';

import './App.css';

import { HashRouter, Switch, Route} from "react-router-dom";

const App = () =>(
<div className="App">
        <HashRouter>
          <Switch>
            <Route exact={true} component={SmartListAllQuestions} path="/" />
            <Route exact={true} component={SmartCreateQuestion} path="/create-question" />
          </Switch>
        </HashRouter>     
</div>
);


export default App;

