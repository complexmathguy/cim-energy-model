import React, { Component } from 'react'
import SvVoltageService from '../services/SvVoltageService'

class ViewSvVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svVoltage: {}
        }
    }

    componentDidMount(){
        SvVoltageService.getSvVoltageById(this.state.id).then( res => {
            this.setState({svVoltage: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvVoltage Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> angle:&emsp; </label>
                            <div> { this.state.svVoltage.angle }</div>
                        </div>
                        <div className = "row">
                            <label> v:&emsp; </label>
                            <div> { this.state.svVoltage.v }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvVoltageComponent
