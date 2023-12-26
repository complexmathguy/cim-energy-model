import React, { Component } from 'react'
import MeasurementValueService from '../services/MeasurementValueService'

class ViewMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            measurementValue: {}
        }
    }

    componentDidMount(){
        MeasurementValueService.getMeasurementValueById(this.state.id).then( res => {
            this.setState({measurementValue: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MeasurementValue Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sensorAccuracy:&emsp; </label>
                            <div> { this.state.measurementValue.sensorAccuracy }</div>
                        </div>
                        <div className = "row">
                            <label> timeStamp:&emsp; </label>
                            <div> { this.state.measurementValue.timeStamp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMeasurementValueComponent
