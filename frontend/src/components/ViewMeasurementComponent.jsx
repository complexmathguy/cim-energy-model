import React, { Component } from 'react'
import MeasurementService from '../services/MeasurementService'

class ViewMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            measurement: {}
        }
    }

    componentDidMount(){
        MeasurementService.getMeasurementById(this.state.id).then( res => {
            this.setState({measurement: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Measurement Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> measurementType:&emsp; </label>
                            <div> { this.state.measurement.measurementType }</div>
                        </div>
                        <div className = "row">
                            <label> phases:&emsp; </label>
                            <div> { this.state.measurement.phases }</div>
                        </div>
                        <div className = "row">
                            <label> unitMultiplier:&emsp; </label>
                            <div> { this.state.measurement.unitMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unitSymbol:&emsp; </label>
                            <div> { this.state.measurement.unitSymbol }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMeasurementComponent
