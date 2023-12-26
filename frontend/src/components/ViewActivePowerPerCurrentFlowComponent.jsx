import React, { Component } from 'react'
import ActivePowerPerCurrentFlowService from '../services/ActivePowerPerCurrentFlowService'

class ViewActivePowerPerCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            activePowerPerCurrentFlow: {}
        }
    }

    componentDidMount(){
        ActivePowerPerCurrentFlowService.getActivePowerPerCurrentFlowById(this.state.id).then( res => {
            this.setState({activePowerPerCurrentFlow: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ActivePowerPerCurrentFlow Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.activePowerPerCurrentFlow.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.activePowerPerCurrentFlow.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.activePowerPerCurrentFlow.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.activePowerPerCurrentFlow.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.activePowerPerCurrentFlow.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewActivePowerPerCurrentFlowComponent
