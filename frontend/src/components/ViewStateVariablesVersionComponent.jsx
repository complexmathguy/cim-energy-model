import React, { Component } from 'react'
import StateVariablesVersionService from '../services/StateVariablesVersionService'

class ViewStateVariablesVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            stateVariablesVersion: {}
        }
    }

    componentDidMount(){
        StateVariablesVersionService.getStateVariablesVersionById(this.state.id).then( res => {
            this.setState({stateVariablesVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StateVariablesVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURI:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.baseURI }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURI:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.entsoeURI }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.stateVariablesVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStateVariablesVersionComponent
