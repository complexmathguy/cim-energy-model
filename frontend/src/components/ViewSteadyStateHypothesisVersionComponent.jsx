import React, { Component } from 'react'
import SteadyStateHypothesisVersionService from '../services/SteadyStateHypothesisVersionService'

class ViewSteadyStateHypothesisVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            steadyStateHypothesisVersion: {}
        }
    }

    componentDidMount(){
        SteadyStateHypothesisVersionService.getSteadyStateHypothesisVersionById(this.state.id).then( res => {
            this.setState({steadyStateHypothesisVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SteadyStateHypothesisVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURI:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.baseURI }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURI:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.entsoeURI }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.steadyStateHypothesisVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSteadyStateHypothesisVersionComponent
