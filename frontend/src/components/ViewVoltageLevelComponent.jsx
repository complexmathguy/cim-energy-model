import React, { Component } from 'react'
import VoltageLevelService from '../services/VoltageLevelService'

class ViewVoltageLevelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageLevel: {}
        }
    }

    componentDidMount(){
        VoltageLevelService.getVoltageLevelById(this.state.id).then( res => {
            this.setState({voltageLevel: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageLevel Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> highVoltageLimit:&emsp; </label>
                            <div> { this.state.voltageLevel.highVoltageLimit }</div>
                        </div>
                        <div className = "row">
                            <label> lowVoltageLimit:&emsp; </label>
                            <div> { this.state.voltageLevel.lowVoltageLimit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageLevelComponent
