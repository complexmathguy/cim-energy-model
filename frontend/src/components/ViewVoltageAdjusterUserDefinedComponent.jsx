import React, { Component } from 'react'
import VoltageAdjusterUserDefinedService from '../services/VoltageAdjusterUserDefinedService'

class ViewVoltageAdjusterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageAdjusterUserDefined: {}
        }
    }

    componentDidMount(){
        VoltageAdjusterUserDefinedService.getVoltageAdjusterUserDefinedById(this.state.id).then( res => {
            this.setState({voltageAdjusterUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageAdjusterUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.voltageAdjusterUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageAdjusterUserDefinedComponent
