import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService'

class ViewProprietaryParameterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            proprietaryParameterDynamics: {}
        }
    }

    componentDidMount(){
        ProprietaryParameterDynamicsService.getProprietaryParameterDynamicsById(this.state.id).then( res => {
            this.setState({proprietaryParameterDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ProprietaryParameterDynamics Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> booleanParameterValue:&emsp; </label>
                            <div> { this.state.proprietaryParameterDynamics.booleanParameterValue }</div>
                        </div>
                        <div className = "row">
                            <label> floatParameterValue:&emsp; </label>
                            <div> { this.state.proprietaryParameterDynamics.floatParameterValue }</div>
                        </div>
                        <div className = "row">
                            <label> integerParameterValue:&emsp; </label>
                            <div> { this.state.proprietaryParameterDynamics.integerParameterValue }</div>
                        </div>
                        <div className = "row">
                            <label> parameterNumber:&emsp; </label>
                            <div> { this.state.proprietaryParameterDynamics.parameterNumber }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewProprietaryParameterDynamicsComponent
