import React, { Component } from 'react'
import VolumeFlowRateService from '../services/VolumeFlowRateService'

class ViewVolumeFlowRateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            volumeFlowRate: {}
        }
    }

    componentDidMount(){
        VolumeFlowRateService.getVolumeFlowRateById(this.state.id).then( res => {
            this.setState({volumeFlowRate: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VolumeFlowRate Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.volumeFlowRate.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.volumeFlowRate.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.volumeFlowRate.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.volumeFlowRate.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.volumeFlowRate.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVolumeFlowRateComponent
