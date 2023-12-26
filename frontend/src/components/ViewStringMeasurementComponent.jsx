import React, { Component } from 'react'
import StringMeasurementService from '../services/StringMeasurementService'

class ViewStringMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            stringMeasurement: {}
        }
    }

    componentDidMount(){
        StringMeasurementService.getStringMeasurementById(this.state.id).then( res => {
            this.setState({stringMeasurement: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StringMeasurement Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStringMeasurementComponent
