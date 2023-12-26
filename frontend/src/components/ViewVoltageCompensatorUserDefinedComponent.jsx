import React, { Component } from 'react'
import VoltageCompensatorUserDefinedService from '../services/VoltageCompensatorUserDefinedService'

class ViewVoltageCompensatorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageCompensatorUserDefined: {}
        }
    }

    componentDidMount(){
        VoltageCompensatorUserDefinedService.getVoltageCompensatorUserDefinedById(this.state.id).then( res => {
            this.setState({voltageCompensatorUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageCompensatorUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.voltageCompensatorUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageCompensatorUserDefinedComponent
