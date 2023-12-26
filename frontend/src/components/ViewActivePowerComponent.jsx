import React, { Component } from 'react'
import ActivePowerService from '../services/ActivePowerService'

class ViewActivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            activePower: {}
        }
    }

    componentDidMount(){
        ActivePowerService.getActivePowerById(this.state.id).then( res => {
            this.setState({activePower: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ActivePower Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.activePower.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.activePower.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.activePower.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewActivePowerComponent
