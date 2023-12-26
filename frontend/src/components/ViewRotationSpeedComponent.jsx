import React, { Component } from 'react'
import RotationSpeedService from '../services/RotationSpeedService'

class ViewRotationSpeedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            rotationSpeed: {}
        }
    }

    componentDidMount(){
        RotationSpeedService.getRotationSpeedById(this.state.id).then( res => {
            this.setState({rotationSpeed: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RotationSpeed Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.rotationSpeed.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.rotationSpeed.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.rotationSpeed.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.rotationSpeed.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.rotationSpeed.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRotationSpeedComponent
