import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService'

class ViewPowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerTransformer: {}
        }
    }

    componentDidMount(){
        PowerTransformerService.getPowerTransformerById(this.state.id).then( res => {
            this.setState({powerTransformer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerTransformer Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> beforeShCircuitHighestOperatingCurrent:&emsp; </label>
                            <div> { this.state.powerTransformer.beforeShCircuitHighestOperatingCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> beforeShCircuitHighestOperatingVoltage:&emsp; </label>
                            <div> { this.state.powerTransformer.beforeShCircuitHighestOperatingVoltage }</div>
                        </div>
                        <div className = "row">
                            <label> beforeShortCircuitAnglePf:&emsp; </label>
                            <div> { this.state.powerTransformer.beforeShortCircuitAnglePf }</div>
                        </div>
                        <div className = "row">
                            <label> highSideMinOperatingU:&emsp; </label>
                            <div> { this.state.powerTransformer.highSideMinOperatingU }</div>
                        </div>
                        <div className = "row">
                            <label> isPartOfGeneratorUnit:&emsp; </label>
                            <div> { this.state.powerTransformer.isPartOfGeneratorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> operationalValuesConsidered:&emsp; </label>
                            <div> { this.state.powerTransformer.operationalValuesConsidered }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerTransformerComponent
