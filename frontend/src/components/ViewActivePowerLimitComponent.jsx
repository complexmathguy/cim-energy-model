import React, { Component } from 'react'
import ActivePowerLimitService from '../services/ActivePowerLimitService'

class ViewActivePowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            activePowerLimit: {}
        }
    }

    componentDidMount(){
        ActivePowerLimitService.getActivePowerLimitById(this.state.id).then( res => {
            this.setState({activePowerLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ActivePowerLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.activePowerLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewActivePowerLimitComponent
