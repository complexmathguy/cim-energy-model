import React, { Component } from 'react'
import RatioTapChangerService from '../services/RatioTapChangerService'

class ViewRatioTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            ratioTapChanger: {}
        }
    }

    componentDidMount(){
        RatioTapChangerService.getRatioTapChangerById(this.state.id).then( res => {
            this.setState({ratioTapChanger: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RatioTapChanger Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> stepVoltageIncrement:&emsp; </label>
                            <div> { this.state.ratioTapChanger.stepVoltageIncrement }</div>
                        </div>
                        <div className = "row">
                            <label> tculControlMode:&emsp; </label>
                            <div> { this.state.ratioTapChanger.tculControlMode }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRatioTapChangerComponent
