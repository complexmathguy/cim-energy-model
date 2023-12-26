import React, { Component } from 'react'
import MeasurementValueSourceService from '../services/MeasurementValueSourceService'

class ViewMeasurementValueSourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            measurementValueSource: {}
        }
    }

    componentDidMount(){
        MeasurementValueSourceService.getMeasurementValueSourceById(this.state.id).then( res => {
            this.setState({measurementValueSource: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MeasurementValueSource Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMeasurementValueSourceComponent
