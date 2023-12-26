import React, { Component } from 'react'
import RotatingMachineService from '../services/RotatingMachineService'

class ViewRotatingMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            rotatingMachine: {}
        }
    }

    componentDidMount(){
        RotatingMachineService.getRotatingMachineById(this.state.id).then( res => {
            this.setState({rotatingMachine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RotatingMachine Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ratedPowerFactor:&emsp; </label>
                            <div> { this.state.rotatingMachine.ratedPowerFactor }</div>
                        </div>
                        <div className = "row">
                            <label> ratedS:&emsp; </label>
                            <div> { this.state.rotatingMachine.ratedS }</div>
                        </div>
                        <div className = "row">
                            <label> ratedU:&emsp; </label>
                            <div> { this.state.rotatingMachine.ratedU }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRotatingMachineComponent
