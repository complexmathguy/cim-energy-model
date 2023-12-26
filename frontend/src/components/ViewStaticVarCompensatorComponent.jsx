import React, { Component } from 'react'
import StaticVarCompensatorService from '../services/StaticVarCompensatorService'

class ViewStaticVarCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            staticVarCompensator: {}
        }
    }

    componentDidMount(){
        StaticVarCompensatorService.getStaticVarCompensatorById(this.state.id).then( res => {
            this.setState({staticVarCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StaticVarCompensator Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> capacitiveRating:&emsp; </label>
                            <div> { this.state.staticVarCompensator.capacitiveRating }</div>
                        </div>
                        <div className = "row">
                            <label> inductiveRating:&emsp; </label>
                            <div> { this.state.staticVarCompensator.inductiveRating }</div>
                        </div>
                        <div className = "row">
                            <label> slope:&emsp; </label>
                            <div> { this.state.staticVarCompensator.slope }</div>
                        </div>
                        <div className = "row">
                            <label> sVCControlMode:&emsp; </label>
                            <div> { this.state.staticVarCompensator.sVCControlMode }</div>
                        </div>
                        <div className = "row">
                            <label> voltageSetPoint:&emsp; </label>
                            <div> { this.state.staticVarCompensator.voltageSetPoint }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStaticVarCompensatorComponent
