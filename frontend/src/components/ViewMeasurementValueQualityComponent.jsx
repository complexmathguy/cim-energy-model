import React, { Component } from 'react'
import MeasurementValueQualityService from '../services/MeasurementValueQualityService'

class ViewMeasurementValueQualityComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            measurementValueQuality: {}
        }
    }

    componentDidMount(){
        MeasurementValueQualityService.getMeasurementValueQualityById(this.state.id).then( res => {
            this.setState({measurementValueQuality: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MeasurementValueQuality Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMeasurementValueQualityComponent
