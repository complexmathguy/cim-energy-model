import React, { Component } from 'react'
import ActivePowerPerFrequencyService from '../services/ActivePowerPerFrequencyService'

class ViewActivePowerPerFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            activePowerPerFrequency: {}
        }
    }

    componentDidMount(){
        ActivePowerPerFrequencyService.getActivePowerPerFrequencyById(this.state.id).then( res => {
            this.setState({activePowerPerFrequency: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ActivePowerPerFrequency Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.activePowerPerFrequency.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.activePowerPerFrequency.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.activePowerPerFrequency.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.activePowerPerFrequency.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.activePowerPerFrequency.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewActivePowerPerFrequencyComponent
