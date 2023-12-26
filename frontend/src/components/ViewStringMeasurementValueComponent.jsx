import React, { Component } from 'react'
import StringMeasurementValueService from '../services/StringMeasurementValueService'

class ViewStringMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            stringMeasurementValue: {}
        }
    }

    componentDidMount(){
        StringMeasurementValueService.getStringMeasurementValueById(this.state.id).then( res => {
            this.setState({stringMeasurementValue: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StringMeasurementValue Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.stringMeasurementValue.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStringMeasurementValueComponent
