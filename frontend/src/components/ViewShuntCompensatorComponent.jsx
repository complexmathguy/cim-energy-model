import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService'

class ViewShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            shuntCompensator: {}
        }
    }

    componentDidMount(){
        ShuntCompensatorService.getShuntCompensatorById(this.state.id).then( res => {
            this.setState({shuntCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ShuntCompensator Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> aVRDelay:&emsp; </label>
                            <div> { this.state.shuntCompensator.aVRDelay }</div>
                        </div>
                        <div className = "row">
                            <label> grounded:&emsp; </label>
                            <div> { this.state.shuntCompensator.grounded }</div>
                        </div>
                        <div className = "row">
                            <label> maximumSections:&emsp; </label>
                            <div> { this.state.shuntCompensator.maximumSections }</div>
                        </div>
                        <div className = "row">
                            <label> nomU:&emsp; </label>
                            <div> { this.state.shuntCompensator.nomU }</div>
                        </div>
                        <div className = "row">
                            <label> normalSections:&emsp; </label>
                            <div> { this.state.shuntCompensator.normalSections }</div>
                        </div>
                        <div className = "row">
                            <label> switchOnCount:&emsp; </label>
                            <div> { this.state.shuntCompensator.switchOnCount }</div>
                        </div>
                        <div className = "row">
                            <label> switchOnDate:&emsp; </label>
                            <div> { this.state.shuntCompensator.switchOnDate }</div>
                        </div>
                        <div className = "row">
                            <label> voltageSensitivity:&emsp; </label>
                            <div> { this.state.shuntCompensator.voltageSensitivity }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewShuntCompensatorComponent
